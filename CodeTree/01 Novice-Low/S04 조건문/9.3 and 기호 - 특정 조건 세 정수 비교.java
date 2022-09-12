import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 조건 비교
        if (a <= b && a <= c) { // 세 정수가 모두 같을 때도 가장 작다고 판별.
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }

        if (a == b && b == c) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}