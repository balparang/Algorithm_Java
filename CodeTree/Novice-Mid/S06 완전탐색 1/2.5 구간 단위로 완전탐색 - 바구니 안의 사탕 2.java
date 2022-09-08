// Try 1 - fail : 구간 범위 잘못 설정

import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;
    static int n;

    static int[] placed = new int[MAX_N + 1]; // index: 0~100

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int candyNum = sc.nextInt();
            int basketIdx = sc.nextInt();

            placed[basketIdx] += candyNum;
        }

        // 구간 완전탐색
        int maxSum = 0;

        for (int i = k + 1; i < MAX_N - k; i++) {
            int sum = 0;
            for (int j = i - k; j <= i + k; j++) {
                sum += placed[j];
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
    public static final int MAX_NUM = 100;

    public static int n, k;
    public static int[] arr = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int x = sc.nextInt();

            arr[x] += a;
        }

        // 모든 구간의 시작점을 잡아봅니다.
        int maxSum = 0;
        for (int i = 0; i <= MAX_NUM; i++) {
            // 해당 구간 내 원소의 합을 구합니다.
            int sum = 0;
            for (int j = i - k; j <= i + k; j++)
                if (j >= 0 && j <= MAX_NUM)
                    sum += arr[j];

            // 최댓값을 구합니다.
            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);
    }
}