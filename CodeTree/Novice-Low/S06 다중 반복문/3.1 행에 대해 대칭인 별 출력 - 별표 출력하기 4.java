// i 정방향 증가
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 길이 n이 직각삼각형
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // 나머지 부분
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}

// i 역방향
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 길이 n이 직각삼각형
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // 나머지 부분
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
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

        // 길이가 n인 직각삼각형을 뒤집어 출력합니다.
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        // 길이가 n-1인 직각삼각형을 출력합니다.
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}