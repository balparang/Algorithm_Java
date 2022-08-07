import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int answer = 0;

        for (int currNum = start; currNum <= end; currNum++) {

            int divisorCount = 0;

            // Step 1
            for (int i = 1; i <= currNum; i++) {
                if (currNum % i == 0) {
                    divisorCount++;
                }

                if (divisorCount > 3) {
                    break;
                }
            }

            if (divisorCount == 3) {
                answer++;
            }
        }

        System.out.println(answer);
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

        for(int curr_num = start; curr_num <= end; curr_num++) {
            // Step 1:
            int divisor_cnt = 0;
            for(int divisor = 1; divisor <= curr_num; divisor++){
                if(curr_num % divisor == 0){
                    divisor_cnt++;
                }
            }
            // Case 1:
            if(divisor_cnt == 3){
                answer_cnt++;
            }
        }

        System.out.println(answer_cnt);
    }
}