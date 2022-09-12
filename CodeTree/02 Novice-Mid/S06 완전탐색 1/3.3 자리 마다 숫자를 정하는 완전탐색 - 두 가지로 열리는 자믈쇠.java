// Try 1 - fail
/*
    Test Case
    10
    9 9 9
    3 3 3
*/

import java.util.Scanner;

public class Main {
    static int MAX_R = 3;

    static int n;
    static int[] tmp = new int[MAX_R];
    static int[] arr1 = new int[MAX_R]; // 조합 첫 번째
    static int[] arr2 = new int[MAX_R]; // 조합 두 번째

    static boolean match(int x1, int x2) {
        // N
        if (x1 <= 2 && x2 == n) {
            return true;
        }
        // N - 1
        if (x1 == 1 && x2 == n - 1) {
            return true;
        }
        return Math.abs(x1 - x2) <= 2;
    }

    // 첫 번째 조합이랑 일치하는 지 확인
    static boolean isMatch(int[] arr, int[] target) {
        // 3자리 모두 일치하면 true
        int matchCnt = 0;

        for (int i = 0; i < MAX_R; i++) {
            if (match(arr[i], target[i])) {
                matchCnt++;
            }
        }

        return matchCnt == 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < MAX_R; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < MAX_R; i++) {
            arr2[i] = sc.nextInt();
        }

        // 3자리 숫자 완전탐색
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = k;

                    // 첫 번째 조합과 일치하는지 확인
                    if (isMatch(arr1, tmp)) {
                        cnt++;
                        continue;
                    }
                    // 두 번째 조합
                    if (isMatch(arr2, tmp)) {
                        cnt++;
                    }
                }
            }
        }

        // 출력
        System.out.println(cnt);
    }
}
// Try 2 - fail
/*
    Test Case
    50
    1 2 3
    5 6 7
*/

import java.util.Scanner;

public class Main {
    static int MAX_R = 3;

    static int n;
    static int[] tmp = new int[MAX_R];
    static int[] arr1 = new int[MAX_R]; // 조합 첫 번째
    static int[] arr2 = new int[MAX_R]; // 조합 두 번째

    static boolean match(int x1, int x2) {
        // N
        if (x1 == n && x2 <= 2) {
            return true;
        }
        // N - 1
        if (x1 == n - 1 && x2 == 1) {
            return true;
        }
        return Math.abs(x1 - x2) <= 2;
    }

    // 첫 번째 조합이랑 일치하는 지 확인
    static boolean isMatch(int[] arr, int[] target) {
        // 3자리 모두 일치하면 true
        int matchCnt = 0;

        for (int i = 0; i < MAX_R; i++) {
            if (match(arr[i], target[i])) {
                matchCnt++;
            }
        }

        return matchCnt == 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < MAX_R; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < MAX_R; i++) {
            arr2[i] = sc.nextInt();
        }

        // 3자리 숫자 완전탐색
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = k;

                    // 첫 번째 조합과 일치하는지 확인
                    if (isMatch(arr1, tmp)) {
                        cnt++;
//                        System.out.printf("(%d, %d, %d)\n", i, j, k);
                        continue;
                    }
                    // 두 번째 조합
                    if (isMatch(arr2, tmp)) {
                        cnt++;
                    }
                }
            }
        }

        // 출력
        System.out.println(cnt);
    }
}

// Try 3 - pass
import java.util.Scanner;

public class Main {
    static int MAX_R = 3;

    static int n;
    static int[] tmp = new int[MAX_R];
    static int[] arr1 = new int[MAX_R]; // 조합 첫 번째
    static int[] arr2 = new int[MAX_R]; // 조합 두 번째

    static boolean match(int x1, int x2) {
        // N
        if ((x1 == n && x2 <= 2) || (x1 <= 2 && x2 == n)) {
            return true;
        }
        // N - 1
        if ((x1 == n - 1 && x2 == 1) || (x1 == 1 && x2 == n - 1)) {
            return true;
        }
        return Math.abs(x1 - x2) <= 2;
    }

    // 첫 번째 조합이랑 일치하는 지 확인
    static boolean isMatch(int[] arr, int[] target) {
        // 3자리 모두 일치하면 true
        int matchCnt = 0;

        for (int i = 0; i < MAX_R; i++) {
            if (match(arr[i], target[i])) {
                matchCnt++;
            }
        }

        return matchCnt == 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < MAX_R; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < MAX_R; i++) {
            arr2[i] = sc.nextInt();
        }

        // 3자리 숫자 완전탐색
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = k;

                    // 첫 번째 조합과 일치하는지 확인
                    if (isMatch(arr1, tmp)) {
                        cnt++;

                        continue;
                    }
                    // 두 번째 조합
                    if (isMatch(arr2, tmp)) {
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
    public static int n;
    public static int a, b, c;
    public static int a2, b2, c2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        a2 = sc.nextInt();
        b2 = sc.nextInt();
        c2 = sc.nextInt();

        // 모든 조합을 다 만들어 봅니다.
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++) {
                    // 모든 자리가 주어진 첫 조합과의 거리가 2 이내인지 확인합니다.
                    if ((Math.abs(a - i) <= 2 || Math.abs(a - i) >= n - 2)
                            && (Math.abs(b - j) <= 2 || Math.abs(b - j) >= n - 2)
                            && (Math.abs(c - k) <= 2 || Math.abs(c - k) >= n - 2))
                        cnt++;

                        // 모든 자리가 주어진 두번째 조합과의 거리가 2 이내인지 확인합니다.
                    else if ((Math.abs(a2 - i) <= 2 || Math.abs(a2 - i) >= n - 2)
                            && (Math.abs(b2 - j) <= 2 || Math.abs(b2 - j) >= n - 2)
                            && (Math.abs(c2 - k) <= 2 || Math.abs(c2 - k) >= n - 2))
                        cnt++;
                }

        System.out.print(cnt);
    }
}