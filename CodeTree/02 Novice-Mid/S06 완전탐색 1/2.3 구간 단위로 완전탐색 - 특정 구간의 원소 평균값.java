import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        // 구간의 시작점과 끝점을 완전탐색. [0, 0], [0, 1], .. [n-1, n-1]
        int ans = 0;

        for (int i = 0; i < n; i++) { // 시작점
            for (int j = i; j < n; j++) { // 끝점
                // 구간 내 평균 구하기
                double sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                double avg = sum / (j - i + 1);

                // 구간의 평균값이 구간 내 원소와 일치하는 경우의 수 세기
                for (int k = i; k <= j; k++) {
                    if (arr[k] == avg) {
                        ans++;
                        break;
                    }
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

    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 모든 구간을 잡아봅니다.
        int cnt = 0;
        for (int i = 0; i < n; i++) // 구간의 시작점을 잡아봅니다.
            for (int j = i; j < n; j++) { // 구간의 끝점을 잡아봅니다.
                // 구간 [i, j] 내 원소의 합을 구합니다.
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += arr[k];

                // 평균을 구합니다.
                double avg = (double) sum / (j - i + 1);

                // 구간 내에 원소 평균값과 동일한 원소가 있으면 개수를 세줍니다.
                boolean exists = false;
                for (int k = i; k <= j; k++)
                    if (arr[k] == avg)
                        exists = true;

                if (exists)
                    cnt++;
            }

        System.out.println(cnt);
    }
}