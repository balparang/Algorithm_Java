import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i <= 2 * n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n - (i / 2); j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 0; j < 1 + (i / 2); j++) {
                    System.out.print("* ");
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

        // i가 홀수인 경우 별을 1 + (i / 2)개, 짝수인 경우 n - (i / 2)개 출력합니다
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 1) {
                for (int k = 0; k < 1 + i / 2; k++)
                    System.out.print("* ");
            } else {
                for (int k = 0; k < n - i / 2; k++)
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}