import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int dir = 3; // 북쪽으로 초기화
    static int x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String str = sc.next();

        // LRF 명령에 따라 이동
        for (char c : str.toCharArray()) {
            if (c == 'L') { // 좌로 90도
                dir = (dir - 1 + 4) % 4; // 음수가 되지 않게 설정
            } else if (c == 'R') { // 우로 90도
                dir = (dir + 1) % 4;
            } else {
                x += dx[dir];
                y += dy[dir];
            }
        }

        // 출력
        System.out.println(x + " " + y);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static String dirs;
    public static int x = 0, y = 0;
    public static int currDir = 3;

    // 동, 남, 서, 북 순으로 dx, dy를 정의합니다.
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        dirs = sc.next();

        // 움직이는 것을 진행합니다.
        for (int i = 0; i < dirs.length(); i++) {
            char cDir = dirs.charAt(i);

            // 반시계방향 90' 회전
            if (cDir == 'L')
                currDir = (currDir - 1 + 4) % 4;
            // 시계방향 90' 회전
            else if (cDir == 'R')
                currDir = (currDir + 1) % 4;
            // 직진
            else {
                x += dx[currDir];
                y += dy[currDir];
            }
        }

        System.out.print(x + " " + y);
    }
}