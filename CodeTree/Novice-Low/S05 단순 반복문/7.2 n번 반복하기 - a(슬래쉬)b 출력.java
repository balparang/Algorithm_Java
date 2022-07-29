// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a, b;

        // 입력
        a = sc.nextInt();
        b = sc.nextInt();

        // 정수 부분을 먼저 출력합니다.
        System.out.print(a / b + ".");

        // a를 b로 나눈 나머지를 시작으로
        // 소수점 자리를 하나씩 계산합니다.
        a %= b;
        for(int i = 0; i < 20; i++) {
            // 나머지에 10 곱한 값을 기준으로
            // b로 나누었을 떄의 몫을 구해줍니다.
            a *= 10;
            System.out.print(a / b);

            // a를 b로 나눈 나머지를 게속 갱신해줍니다.
            a %= b;
        }
    }
}

// try1 : fail - double은 소수점 20째자리까지 나타내지 못한다.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // a / b 결과를 소수점 20째자리까지 출력
        double result = (double) a / b;
        System.out.printf("%.20f", result);
    }
}

// try2 : 해설 보고 다시 풀이
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 정수부 출력
        System.out.printf("%d.", a / b);

        // 나머지 계산
        int remainder = a % b;

        // 소수점 이하 출력
        for (int i = 0; i < 20 ; i++) {
            remainder *= 10;
            System.out.print(remainder / b); // 소수점 이하 몫 출력
            remainder = remainder % b;
        }
    }
}

