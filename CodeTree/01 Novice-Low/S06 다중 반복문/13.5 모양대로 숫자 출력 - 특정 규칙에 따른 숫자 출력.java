import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i <= j) {
                    System.out.print(cnt + " ");
                    cnt++;
                } else {
                    System.out.print("  ");
                }

                if (cnt > 9) {
                    cnt = 1;
                }
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
        int cnt = 1;

        // cnt를 이용해 숫자로 이루어진 삼각형을 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("  ");
            for (int j = 0; j < n - i; j++) {
                System.out.print(cnt + " ");
                cnt++;
                if (cnt == 10)
                    cnt = 1;
            }
            System.out.println();
        }
    }
}