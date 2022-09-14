import java.util.Scanner;

public class Main {
    static final int MAX_N = 1000;

    static int[] Ta = new int[MAX_N];
    static int[] Tb = new int[MAX_N];
    static int n;
    static int C, H, G;

    static int getWorkload(int ta, int tb, int temp) {
        if (temp < ta) {
            return C;
        } else if (temp <= tb) {
            return H;
        } else {
            return G;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        C = sc.nextInt();
        H = sc.nextInt();
        G = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Ta[i] = sc.nextInt();
            Tb[i] = sc.nextInt();
        }

        // 온도에 따른 완전탐색
        int maxSum = Integer.MIN_VALUE;

        for (int temp = 0; temp <= 1000; temp++) {
            // N개 장비 순회하면서 작업량 구하기
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += getWorkload(Ta[i], Tb[i], temp);
            }

            maxSum = Math.max(maxSum, sum);
        }

        // 출력
        System.out.println(maxSum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MAX_T = 1000;

    public static int n, c, g, h;
    public static int[] ta = new int[MAX_N];
    public static int[] tb = new int[MAX_N];

    // 특정 장비의 t 온도에서의 작업량을 계산합니다.
    public static int singleEfficiency(int low, int high, int t) {
        if (t < low)
            return c;
        else if (t <= high)
            return g;
        else
            return h;
    }

    // 온도 t에 대한 작업량을 계산합니다.
    public static int performance(int t) {
        int totalEfficiency = 0;

        // 장비별 작업량의 합을 계산합니다.
        for (int i = 0; i < n; i++)
            totalEfficiency += singleEfficiency(ta[i], tb[i], t);
        return totalEfficiency;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        c = sc.nextInt();
        g = sc.nextInt();
        h = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }

        // 각 온도에 대해 작업량을 계산하여
        // 그 중 최댓값을 구해줍니다.
        int maxOut = 0;
        for (int t = 0; t <= MAX_T; t++)
            maxOut = Math.max(maxOut, performance(t));

        System.out.println(maxOut);
    }
}