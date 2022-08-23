import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (isMagicNum(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isMagicNum(int n) {
        return isPlaceSumEven(n) && isPrime(n);
    }

    private static boolean isPlaceSumEven(int n) {
        int placeSum = 0;
        while (n > 0) {
            placeSum += n % 10;
            n /= 10;
        }

        return placeSum % 2 == 0;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // 해당 숫자가 소수인지 여부를 반환하는 함수를 작성합니다.
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // 자릿수의 합이 짝수인지 여부를 반환하는 함수를 작성합니다.
    public static boolean isDigitSumEven(int n) {
        int digitSum = (n / 100) + ((n / 10) % 10) + (n % 10);
        if (digitSum % 2 == 0)
            return true;

        return false;
    }

    // 해당 숫자가 소수이면서 자릿수의 합이 짝수인지 여부를 반환하는 함수를 작성합니다.
    public static boolean judgeNum(int n) {
        if (isPrime(n) && isDigitSumEven(n))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;

        for (int i = a; i <= b; i++) {
            if (judgeNum(i))
                cnt++;
        }

        System.out.print(cnt);
    }
}