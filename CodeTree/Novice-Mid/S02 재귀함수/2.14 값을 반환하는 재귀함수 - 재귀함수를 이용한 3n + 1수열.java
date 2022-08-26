import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(fun(n));
    }

    private static int fun(int n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return fun(n / 2) + 1;
        } else {
            return fun(3 * n + 1) + 1;
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // a가 3n + 1 수열을 총 몇번 반복해야 1이 되는지 반환합니다.
    public static int countNumber(int a) {
        if(a == 1)
            return 0;

        if(a % 2 == 0)
            return countNumber(a / 2) + 1;
        else
            return countNumber(3 * a + 1) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.print(countNumber(n));
    }
}