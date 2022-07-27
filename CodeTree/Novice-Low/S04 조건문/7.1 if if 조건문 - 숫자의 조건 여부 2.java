import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();

        // 출력
        if (a == 5) {
            System.out.println("A");
        }

        if (a % 2 == 0) {
            System.out.println("B");
        }
    }
}