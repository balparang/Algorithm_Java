import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean satisfied = false; // 합성수 이면 true

        // 1보다 큰 자연수 중 소수가 아닌 수
        // 2이상 n - 1 이하로 나눠떨어지면 -> 합성수
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                satisfied = true;
                break;
            }
        }

        if (satisfied) {
            System.out.println("C");
        } else {
            System.out.println("N");
        }
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
        boolean satisfied = false;

        for (int i = 2; i < n; i++) {
            // n의 약수가 있다면 합성수입니다.
            if (n % i == 0)
                satisfied = true;
        }

        //출력
        if (satisfied == true)
            System.out.println("C");
        else
            System.out.println("N");
    }
}