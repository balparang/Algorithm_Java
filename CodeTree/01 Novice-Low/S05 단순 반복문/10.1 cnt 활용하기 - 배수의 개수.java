import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt3 = 0, cnt5 = 0;

        for (int i = 1; i <= 10; i++) {
            int num = sc.nextInt();

            // 공배수인 경우
            if (num % 3 == 0 && num % 5 == 0) {
                cnt3++;
                cnt5++;
            }

            // 공배수가 아닌 경우
            else if (num % 3 == 0) {
                cnt3++;
            }
            else if (num % 5 == 0) {
                cnt5++;
            }
        }

        System.out.printf("%d %d", cnt3, cnt5);
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a, cnt3 = 0, cnt5 = 0;

        // 입력
        for(int i = 1; i <= 10; i++) {
            a = sc.nextInt();

            if(a % 3 == 0)
                cnt3++;
            if(a % 5 == 0)
                cnt5++;
        }

        // 출력
        System.out.print(cnt3 + " " + cnt5);
    }
}