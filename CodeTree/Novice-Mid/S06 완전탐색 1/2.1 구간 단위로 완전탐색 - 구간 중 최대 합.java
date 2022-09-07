import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        // 구간합 중 최댓값 구하기
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            ans = Math.max(ans, sum);
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;

    public static int n, k;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 모든 구간의 시작점을 잡아봅니다.
        int maxSum = 0;
        for (int i = 0; i <= n - k; i++) {
            // 해당 구간 내 원소의 합을 구합니다.
            int sum = 0;
            for (int j = i; j < i + k; j++)
                sum += arr[j];

            // 최댓값을 구합니다.
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}