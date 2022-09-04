import java.util.Scanner;

public class Main {
    static int board[][];
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int moveDir = 1;

    static int n, m;
    static int cx = -1, cy = 0;

    // inRange
    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    // simulation
    static void simulate() {
        int num = 1;

        while (num <= n * m) {
            int nx = cx + dx[moveDir];
            int ny = cy + dy[moveDir];

            // case 1
            if (inRange(nx, ny) && board[nx][ny] == 0) {
                cx = nx;
                cy = ny;
                board[cx][cy] = num++;
            }
            // case 2
            else {
                moveDir = (moveDir - 1 + 4) % 4;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        // 시뮬레이션
        simulate();

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;

    public static int n, m;
    public static int[][] arr = new int[MAX_N][MAX_N];

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static int currX, currY;  // 시작은 (0, 0) 입니다.
    public static int dir = 1;       // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        // 처음 시작 위치에 초기값을 적습니다.
        arr[currX][currY] = 1;

        // n*m개의 숫자를 적어야 합니다.
        for (int i = 2; i <= n * m; i++) { // 숫자 i를 어디에 적을지 결정합니다.
            while (true) { // 나아갈 수 있을때까지 방향을 바꿔가며 확인해봅니다.
                // 현재 방향 dir를 기준으로 그 다음 위치 값을 계산합니다.
                int nx = currX + dx[dir];
                int ny = currY + dy[dir];

                // 그 위치로 나아갈 수 있는지 확인합니다.
                if (inRange(nx, ny) && arr[nx][ny] == 0) {
                    // 나아갈 수 있다면 위치를 갱신해주고 배열에 올바른 값을 채워넣습니다.
                    currX = nx;
                    currY = ny;
                    arr[currX][currY] = i;
                    break;
                } else {
                    // 나아갈 수 없다면 반시계방향으로 90'를 회전하여
                    // 그 다음 방향을 확인해봐야 합니다.
                    dir = (dir + 3) % 4;
                }
            }
        }

        // 출력:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}