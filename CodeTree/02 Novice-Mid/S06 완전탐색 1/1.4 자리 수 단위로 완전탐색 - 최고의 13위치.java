import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 완전탐색
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int currCnt = board[i][j] + board[i][j + 1] + board[i][j + 2];
                maxCnt = Math.max(maxCnt, currCnt);
            }
        }

        // 출력
        System.out.println(maxCnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 20;

    public static int n;
    public static int[][] arr = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        // 모든 쌍을 다 잡아봅니다.
        int maxCnt = 0;
        for (int i = 0; i < n; i++)
            // 격자를 벗어나지 않을 범위로만 잡습니다.
            for (int j = 0; j < n - 2; j++) {
                int cnt = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                maxCnt = Math.max(maxCnt, cnt);
            }

        System.out.println(maxCnt);
    }
}