import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        if (n <= 2) {
            return n;
        }

        return sum(n - 2) + n;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // 1부터 n까지의 n과 홀짝이 같은 수들의 합을 반환합니다.
    public static int getNum(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        // n과 홀짝이 같은 수만을 재귀함수로 호출합니다.
        return getNum(n - 2) + n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.print(getNum(n));
    }
}