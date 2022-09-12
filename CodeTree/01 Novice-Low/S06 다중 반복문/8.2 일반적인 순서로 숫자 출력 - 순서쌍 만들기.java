import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                System.out.printf("(%d,%d) ", i, j);
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

        // n칸의 정사각형에 올바른 순서쌍을 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + (n - i) + "," + (n - j) + ") ");
            }
            System.out.println();
        }
    }
}