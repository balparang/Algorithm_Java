// Try 1 - fail : 모든 경우의 수를 고려할 수 없는 코드

import java.util.Scanner;

public class Main {
    static final int N = 6;
    static final int K = 4;

    static int[] arr = new int[N];
    static int totalSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        // group1 과 group2 에 들어갈 2명씩 완전탐색
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N - K; i++) {
            for (int j = i + 1; j < N - K + 1; j++) {
                for (int k = j + 1; k < N - K + 2; k++) {
                    for (int l = k + 1; l < N - K + 3; l++) {
                        int sum1 = arr[i] + arr[j];
                        int sum2 = arr[k] + arr[l];
                        int sum3 = totalSum - (sum1 + sum2);

                        int maxSum = Math.max(sum1, sum2);
                        maxSum = Math.max(maxSum, sum3);
                        int minSum = Math.min(sum1, sum2);
                        minSum = Math.min(minSum, sum3);

                        int sumDiff = maxSum - minSum;
                        minDiff = Math.min(minDiff, sumDiff);

                        System.out.println(sum1 + " " + sum2 + " " + sum3);
                    }
                }
            }
        }

        // 출력
        System.out.println(minDiff);
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    static final int N = 6;
    static final int K = 4;

    static int[] arr = new int[N];
    static int totalSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        // group1 과 group2 에 들어갈 2명씩 완전탐색
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = 0; k < N - 1; k++) {
                    for (int l = k + 1; l < N; l++) {
//                        System.out.printf("(%d, %d), (%d, %d) ", i, j, k, l);

                        if (i == k || i == l || j == k || j == l) {
//                            System.out.println("X");
                            continue;
                        }
//                        System.out.println();
                        int sum1 = arr[i] + arr[j];
                        int sum2 = arr[k] + arr[l];
                        int sum3 = totalSum - (sum1 + sum2);

                        int maxSum = Math.max(sum1, sum2);
                        maxSum = Math.max(maxSum, sum3);
                        int minSum = Math.min(sum1, sum2);
                        minSum = Math.min(minSum, sum3);

                        int sumDiff = maxSum - minSum;
                        minDiff = Math.min(minDiff, sumDiff);
                    }
                }
            }
        }

        // 출력
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

    public static int diff(int i, int j, int k, int l) {
        int totalSum = 0;
        for (int idx = 0; idx < n; idx++)
            totalSum += arr[idx];

        // 세 번째 팀원의 합은 전체에서 첫 번째 팀원과 두 번째 팀원의 합을 빼주면 됩니다.
        int sum1 = arr[i] + arr[j];
        int sum2 = arr[k] + arr[l];
        int sum3 = totalSum - sum1 - sum2;

        // 세 팀의 차이 중 최댓값을 리턴합니다.
        int ret = Math.abs(sum1 - sum2);
        ret = Math.max(ret, Math.abs(sum2 - sum3));
        ret = Math.max(ret, Math.abs(sum3 - sum1));

        return ret;
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

                // 두 번째 팀원을 만들어줍니다.
                for (int k = 0; k < n; k++)
                    for (int l = k + 1; l < n; l++) {
                        //첫 번째 팀원과 두 번째 팀원이 겹치는지 여부를 확인합니다.
                        if (k == i || k == j || l == i || l == j)
                            continue;
                        minDiff = Math.min(minDiff, diff(i, j, k, l));
                    }

        System.out.print(minDiff);
    }
}