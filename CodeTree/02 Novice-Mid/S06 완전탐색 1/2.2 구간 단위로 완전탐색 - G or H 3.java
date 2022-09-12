import java.util.Scanner;

public class Main {
    static final int MAX_R = 10000;
    static char[] placed = new char[MAX_R + 1];
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt() + 1;

        for (int i = 0; i < n; i++) {
            int place = sc.nextInt();
            char symbol = sc.next().charAt(0);

            placed[place] = symbol;
        }

        // 구간합 중 최댓값 구하기
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i <= MAX_R - k + 1; i++) {
            int sum = 0;

            for (int j = i; j < i + k; j++) {
                if (placed[j] == 'G') {
                    sum += 1;
                } else if (placed[j] == 'H') {
                    sum += 2;
                }
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
    public static final int MAX_NUM = 10000;

    public static int n, k;
    public static int[] arr = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);

            if (c == 'G')
                arr[x] = 1;
            else
                arr[x] = 2;
        }

        // 모든 구간의 시작점을 잡아봅니다.
        int maxSum = 0;
        for (int i = 0; i <= MAX_NUM - k; i++) {
            // 해당 구간 내 원소의 합을 구합니다.
            int sum = 0;
            for (int j = i; j <= i + k; j++)
                sum += arr[j];

            // 최댓값을 구합니다.
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
