// Try 1 - pass: 숫자 거꾸로 채워넣기

import java.util.Scanner;

public class Main {
    static int board[][];
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static int cx, cy;
    static int moveDir;

    static int n;

    // initialization
    static void initialize() {
        board = new int[n][n];
        cx = n - 1;
        cy = n - 1;
        board[cx][cy] = n * n;
        moveDir = 2;
    }

    // inRange
    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < n);
    }

    // simulate()
    static void simulate() {
        int num = n * n - 1;

        while (num >= 1) {
            int nx = cx + dx[moveDir];
            int ny = cy + dy[moveDir];

            if (inRange(nx, ny) && board[nx][ny] == 0) {
                board[nx][ny] = num--;
                cx = nx;
                cy = ny;
            } else {
                moveDir = (moveDir + 1) % 4;
            }
        }

    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        // 초기화
        initialize();

        // 시뮬레이션
        simulate();

        // 출력
        print();
    }
}

// 해설: 정해
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 499;
    public static final int DIR_NUM = 4;

    // 전역 변수 선언:
    public static int n;

    public static int currX, currY;
    public static int moveDir, moveNum;

    public static int[][] grid = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // 한 칸 움직입니다.
    public static void move() {
        // 문제에서 원하는 진행 순서대로
        // 오른쪽 위 왼쪽 아래 방향이 되도록 정의합니다.
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        currX += dx[moveDir];
        currY += dy[moveDir];
    }

    public static boolean end() {
        return !inRange(currX, currY);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        // 시작 위치와 방향,
        // 해당 방향으로 이동할 횟수를 설정합니다.
        currX = n / 2;
        currY = n / 2;
        moveDir = 0;
        moveNum = 1;

        int cnt = 1;

        while (!end()) {
            // moveNum 만큼 이동합니다.
            for (int i = 0; i < moveNum; i++) {
                grid[currX][currY] = cnt++;
                move();

                // 이동하는 도중 격자를 벗어나게 되면,
                // 움직이는 것을 종료합니다.
                if (end())
                    break;
            }

            // 방향을 바꿉니다.
            moveDir = (moveDir + 1) % 4;
            // 만약 현재 방향이 왼쪽 혹은 오른쪽이 된 경우에는
            // 특정 방향으로 움직여야 할 횟수를 1 증가시킵니다.
            if (moveDir == 0 || moveDir == 2)
                moveNum++;
        }

        // 출력:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}