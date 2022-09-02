import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1 ,0};

    static int[][] board;
    static int n;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 보드판 순회하면서 카운팅
        int ans = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // dx, dy 순회
                int cnt = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (inRange(nx, ny) && board[nx][ny] == 1) {
                        cnt++;
                    }
                }

                // 인접 숫자 중 1의 개수가 3이상이라면 정답 +1
                if (cnt >= 3) {
                    ans++;
                }
            }
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int DIR_NUM = 4;

    public static int n;
    public static int[][] arr = new int[MAX_N][MAX_N];

    public static int[] dx = new int[]{0, 1,  0, -1};
    public static int[] dy = new int[]{1, 0, -1,  0};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int adjacentCnt(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < DIR_NUM; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny) && arr[nx][ny] == 1)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        // 각 칸을 탐색합니다.
        int ans = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(adjacentCnt(i, j) >= 3)
                    ans++;

        System.out.println(ans);
    }
}