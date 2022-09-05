import java.util.Scanner;

public class Main {
    static int r, c;
    static char[][] board;

    static char startColor, endColor;
    static char firstColor, secondColor; // 1, 2 번째 점프 지점의 색깔

    // initialize
    static void intialize() {
        startColor = board[1][1];
        endColor = board[r][c];

        if (startColor == 'W') {
            firstColor = 'B';
            secondColor = 'W';
        } else {
            firstColor = 'W';
            secondColor = 'B';
        }
    }

    // brute force
    static int bruteForce() {
        if (startColor == endColor) {
            return 0;
        }

        int cnt = 0;
        for (int i = 2; i <= r - 2; i++) {
            for (int j = 2; j <= c - 2; j++) {
                for (int k = i + 1; k <= r - 1; k++) {
                    for (int l = j + 1; l <= c - 1; l++) {
                        if (board[i][j] == firstColor && board[k][l] == secondColor) {
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        // 초기화
        intialize();

        // 완전탐색
        int ans = bruteForce();

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 15;

    public static int n, m;
    public static char[][] grid = new char[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }

        // 이동 시에 행과 열이 전부 증가하도록
        // 모든 쌍을 다 잡아봅니다.
        int cnt = 0;
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                for (int k = i + 1; k < n - 1; k++)
                    for (int l = j + 1; l < m - 1; l++)
                        // 그 중 색깔이 전부 달라지는 경우에만 개수를 세줍니다.
                        if (grid[0][0] != grid[i][j] &&
                                grid[i][j] != grid[k][l] &&
                                grid[k][l] != grid[n - 1][m - 1])
                            cnt++;

        System.out.println(cnt);
    }
}