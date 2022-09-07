import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 완전탐색
        int ans = -1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    // Carry가 일어나는지 확인
                    if (isSuccess(arr[i], arr[j], arr[k])) {
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }

        // 출력
        System.out.println(ans);
    }

    private static boolean isSuccess(int a, int b, int c) {
        // a, b, c 숫자를 일의 자리부터 만의 자리까지 carry가 일어나는지 확인
        int sum;

        for (int i = 1; i <= 4; i++) {
            if (i == 1) {
                sum = (a % 10) + (b % 10) + (c % 10);
            } else {
                sum = (placeNum(a, i) + placeNum(b, i) + placeNum(c, i));
            }

            if (sum >= 10) {
                return false;
            }
        }

        return true;
    }

    static int placeNum(int num, int i) {
        return num % (int) Math.pow(10, i) / (int) Math.pow(10, i - 1);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 20;

    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 모든 쌍을 다 잡아봅니다.
        int ans = -1;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    boolean carry = false;

                    //일의 자리에서 carry가 발생하는 경우
                    if (arr[i] % 10 + arr[j] % 10 + arr[k] % 10 >= 10)
                        carry = true;

                    //십의 자리에서 carry가 발생하는 경우
                    if (arr[i] % 100 / 10 + arr[j] % 100 / 10 + arr[k] % 100 / 10 >= 10)
                        carry = true;

                    //백의 자리에서 carry가 발생하는 경우
                    if (arr[i] % 1000 / 100 + arr[j] % 1000 / 100 + arr[k] % 1000 / 100 >= 10)
                        carry = true;

                    //천의 자리에서 carry가 발생하는 경우
                    if (arr[i] % 10000 / 1000 + arr[j] % 10000 / 1000 + arr[k] % 10000 / 1000 >= 10)
                        carry = true;

                    if (carry == false)
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                }

        System.out.print(ans);
    }
}