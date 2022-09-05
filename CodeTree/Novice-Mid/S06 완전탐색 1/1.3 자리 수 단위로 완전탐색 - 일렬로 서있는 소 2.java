import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // 조건을 만족하는 쌍의 갯수 찾기
        int cnt = 0;

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (arr[i] <= arr[j] && arr[j] <= arr[k]) {
                        cnt++;
                    }
                }
            }
        }

        // 출력
        System.out.println(cnt);
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

        // 모든 쌍을 다 잡아봅니다.
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (arr[i] <= arr[j] && arr[j] <= arr[k])
                        cnt++;

        System.out.println(cnt);
    }
}