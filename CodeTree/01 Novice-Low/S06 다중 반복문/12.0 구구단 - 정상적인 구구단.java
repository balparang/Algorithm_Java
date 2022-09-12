import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d * %d = %d", i + 1, j + 1, (i + 1) * (j + 1));

                if (j < n - 1) {
                    System.out.print(", ");
                }
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

        // n*n모양 구구단을 출력합니다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + " * " + j + " = " + (i * j));
                if (j != n) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}