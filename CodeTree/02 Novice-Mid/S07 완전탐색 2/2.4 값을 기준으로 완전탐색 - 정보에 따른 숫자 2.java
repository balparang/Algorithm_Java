import java.util.Scanner;

public class Main {
    static final int MAX_A = 1000;

    static char[] info = new char[MAX_A + 1];
    static int T, A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        T = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();

        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int idx = sc.nextInt();
            info[idx] = c;
        }

        // [a, b] 중 숫자를 하나 정해 해당 숫자가 조건을 만족하는지 완전탐색
        int ans = 0;

        for (int i = A; i <= B; i++) {
            int minDistS = Integer.MAX_VALUE;
            int minDistN = Integer.MAX_VALUE;

            for (int j = 1; j <= MAX_A; j++) {
                int dist = Math.abs(j - i);

                if (info[j] == 'S') {
                    minDistS = Math.min(minDistS, dist);
                }
                if (info[j] == 'N') {
                    minDistN = Math.min(minDistN, dist);
                }
            }

            if (minDistS <= minDistN) ans++;
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_T = 100;

    public static int t, a, b;

    public static int[] s = new int[MAX_T];
    public static int[] n = new int[MAX_T];
    public static int cntS, cntN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        t = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        for (int i = 0; i < t; i++) {
            char x = sc.next().charAt(0);
            int y = sc.nextInt();
            if (x == 'S')
                s[cntS++] = y;
            else
                n[cntN++] = y;
        }

        int ans = 0;

        // 각 숫자에 대해
        // s에 더 가까운지 n에 더 가까운지 판단합니다.
        for (int i = a; i <= b; i++) {
            // 숫자 i에서부터 s로부터의 거리와
            // n으로부터의 거리를 확인합니다.
            int distanceS = INT_MAX;
            int distanceN = INT_MAX;

            for (int j = 0; j < cntS; j++)
                distanceS = Math.min(distanceS, Math.abs(s[j] - i));

            for (int j = 0; j < cntN; j++)
                distanceN = Math.min(distanceN, Math.abs(n[j] - i));

            if (distanceS <= distanceN)
                ans++;
        }

        System.out.print(ans);
    }
}