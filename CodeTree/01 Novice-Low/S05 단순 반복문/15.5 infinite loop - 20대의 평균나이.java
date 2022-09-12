import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0, cnt = 0;

        while (true) {
            int age = sc.nextInt();

            if (age < 20 || age > 29) {
                double avg = (double) sum / cnt;
                System.out.printf("%.2f", avg);
                break;
            }

            sum += age;
            cnt++;
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int cnt = 0;
        // 언제 끝날지 모르므로
        // 계속 반복합니다.
        while(true) {
            // 변수를 선언하고 입력을 받습니다.
            int n;
            n = sc.nextInt();

            // 입력받은 값이 20대가 아니면 종료합니다.
            if(n >= 30 || n <= 19) {
                System.out.printf("%.2f", (double)sum / cnt);
                break;
            }

            // 20대가 맞는 경우에는, 계속 값을 계산해줍니다.
            sum += n;
            cnt++;
        }
    }
}