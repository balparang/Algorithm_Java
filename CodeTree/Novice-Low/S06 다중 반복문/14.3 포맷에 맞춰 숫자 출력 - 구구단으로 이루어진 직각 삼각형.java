import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%d * %d = %d", i, j, i * j);

                if (j == n - i + 1) { // j가 마지막 인덱스에서는 줄바꿈 출력
                    System.out.println();
                } else { // 아닌 경우 구분자 출력
                    System.out.print(" / ");
                }
            }

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

        // 구구단으로 이루어진 직각 삼각형을 출력합니다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(i + " * " + j + " = " + (i * j));
                if (j != (n - i + 1)) System.out.print(" / ");
            }
            System.out.println();
        }
    }
}