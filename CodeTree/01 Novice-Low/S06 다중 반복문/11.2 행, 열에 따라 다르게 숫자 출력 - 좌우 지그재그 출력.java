import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print((n * i + 1) + j + " ");
                }
            } else {
                for (int j = 0; j < n; j++) {
                    System.out.print(n * (i + 1) - j + " ");
                }
            }

            System.out.println();
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();

        // 좌우 지그재그로 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0)
                    System.out.print(((i * n) + j + 1) + " ");
                else
                    System.out.print(((i * n) + n - j) + " ");
            }
            System.out.println();
        }
    }
}