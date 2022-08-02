import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) { // 별이 i + 1 개
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

        // 길이가 n인 직각삼각형을 출력합니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}