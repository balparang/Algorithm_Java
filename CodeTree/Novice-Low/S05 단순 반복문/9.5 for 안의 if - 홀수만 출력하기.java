import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num % 2 == 1 && num % 3 == 0) {
                System.out.println(num);
            }
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n;

        // 입력
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int a;
            a = sc.nextInt();
            if(a % 2 == 1 && a % 3 == 0)
                System.out.println(a);
        }
    }
}