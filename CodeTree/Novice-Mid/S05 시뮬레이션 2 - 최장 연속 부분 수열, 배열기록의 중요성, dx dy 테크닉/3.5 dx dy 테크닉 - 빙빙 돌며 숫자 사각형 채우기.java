import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;

    static int[][] board = new int[MAX_N][MAX_N];
    static int n, m;
    static int x = 0, y = 0;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int dirNum = 0;

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        board[0][0] = 1;

        // 보드판 순회하면서 숫자 채우기
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 이동 불가능한 경우: 시계방향 90도 회전
            if (!inRange(nx, ny) || board[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4;
            }

            // 방향 정하고 이동
            x = x + dx[dirNum];
            y = y + dy[dirNum];
            board[x][y] = i;
        }

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
    public static final int MAX_NUM = 100;
    public static final int DIR_NUM = 4;

    public static int n, m;
    public static int[][] arr = new int[MAX_NUM][MAX_NUM];

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static int currX = 0, currY = 0;  // 시작은 (0, 0) 입니다.
    public static int dir = 0;               // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 처음 시작 위치에 초기값을 적습니다.
        arr[currX][currY] = 1;

        // n*m개의 숫자를 적어야 합니다.
        for (int i = 2; i <= n * m; i++) { // 숫자 i를 어디에 적을지 결정합니다.
            // 현재 방향 dir를 기준으로 그 다음 위치 값을 계산합니다.
            int nextX = currX + dx[dir], nextY = currY + dy[dir];

            // 더 이상 나아갈 수 없다면
            // 시계방향으로 90'를 회전합니다.
            if (!inRange(nextX, nextY) || arr[nextX][nextY] != 0)
                dir = (dir + 1) % 4;

            // 그 다음 위치로 이동한 다음 배열에 올바른 값을 채워넣습니다.
            currX = currX + dx[dir];
            currY = currY + dy[dir];
            arr[currX][currY] = i;
        }

        // 출력:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

// 수정 1 - canGo 함수로 정리
import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;

    static int[][] board = new int[MAX_N][MAX_N];
    static int n, m;
    static int x = 0, y = 0;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int dirNum = 0;

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && board[x][y] == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 보드판 순회하면서 숫자 채우기
        int num = 1;
        board[0][0] = 1;
        num++;

        while (num <= n * m) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 이동 불가능한 경우: 시계방향 90도 회전
            if (!canGo(nx, ny)) {
                dirNum = (dirNum + 1) % 4;
            }

            // 방향 정하고 이동
            x = x + dx[dirNum];
            y = y + dy[dirNum];
            board[x][y] = num++; // 칸에 숫자 써주기
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}