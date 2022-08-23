import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getPower(a, b));
    }

    private static int getPower(int a, int b) {
        int prod = 1;

        for (int i = 1; i <= b; i++) {
            prod *= a;
        }

        return prod;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // a^b의 값을 반환합니다.
    public static int power(int a, int b) {
        int cnt = 1;
        for (int i = 1; i <= b; i++)
            cnt *= a;

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(power(a, b));

    }
}