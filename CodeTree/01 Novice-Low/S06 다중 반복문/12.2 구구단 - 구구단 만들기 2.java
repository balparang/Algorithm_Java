import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < 4; i++) {
            for (int j = b; j >= a; j--) {
                System.out.printf("%d * %d = %d", j, (i + 1) * 2, j * ((i + 1) * 2));

                if (j != a) {
                    System.out.print(" / ");
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
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 조건대로 구구단을 출력합니다.
        for (int i = 2; i <= 8; i += 2) {
            for (int j = b; j >= a; j--) {
                System.out.print(j + " * " + i + " = " + (i * j));
                if (j != a)
                    System.out.print(" / ");
            }
            System.out.println();
        }
    }
}