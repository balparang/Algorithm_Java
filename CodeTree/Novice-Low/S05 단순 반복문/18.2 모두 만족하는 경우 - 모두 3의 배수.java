import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean satisfied = true; // 주어진 모든 수가 3의 배수라면 true

        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();

            // 주어진 모든 수가 3 의배수인지 확인 -> 하나라도 3의 배수가 아닌지 확인
            if (num % 3 != 0) {
                satisfied = false;
                break;
            }
        }

        if (satisfied) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}