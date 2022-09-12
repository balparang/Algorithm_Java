import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (isMagicNumber(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isMagicNumber(int n) {
        if (n % 2 == 0) {
            // 1의 자리 + 10의 자리가 5의 배수인지 확인
            return ((n % 10) + (n / 10)) % 5 == 0;
        }

        return false;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static boolean isMagicNumber(int n) {
        return n % 2 == 0 && (n / 10 + (n % 10)) % 5 == 0;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isMagicNumber(n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}