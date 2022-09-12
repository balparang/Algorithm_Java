import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;
    static final int MAX_TIME = 1000;


    static int n;
    static int[][] devs = new int[MAX_N][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            devs[i][0] = sc.nextInt();
            devs[i][1] = sc.nextInt();
        }

        // 개발자 한 명을 정하여 완전탐색
        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            // i번째 개발자 제외하고 운행 시간 계산
            int[] counting = new int[MAX_TIME + 1]; // counting[1] = 1 : 시각 1에 일하고 있는 사람이 존재

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                int t1 = devs[j][0]; // 근무 시작 시각
                int t2 = devs[j][1]; // 근무 종료 시각

                for (int k = t1; k < t2; k++) {
                    counting[k] = 1;
                }
            }

            // 운행 시간을 계산하고, 최댓값으로 갱신
            int time = 0;
            for (int j = 1; j <= MAX_TIME; j++) {
                if (counting[j] == 1) time++;
            }

            maxTime = Math.max(maxTime, time);
        }

        // 출력
        System.out.println(maxTime);
    }
}

// 해설 - 제외할 사람을 한 명씩 정하며, 나머지 사람들의 '운행 되고 있는 시간'을 모두 구하기
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] l = new int[MAX_N];
    public static int[] r = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        int ans = 0;

        // 뺄 직원을 정합니다.
        for (int i = 0; i < n; i++) {
            // i번 직원의 구간을 제외한 나머지 구간에서
            // 운행 되고 있는 시간을 구합니다.

            int[] count = new int[MAX_NUM];

            for (int j = 0; j < n; j++) {
                // i번째 점은 제외합니다.
                if (j == i) continue;

                // 모든 구간을 카운팅합니다.
                for (int k = l[j]; k < r[j]; k++)
                    count[k]++;
            }

            int time = 0;

            for (int j = 1; j < MAX_NUM; j++) {
                if (count[j] > 0) time++;
            }

            // 운행 되고 있는 시간 중 최댓값을 구합니다.
            ans = Math.max(ans, time);
        }

        System.out.print(ans);

    }
}