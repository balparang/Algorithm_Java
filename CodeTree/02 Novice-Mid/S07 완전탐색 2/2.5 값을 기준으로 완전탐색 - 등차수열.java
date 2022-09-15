import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;

    static int[] sequence = new int[MAX_N + 1]; // a1, a2, ... , an
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sequence[i] = sc.nextInt();
        }

        // 모든 k에 대해 등차수열 개수를 최대로 만드는 k 찾기
        int maxCnt = 0;

        for (int k = 1; k <= 100; k++) {
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (sequence[j] - k == k - sequence[i]) {
                        cnt++;
                    }
                }
            }

            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_A = 100;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int ans = 0;

        // 각 숫자에 대해
        // 등차수열의 개수를 확인합니다.
        for (int x = 1; x <= MAX_A; x++) {
            // 모든 쌍을 만들어 등차수열의 개수를 확인합니다.
            int cnt = 0;

            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    if (arr[i] + arr[j] == 2 * x)
                        cnt++;

            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}