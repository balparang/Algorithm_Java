import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(digitSum(a * b* c));
    }

    private static int digitSum(int n) {
        if (n < 10) {
            return n;
        }
        return digitSum(n / 10) + n % 10;
    }
}