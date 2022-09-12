import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = sum1ToN(n);
        System.out.println(result);
    }

    private static int sum1ToN(int n) {
        if (n == 1) {
            return 1;
        }

        return sum1ToN(n - 1) + n;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int sum(int n) {
        if (n == 0)
            return 0;

        return sum(n - 1) + n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.println(sum(n));
    }
}