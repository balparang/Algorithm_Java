// try1 - fail : 별 개수 오류
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // 공백
            for (int j = 0; j < i; j++) { // 공백 j 개 출력
                System.out.print("  ");
            }

            // 별
            for (int j = 0; j < 5 - 2 * i; j++) { // 별 5 - 2i 개 출력
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}

// try2 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // 공백
            for (int j = 0; j < i; j++) { // 공백 j 개 출력
                System.out.print("  ");
            }

            // 별
            for (int j = 0; j < 2 * (n - i) - 1; j++) { // 별 2(n-i) - 1  개 출력
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

        // 모양에 맞게 별을 출력합니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for(int j = 0; j < (2 * n) - (2 * i) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}