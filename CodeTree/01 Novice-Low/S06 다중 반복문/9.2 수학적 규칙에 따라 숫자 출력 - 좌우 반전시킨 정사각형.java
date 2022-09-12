import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // n x n 정사각형 출력
        for (int i = 1; i <= n; i++) {

            for (int j = n; j >= 1; j--) {
                System.out.print((i * j) + " ");
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

        // 각 칸의 정사각형에 알맞은 값을 출력합니다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((i * (n - j + 1)) + " ");
            }
            System.out.println();
        }
    }
}