import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // n x n 정사각형 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", 11 + (2 * i) + (2 * j));
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

        // n칸의 정사각형에 올바른 숫자를 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i * 2 + j * 2 + 11) + " ");
            }
            System.out.println();
        }
    }
}