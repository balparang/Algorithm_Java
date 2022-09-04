// Try 1 - fail : 알파벳이 Z가 되면 다시 A로 변경하여 입력해야한다.
/*
Test Case
100 100
*/

import java.util.Scanner;

public class Main {
    static int board[][];
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int moveDir = 0;

    static int cx = 0, cy = -1;
    static int n, m;

    // inRange
    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    // simulate
    static void simulate() {
        char alphabet = 'a';

        while (alphabet < 'a' + n * m) {
            int nx = cx + dx[moveDir];
            int ny = cy + dy[moveDir];

            if (inRange(nx, ny) && board[nx][ny] == '\0') {
                board[nx][ny] = alphabet++;
                cx = nx;
                cy = ny;
            } else {
                moveDir = (moveDir + 1) % 4;
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

// Try 2
import java.util.Scanner;

public class Main {
    static int board[][];
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int moveDir = 0;

    static int cx = 0, cy = -1;
    static int n, m;

    // inRange
    static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    // simulate
    static void simulate() {
        char alphabet = 'A';
        int cnt = 0;

        while (cnt < n * m) {
            int nx = cx + dx[moveDir];
            int ny = cy + dy[moveDir];

            if (inRange(nx, ny) && board[nx][ny] == '\0') {
                board[nx][ny] = alphabet++;
                cx = nx;
                cy = ny;
                cnt++;
            } else {
                moveDir = (moveDir + 1) % 4;
            }

            if (alphabet == 'Z' + 1) {
                alphabet = 'A';
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
                System.out.print((char) board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// 해설
import java.util.Scanner;

public class Main {
    // 전역 변수 선언:
    // 이미 방문한적이 있다면 true / 아니라면 false로 표시합니다.
    public static boolean[][] visited = new boolean[100][100];

    // 함수 선언:
    public static boolean canGo(int n, int m, int newX, int newY) {
        // 나아가려는 위치가 직사각형 안에 들어 있는지 확인하고
        // 들어있다면 아직 방문한적이 없는 곳인지 판단합니다.
        if (0 <= newX && newX < n &&
                0 <= newY && newY < m &&
                visited[newX][newY] == false) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언:
        int n, m;
        char[][] answer = new char[100][100]; // 답에 해당하는 알파벳을 적을 배열입니다.

        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        // direction에 따라 바뀌는 (x, y)의 변화량인 dx, dy를 정의합니다.
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int currX = 0, currY = 0; // 시작은 (0, 0) 입니다.
        int direction = 0; //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽

        // 처음 시작 위치에 초기값을 적습니다.
        answer[currX][currY] = 'A';
        visited[currX][currY] = true;

        // n*m개의 알파벳을 적어야 합니다.
        for (int i = 1; i < n * m; i++) { // i번째 문자를 어디에 적을지 결정합니다.
            while (true) { // 나아갈 수 있을때까지 방향을 바꿔가며 확인해봅니다.
                // 현재 방향 dir를 기준으로 그 다음 위치 값을 계산합니다.
                int nextX = currX + dx[direction];
                int nextY = currY + dy[direction];
                // 그 위치로 나아갈 수 있는지 확인합니다.
                if (canGo(n, m, nextX, nextY)) {
                    // 나아갈 수 있다면 위치를 갱신해주고 배열에 올바른 값을 채워넣습니다.
                    currX = nextX;
                    currY = nextY;
                    visited[currX][currY] = true;
                    answer[currX][currY] = (char) (i % 26 + 'A');
                    break;
                } else {
                    // 나아갈 수 없다면 시계방향으로 90'를 회전하여
                    // 그 다음 방향을 확인해봐야 합니다.
                    direction = (direction + 1) % 4;
                }
            }
        }

        // 출력:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(answer[i][j] + " ");
            System.out.println();
        }
    }
}