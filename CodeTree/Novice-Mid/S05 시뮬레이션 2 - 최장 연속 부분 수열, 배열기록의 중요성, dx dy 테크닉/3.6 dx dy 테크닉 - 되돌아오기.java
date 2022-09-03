// Try 1 - pass

import java.util.Scanner;

class Order {
    char cDir;
    int distance;

    public Order(char cDir, int distance) {
        this.cDir = cDir;
        this.distance = distance;
    }
}

public class Main {
    static final int MAX_N = 100;
    static final int OFFSET = 1000;
    static final int MAX_R = OFFSET * 2;
    static final int ASCII_NUM = 128;

    static int n;
    static int curX = OFFSET, curY = OFFSET;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int dirNum;

    static Order[] orders = new Order[MAX_N];
    static int[] mapper = new int[ASCII_NUM];

    static int simulate() {
        int cnt = 0; // 이동 횟수

        for (int i = 0; i < n; i++) {
            Order order = orders[i];
            // 방향 정하기
            dirNum = mapper[order.cDir];
            // 이동
            for (int j = 0; j < order.distance; j++) {
                curX += dx[dirNum];
                curY += dy[dirNum];
                cnt++;

                if (curX == OFFSET && curY == OFFSET) {
                    return cnt;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char cDir = sc.next().charAt(0);
            int distance = sc.nextInt();
            orders[i] = new Order(cDir, distance);
        }

        // mapper
        mapper['E'] = 0;
        mapper['S'] = 1;
        mapper['W'] = 2;
        mapper['N'] = 3;

        // orders[] 순회하면서 이동
        int cnt = simulate();
        System.out.println(cnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;

    public static int n, x, y;

    // 동, 서, 남, 북 순으로 dx, dy를 정의합니다.
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    // 답을 저장합니다.
    public static int ans = -1;

    // 지금까지 걸린 시간을 기록합니다.
    public static int elapsedTime;

    // dir 방향으로 dist 만큼 이동하는 함수입니다.
    // 만약 시작지에 도달하면 true를 반환합니다.
    public static boolean move(int dir, int dist) {
        while (dist-- > 0) {
            x += dx[dir];
            y += dy[dir];

            // 이동한 시간을 기록합니다.
            elapsedTime++;

            // 시작지로 다시 돌아오면,
            // 답을 갱신해줍니다.
            if (x == 0 && y == 0) {
                ans = elapsedTime;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        // 움직이는 것을 진행합니다.
        while (n-- > 0) {
            char cDir = sc.next().charAt(0);
            int dist = sc.nextInt();

            // 각 방향에 맞는 번호를 붙여줍니다.
            int dir;
            if (cDir == 'E')
                dir = 0;
            else if (cDir == 'W')
                dir = 1;
            else if (cDir == 'S')
                dir = 2;
            else
                dir = 3;

            // 주어진 방향대로 dist 만큼 위치를 이동해봅니다.
            boolean done = move(dir, dist);

            // 시작 위치에 도달했다면, 종료합니다.
            if (done)
                break;
        }

        System.out.print(ans);
    }
}