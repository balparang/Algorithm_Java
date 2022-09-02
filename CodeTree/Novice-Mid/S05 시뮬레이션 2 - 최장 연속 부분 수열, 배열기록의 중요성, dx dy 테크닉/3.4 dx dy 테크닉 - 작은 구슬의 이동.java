import java.util.Scanner;

public class Main {
    static final int MAX_N = 50;
    static final int MAX_DIR = 4;

    static int n, t, curY, curX;
    static char cDir; // U D R L
    static int[][] board = new int[MAX_N + 1][MAX_N + 1];

    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{1, 0, 0, -1};


    // 방향에 따라 moveDir 변경
    static int getDir(char cDir) {
        if (cDir == 'R') {
            return 0;
        } else if (cDir == 'D') {
            return 1;
        } else if (cDir == 'U') {
            return 2;
        } else { // U
            return 3;
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        t = sc.nextInt();
        curX = sc.nextInt(); // 행, 열을 인덱스 번호와 같게
        curY = sc.nextInt();
        cDir = sc.next().charAt(0);
        int moveDir = getDir(cDir);

        // 이동
        for (int i = 0; i < t; i++) {
            int nx = curX + dx[moveDir];
            int ny = curY + dy[moveDir];

            // 이동해도 되는지 확인하고 이동
            if (inRange(nx, ny)) {
                curX = nx;
                curY = ny;
            }
            // 이동할 수 없으면 반대편 방향을 바라본다.
            else {
                moveDir = 3 - moveDir;
            }
        }

        System.out.println(curX + " " + curY);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int ASCII_NUM = 128;
    public static final int DIR_NUM = 4;

    public static int n, t;
    public static int x, y, dir;
    public static int[] mapper = new int[ASCII_NUM];

    public static int[] dx = new int[]{0, 1, -1,  0};
    public static int[] dy = new int[]{1, 0,  0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void simulate() {
        while(t-- > 0) {
            int nx = x + dx[dir], ny = y + dy[dir];
            // 범위 안에 들어온다면 그대로 진행합니다.
            if(inRange(nx, ny)) {
                x = nx; y = ny;
            }
            // 벽에 부딪힌다면, 방향을 바꿔줍니다.
            else
                dir = 3 - dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        t = sc.nextInt();

        // 각 알파벳 별 방향 번호를 설정합니다.
        mapper['R'] = 0;
        mapper['D'] = 1;
        mapper['U'] = 2;
        mapper['L'] = 3;

        x = sc.nextInt();
        y = sc.nextInt();
        char cDir = sc.next().charAt(0);
        x--; y--; dir = mapper[cDir];

        simulate();

        System.out.println((x + 1) + " " + (y + 1));
    }
}