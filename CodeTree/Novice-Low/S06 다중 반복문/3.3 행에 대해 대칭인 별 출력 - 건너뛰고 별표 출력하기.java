import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n\n");
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n\n");
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

        // 길이가 n인 직각삼각형을 출력합니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
            System.out.println();
        }

        // 길이가 n-1인 직각삼각형을 뒤집어 출력합니다.
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
            System.out.println();
        }
    }
}