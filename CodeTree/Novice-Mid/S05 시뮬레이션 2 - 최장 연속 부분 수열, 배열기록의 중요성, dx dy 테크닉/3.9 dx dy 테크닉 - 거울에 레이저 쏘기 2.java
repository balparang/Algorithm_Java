// Try 1 - pass: 매우 비효율적이지만 패스는 했다. 문제 이해는 제대로 하였음.

import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int dirNum;

    static int startNum;
    static int n;
    static int curX, curY;

    static int getGroupNum(int startNum) {
        if (startNum % n == 0) {
            return startNum / n - 1;
        } else {
            return startNum / n;
        }
    }

    static int getDirNum(int groupNum) {
        if (groupNum == 0) {
            return 1;
        } else if (groupNum == 1) {
            return 2;
        } else if (groupNum == 2) {
            return 3;
        } else {
            return 4;
        }
    }

    static int[] getStartXY(int groupNum, int startNum) {
        int[] xy = new int[2]; // [0] : x, [1] : y

        if (groupNum == 0) {
            if (startNum % n == 0) {
                xy[1] = n - 1;
            } else {
                xy[1] = startNum % n - 1;
            }
        } else if (groupNum == 1) {
            if (startNum % n == 0) {
                xy[0] = n - 1;
            } else {
                xy[0] = startNum % n - 1;
            }
            xy[1] = n - 1;
        } else if (groupNum == 2) {
            if (startNum % n == 0) {
                xy[1] = 0;
            } else {
                xy[1] = n - startNum % n;
            }
            xy[0] = n - 1;
        } else {
            if (startNum % n != 0) {
                xy[0] = n - startNum % n;
            }
        }

        return xy;
    }

    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            char[] cArr = str.toCharArray();

            for (int j = 0; j < n; j++) {
                board[i][j] = cArr[j];
            }
        }

        startNum = sc.nextInt();

        // 시뮬레이션
        int groupNum = getGroupNum(startNum);
        int[] xy = getStartXY(groupNum, startNum);
        curX = xy[0];
        curY = xy[1];

        dirNum = getDirNum(groupNum);

        int cnt = 0;

        while (true) {
            // case1
            if (board[curX][curY] == '/') {
                // 방향 전환
                if (dirNum == 1 || dirNum == 3) {
                    dirNum = (dirNum + 1) % 4;
                } else {
                    dirNum = (dirNum - 1 + 4) % 4;
                }
                cnt++;
                int nx = curX + dx[dirNum];
                int ny = curY + dy[dirNum];

                if (inRange(nx, ny)) {
                    curX = nx;
                    curY = ny;
                } else {
                    break;
                }
            }
            // case 2
            else {
                // 방향 전환
                if (dirNum == 1 || dirNum == 3) {
                    dirNum = (dirNum - 1 + 4) % 4;
                } else {
                    dirNum = (dirNum + 1) % 4;
                }
                cnt++;
                int nx = curX + dx[dirNum];
                int ny = curY + dy[dirNum];

                if (inRange(nx, ny)) {
                    curX = nx;
                    curY = ny;
                } else {
                    break;
                }
            }
        }

        // 출력
        System.out.println(cnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 1000;

    public static int n;
    public static char[][] arr = new char[MAX_N][MAX_N];

    public static int startNum;
    public static int x, y, moveDir;

    // 주어진 숫자에 따라
    // 시작 위치와 방향을 구합니다.
    public static void initialize(int num) {
        if (num <= n) {
            x = 0;
            y = num - 1;
            moveDir = 0;
        } else if (num <= 2 * n) {
            x = num - n - 1;
            y = n - 1;
            moveDir = 1;
        } else if (num <= 3 * n) {
            x = n - 1;
            y = n - (num - 2 * n);
            moveDir = 2;
        } else {
            x = n - (num - 3 * n);
            y = 0;
            moveDir = 3;
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // (x, y)에서 시작하여 nextDir 방향으로
    // 이동한 이후의 위치를 구합니다.
    public static void move(int nextDir) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        x += dx[nextDir];
        y += dy[nextDir];
        moveDir = nextDir;
    }

    public static int simulate() {
        int moveNum = 0;
        while (inRange(x, y)) {
            // 0 <-> 1 / 2 <-> 3
            if (arr[x][y] == '/')
                move(moveDir ^ 1);
                // 0 <-> 3 / 1 <-> 2
            else
                move(3 - moveDir);

            moveNum += 1;
        }

        return moveNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++)
                arr[i][j] = input.charAt(j);
        }

        startNum = sc.nextInt();

        // 시작 위치와 방향을 구합니다.
        initialize(startNum);
        // (x, y)에서 moveDir 방향으로 시작하여
        // 시뮬레이션을 진행합니다.
        int moveNum = simulate();

        System.out.print(moveNum);
    }
}