import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 2의 거듭제곱수 입력, n >= 2
        int cnt = 0;

        while (n != 1) {
            n /= 2;
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

        // 변수 선언 및 입력
        int n;
        n = sc.nextInt();
        int prod = 1;
        int x = 0;

        while(true) {
            // prod가 n이 될 때까지 2를 곱합니다.
            if(n == prod)
                break;

            prod *= 2;
            x++;
        }

        System.out.println(x);
    }
}