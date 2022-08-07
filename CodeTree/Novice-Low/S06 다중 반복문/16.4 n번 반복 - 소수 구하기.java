import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int curr = 2; curr <= n; curr++) {

            boolean isPrimeNumber = true;

            for (int i = 2; i < curr; i++) {
                if (curr % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                System.out.print(curr + " ");
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();

        // 1부터 n까지 소수를 구합니다.
        for (int i = 1; i <= n; i++) {
            if (i == 1) continue;
            boolean isprime = true;

            for (int j = 2; j < i; j++)
                if (i % j == 0) isprime = false;

            if (isprime)
                System.out.print(i + " ");
        }
    }
}