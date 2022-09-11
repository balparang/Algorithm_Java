import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;

    static int n;
    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];

    static int getDistSqr(int i, int j) {
        return (int) (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 두 점을 완전탐색으로 정하고, 거리의 제곱의 최솟값을 구한다.
        int minDistSqr = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distSqr = getDistSqr(i, j);
                minDistSqr = Math.min(minDistSqr, distSqr);
            }
        }

        // 출력
        System.out.println(minDistSqr);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];

    // 두 점 사이의 거리의 제곱 값을 반환합니다.
    public static int dist(int i, int j) {
        return (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 모든 쌍에 대해서 거리 제곱값을 계산하여
        // 그 중 최솟값을 찾습니다.
        int minDist = INT_MAX;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                minDist = Math.min(minDist, dist(i, j));

        System.out.println(minDist);
    }
}