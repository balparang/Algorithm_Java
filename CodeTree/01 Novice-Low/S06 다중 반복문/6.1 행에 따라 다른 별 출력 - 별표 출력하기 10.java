// #1 : 반으로 쪼개서 출력
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < i / 2 + 1; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 0; j < n - i / 2; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 0; j < i / 2 + 1; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 0; j < n - i / 2; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}

// #2 선생님 답안 : 홀, 짝 줄에 따라 다른 규칙 적용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();

        // i가 짝수인 경우 별을 1 + (i / 2)개, 홀수인 경우 n - (i - 1) / 2개 출력합니다
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                for (int k = 0; k < 1 + i / 2; k++)
                    System.out.print("* ");
            } else {
                for (int k = 0; k < n - (i - 1) / 2; k++)
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}

// #3 변수 이용, 문자열 반복 메서드 이용 : 단, Java 11 이상에서만 지원
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int plus = 1;
        int minus = n;

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                System.out.println("* ".repeat(plus));
                plus++;
            } else {
                System.out.println("* ".repeat(minus));
                minus--;
            }
        }
    }
}