import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        for (int i = 1; i <= 5; i++) {
            int num = sc.nextInt();

            if (num % 2 == 0)
                cnt++;
        }

        System.out.println(cnt);
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a, cnt = 0;

        // 입력
        for(int i = 1; i <= 5; i++) {
            a = sc.nextInt();

            if(a % 2 == 0)
                cnt++;
        }

        // 출력
        System.out.print(cnt);
    }
}