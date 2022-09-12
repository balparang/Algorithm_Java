import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            if (i % 2 == 0 && i % 4 != 0) {
                continue;
            }
            if ((i / 8) % 2 == 0) {
                continue;
            }
            if ((i % 7) < 4) {
                continue;
            }

            System.out.print(i + " ");
        }
        // Your Program Goes Here
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int a;

        a = sc.nextInt();

        // 조건을 모두 만족하지 않는 수들만 출력합니다.
        for(int i = 1; i <= a; i++) {
            if((i % 2 == 0 && i % 4 != 0) || (i / 8) % 2 == 0 || (i % 7) < 4)
                continue;
            System.out.print(i + " ");
        }
    }
}