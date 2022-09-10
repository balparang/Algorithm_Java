// 해설보고 공부.

import java.util.Scanner;

public class Main {
    static final int MAX_N = 10;

    static int n;
    static int[] nums = new int[MAX_N]; // 세 자리 수
    static int[] arr1 = new int[MAX_N]; // 1번 카운트
    static int[] arr2 = new int[MAX_N]; // 2번 카운트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        // 모든 세자리 수에 대해 완전탐색
        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    // i, j, k는 서로 다른 숫자
                    if (i == j || j == k || k == i) {
                        continue;
                    }

                    // 숫자 'ijk' 가 B의 질의와 A의 답변을 모두 만족하는지 검사
                    boolean allMatch = true;
                    for (int l = 0; l < n; l++) {
                        // 숫자 xyz
                        int x = nums[l] / 100;
                        int y = nums[l] / 10 % 10;
                        int z = nums[l] % 10;

                        // 1번 카운트 2번 카운트 직접세기
                        int cnt1 = 0, cnt2 = 0;

                        if (x == i) cnt1++;
                        if (y == j) cnt1++;
                        if (z == k) cnt1++;

                        if (x == j || x == k) cnt2++;
                        if (y == i || y == k) cnt2++;
                        if (z == i || z == j) cnt2++;

                        // A의 답변과 일치하는지 확인
                        if (cnt1 != arr1[l] || cnt2 != arr2[l]) {
                            allMatch = false;
                            break;
                        }
                    }

                    // A의 답변과 모두 일치하면, 숫자 'ijk'는 가능성 있는 수
                    if (allMatch) {
                        answer++;
                    }
                }
            }
        }

        // 출력
        System.out.println(answer);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10;

    public static int n;
    public static int[] a = new int[MAX_N];
    public static int[] b = new int[MAX_N];
    public static int[] c = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        // 모든 숫자를 다 만들어 봅니다. (백의 자리수가 i, 십의 자리수가 j, 일의 자리수가 k)
        int cnt = 0;
        for (int i = 1; i <= 9; i++)
            for (int j = 1; j <= 9; j++)
                for (int k = 1; k <= 9; k++) {
                    // 같은 수가 있는지 확인합니다.
                    if (i == j || j == k || k == i)
                        continue;

                    // 해당 숫자가 정답일때, 모든 입력에 대해 올바른 답이 나왔는지 확인합니다.
                    boolean successed = true;
                    for (int q = 0; q < n; q++) {
                        // x : a[q]의 백의 자릿수, y : 십의 자릿수, z : 일의 자릿수
                        int x = a[q] / 100;
                        int y = a[q] / 10 % 10;
                        int z = a[q] % 10;
                        // cnt1 : 1번 카운트, cnt2 : 2번 카운트
                        int cnt1 = 0, cnt2 = 0;
                        if (x == i)
                            cnt1++;
                        if (y == j)
                            cnt1++;
                        if (z == k)
                            cnt1++;
                        if (x == j || x == k)
                            cnt2++;
                        if (y == i || y == k)
                            cnt2++;
                        if (z == i || z == j)
                            cnt2++;

                        // 만약 카운트 수가 다르다면 해당 숫자는 정답이 될 수 없습니다.
                        if (cnt1 != b[q] || cnt2 != c[q]) {
                            successed = false;
                            break;
                        }
                    }

                    if (successed) cnt++;
                }

        System.out.print(cnt);

    }
}