import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        if (a < b) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }

        if (a == b) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}