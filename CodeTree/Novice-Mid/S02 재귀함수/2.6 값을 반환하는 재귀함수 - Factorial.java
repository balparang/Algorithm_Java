import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return factorial(n - 1) * n;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int factorial(int n) {
        if(n == 0)
            return 1;

        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.print(factorial(n));
    }
}