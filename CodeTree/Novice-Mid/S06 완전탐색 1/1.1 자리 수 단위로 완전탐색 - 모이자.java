import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;

    static int houses[] = new int[MAX_N + 1];
    static int minSum = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            houses[i] = sc.nextInt();
        }

        // i 번 집에 대한 이동 거리 계산
        for (int i = 0; i <= n; i++) {
            int currSum = 0;

            for (int j = 1; j <= n; j++) {
                int peopleNum = houses[j];
                int distance = Math.abs(i - j);
                int cost = peopleNum * distance;

                currSum += cost;
            }

            minSum = Math.min(minSum, currSum);
        }

        // 출력
        System.out.println(minSum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] a = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        // 각 i번째 집으로 모였을 때의 합을 구해줍니다.
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int sumDist = 0;
            for (int j = 0; j < n; j++)
                sumDist += Math.abs(j - i) * a[j];

            // 가능한 거리의 합 중 최솟값을 구해줍니다.
            ans = Math.min(ans, sumDist);
        }

        System.out.println(ans);
    }
}