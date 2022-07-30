import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        // 10개의 숫자 입력
        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();

            if (n % 2 == 1) {
                cnt++;
            }
        }

        // 출력
        System.out.println(cnt);
    }
}