import java.util.Scanner;

public class Main {
    static final int OFFSET = 1000;
    static final int MAX_N = 100;

    static int n;
    static int[] x = new int[MAX_N + 1];
    static int[] blocks = new int[OFFSET * 2 + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        // x[] 에 명령 입력
        for (int i = 1; i <= n; i++) {
            int size = sc.nextInt();
            char LorR = sc.next().charAt(0);

            x[i] = (LorR == 'R') ? size : -1 * size;
        }

        // 명령 대로 좌우 움직이기
        int lastIdx = OFFSET;
        for (int i = 1; i <= n; i++) {
            // R 이동
            if (x[i] > 0) {
                for (int j = lastIdx; j <= lastIdx + x[i] - 1; j++) {
                    blocks[j]++;
                }
            }
            // L 이동
            else {
                for (int j = lastIdx - 1; j >= lastIdx + x[i]; j--) {
                    blocks[j]++;
                }
            }
            lastIdx += x[i];
        }

        // 2번 이상 지나간 영역의 크기 구하기
        int cnt = 0;
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] >= 2) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

// 해설 - 우리가 아는 구간 칠하기 문제로 변경해서 풀이
import java.util.Scanner;

public class Main {
    public static final int OFFSET = 1000;
    public static final int MAX_R = 2000;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];

    public static int[] checked = new int[MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        // 현재 위치
        int cur = 0;

        for (int i = 0; i < n; i++) {
            int distance = sc.nextInt();
            char direction = sc.next().charAt(0);

            if (direction == 'L') {
                // 왼쪽으로 이동할 경우 : cur - distance ~ cur까지 경로 이동
                x1[i] = cur - distance;
                x2[i] = cur;
                cur -= distance;
            } else {
                // 오른쪽으로 이동할 경우 : cur ~ cur + distance까지 경로 이동
                x1[i] = cur;
                x2[i] = cur + distance;
                cur += distance;
            }

            // OFFSET을 더해줍니다.
            x1[i] += OFFSET;
            x2[i] += OFFSET;
        }

        // 구간을 칠해줍니다.
        // 구간 단위로 진행하는 문제이므로
        // x2[i]에 등호가 들어가지 않음에 유의합니다.
        for (int i = 0; i < n; i++)
            for (int j = x1[i]; j < x2[i]; j++)
                checked[j]++;

        // 2번 이상 지나간 영역의 크기를 구합니다.
        int cnt = 0;
        for (int i = 0; i <= MAX_R; i++)
            if (checked[i] >= 2)
                cnt++;

        System.out.print(cnt);
    }
}