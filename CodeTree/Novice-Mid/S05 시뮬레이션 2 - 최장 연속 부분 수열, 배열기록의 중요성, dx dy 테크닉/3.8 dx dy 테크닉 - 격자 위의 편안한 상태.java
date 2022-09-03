import java.util.Scanner;

public class Main {
    static final int DIR_NUM = 4;
    static final int MAX_N = 100;

    static int[][] board = new int[MAX_N + 1][MAX_N + 1];
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int dirNum;

    static int n;
    static int r, c;

    // inRange
    static boolean inRange(int x, int y) {
        return (x >= 1 && x <= n) && (y >= 1 && y <= n);
    }

    // check
    static boolean check() {
        int cnt = 0;

        dirNum = 0;
        for (int i = 0; i < DIR_NUM; i++) {
            int nx = r + dx[dirNum];
            int ny = c + dy[dirNum];
            dirNum = (dirNum + 1) % DIR_NUM; // 필요 없는 문장

            if (inRange(nx, ny) && board[nx][ny] == 1) {
                cnt++;
            }
        }

        return cnt == 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        int m = sc.nextInt(); // 시뮬레이션 횟수

        // 시뮬레이션
        for (int i = 0; i < m; i++) {
            r = sc.nextInt();
            c = sc.nextInt();
            board[r][c] = 1;

            boolean comfortable = check();

            if (comfortable) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
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

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int adjacentCnt(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (inRange(nx, ny) && arr[nx][ny] == 1)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            x--;
            y--;
            arr[x][y] = 1;
            // 해당 칸을 탐색합니다.
            if (adjacentCnt(x, y) == 3)
                System.out.println(1);
            else
                System.out.println(0);
        }

    }
}