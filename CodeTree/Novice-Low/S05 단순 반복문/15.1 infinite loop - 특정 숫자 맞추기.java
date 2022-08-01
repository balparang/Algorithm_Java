import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        while (true) {
            num = sc.nextInt();

            if (num == 25) {
                System.out.println("Good");
                break;
            } else if (num > 25) {
                System.out.println("Lower");
            } else {
                System.out.println("Higher");
            }
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 변수 선언 및 입력
            int n;
            n = sc.nextInt();

            // n이 25보다 작으면 Higher을, 25보다 크면 Lower을, 25와 같으면 Good을 출력한 뒤 종료합니다.
            if (n < 25)
                System.out.println("Higher");

            else if (n > 25)
                System.out.println("Lower");

            else {
                System.out.println("Good");
                break;
            }
        }
    }
}