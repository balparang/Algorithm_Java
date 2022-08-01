import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(n);
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 언제 끝날지 모르므로
        // 계속 반복합니다.
        while(true) {
            // 변수를 선언하고 입력을 받습니다.
            int n;
            n = sc.nextInt();

            // 입력받은 값이 0이면 종료합니다.
            if(n == 0)
                break;

            // n이 0이 아닌 경우에는, 계속 값을 출력해줍니다.
            System.out.println(n);
        }
    }
}