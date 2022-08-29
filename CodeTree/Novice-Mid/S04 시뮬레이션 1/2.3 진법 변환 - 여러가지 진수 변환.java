import java.util.Scanner;

public class Main {
    static int num, k; // k 진수
    static int[] digits = new int[10];
    static int cnt = 0;

    static void transform() {
        while (true) {
            if (num < k) {
                digits[cnt++] = num;
                break;
            }

            digits[cnt++] = num % k;
            num /= k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        k = sc.nextInt();

        // 진수 변환
        transform();

        // 출력
        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_DIGIT = 20;

    public static int n, b;
    public static int[] digits = new int[MAX_DIGIT];
    public static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        b = sc.nextInt();

        // b진수로 변환합니다.
        while(true) {
            if(n < b) {
                digits[cnt++] = n;
                break;
            }

            digits[cnt++] = n % b;
            n /= b;
        }

        // 진수 배열을 뒤집어 b진수를 출력합니다.
        for(int i = cnt - 1; i >= 0; i--)
            System.out.print(digits[i]);

    }
}