import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a, b입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 큰 수 부터 작은 수까지 출력
        if (a > b) {
            for (int i = a; i >= b; i--) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = b; i >= a; i--) {
                System.out.print(i + " ");
            }
        }
    }
}