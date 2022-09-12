import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 소수들의 합 구하기
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        // 출력
        System.out.println(sum);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= num - 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;
        for (int i = a; i <= b; i++)
            if (isPrime(i))
                sum += i;

        System.out.println(sum);
    }
}