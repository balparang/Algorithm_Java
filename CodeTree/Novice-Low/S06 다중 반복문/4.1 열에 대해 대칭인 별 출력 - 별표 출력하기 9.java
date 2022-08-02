import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // 공백 n-i-1 개
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            // 별 2i+1 개
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();

        // 모양에 맞게 별을 출력합니다.
        for (int i = 0; i < n; i++) {

            for (int j = n - i; j > 1; j--)
                System.out.print("  ");

            for (int j = 0; j < 2 * i + 1; j++)
                System.out.print("* ");

            System.out.println();
        }
    }
}