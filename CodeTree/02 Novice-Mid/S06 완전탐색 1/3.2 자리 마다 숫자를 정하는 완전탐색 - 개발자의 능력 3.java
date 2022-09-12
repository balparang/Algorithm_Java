import java.util.Scanner;

public class Main {
    static final int MAX_N = 6;

    static int[] arr = new int[MAX_N];
    static int sum1, sum2, totalSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < MAX_N; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        // group1 3명에 대한 완전탐색
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < MAX_N - 2; i++) {
            for (int j = i + 1; j < MAX_N - 1; j++) {
                for (int k = j + 1; k < MAX_N; k++) {
                    sum1 = arr[i] + arr[j] + arr[k];
                    sum2 = totalSum - sum1;
                    int diff = Math.abs(sum1 - sum2); // 현재 그룹에 대한 점수 합산의 차이

                    minDiff = Math.min(minDiff, diff);
                }
            }
        }

        System.out.println(minDiff);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 6;

    public static int n = MAX_N;
    public static int[] arr = new int[MAX_N];

    public static int diff(int i, int j, int k) {
        int totalSum = 0;
        for (int l = 0; l < n; l++)
            totalSum += arr[l];

        // 두 번째 팀원의 합은 전체에서 첫 번째 팀원의 합을 빼주면 됩니다.
        int sum1 = arr[i] + arr[j] + arr[k];
        int sum2 = totalSum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 첫 번째 팀원을 만들어줍니다.
        int minDiff = INT_MAX;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    minDiff = Math.min(minDiff, diff(i, j, k));

        System.out.println(minDiff);
    }
}