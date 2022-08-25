import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int fibo(int n) {
        // 첫 번째, 두 번째 원소는 1입니다.
        if (n <= 2)
            return 1;

        // 3번째 원소부터는 다음 점화식을 만족합니다.
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.println(fibo(n));
    }
}