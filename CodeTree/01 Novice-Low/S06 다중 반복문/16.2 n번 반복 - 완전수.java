import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int cnt = 0;

        for (int i = start; i <= end; i++) {
            int sum = 0;

            for (int j = 1; j < i; j++) {
                // 약수 찾기
                if (i % j == 0) {
                    sum += j;
                }
            }

            if (sum == i) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int start = sc.nextInt();
        int end = sc.nextInt();
        int answer_cnt = 0;

        for (int curr_num = start; curr_num <= end; curr_num++) {
            // Step 1:
            int divisor_sum = 0;
            for (int divisor = 1; divisor <= curr_num - 1; divisor++) {
                if (curr_num % divisor == 0) {
                    divisor_sum += divisor;
                }
            }
            // Case 1:
            if (divisor_sum == curr_num) {
                answer_cnt++;
            }
        }

        System.out.println(answer_cnt);
    }
}