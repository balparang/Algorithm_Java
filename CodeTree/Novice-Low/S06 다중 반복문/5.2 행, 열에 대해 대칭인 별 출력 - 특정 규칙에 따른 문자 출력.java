// try1 -fail : 무한 루프
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // 공백
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print("  ");
            }

            // 문자
            for (int j = 0; j < i + 1; j++) {
                System.out.print("@ ");
            }

            System.out.println();
        }

        for (int i = n - 2; i >= 0; i++) {
            // 문자
            for (int j = 0; j < i + 1; j++) {
                System.out.print("@ ");
            }

            // 공백
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print("  ");
            }

            System.out.println();
        }
    }
}

//