import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(func(n));
    }

    private static int func(int n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return func(n / 2) + 1;
        } else {
            return func(n / 3) + 1;
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // n에서 시작하여 1이 되기 위해
    // 거쳐야하는 횟수를 반환하는 함수입니다.
    public static int getNum(int n) {
        // 1이면 더 이상 진행할 작업이 없으므로 0회가 더 필요합니다.
        if (n == 1)
            return 0;

        // 짝수라면 2로 나눠 진행했을 때의 횟수 + 1번이 소요됩니다.
        if (n % 2 == 0)
            return getNum(n / 2) + 1;
            // 홀수라면 3으로 나누었을 때의 몫을 가지고 진행했을 때의 횟수 + 1번
            // 소요됩니다.
        else
            return getNum(n / 3) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();

        System.out.println(getNum(n));
    }
}