// try1 - fail : n은 최초 한 번만 입력받아야한다.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        while (true) {
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println(cnt);
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }

            cnt++;
        }
    }
}

// try2 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
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
        int cnt = 0;

        while(true) {
            // n이 1이 될 때까지 홀수일 때는 n = 3n+1을, 짝수일 때는 n = n/2를 반복합니다.
            if(n == 1)
                break;

            if(n % 2 == 1)
                n = 3 * n + 1;
            else
                n = n / 2;

            cnt++;
        }

        System.out.println(cnt);
    }
}