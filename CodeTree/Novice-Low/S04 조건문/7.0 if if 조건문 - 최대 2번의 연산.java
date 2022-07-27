import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();

        // 짝수인지 검사
        if (a % 2 == 0) {
            a /= 2;
        }

        // 홀수인지 검사
        if (a % 2 == 1) {
            a = (a + 1) / 2;
        }

        // 출력
        System.out.println(a);
    }
}
