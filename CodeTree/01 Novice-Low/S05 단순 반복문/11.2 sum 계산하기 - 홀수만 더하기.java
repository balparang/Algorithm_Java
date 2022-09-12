import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n, a, sum = 0;

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();

            if (a % 2 == 1 && a % 3 == 0)
                sum += a;
        }

        System.out.println(sum);
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n, sum = 0;

        // 입력
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int a;
            a = sc.nextInt();
            if(a % 2 == 1 && a % 3 == 0)
                sum += a;
        }

        // 출력
        System.out.print(sum);
    }
}