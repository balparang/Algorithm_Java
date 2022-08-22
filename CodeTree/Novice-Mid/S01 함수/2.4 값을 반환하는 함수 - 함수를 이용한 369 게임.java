/*
     Try 1 - fail :
     (fail testcase)
     533481 982364
     answer: 420104 / mine: 239404

     369를 판단하는 과정에서 1, 10의 자리만 고려하였음.
     더 큰 숫자 또한 고려해야한다.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;

        for (int i = a; i <= b; i++) {
            if (isMagicNumber(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isMagicNumber(int num) {
        return num % 3 == 0 || is369(num);
    }

    private static boolean is369(int num) {
        int units = num % 10;
        int tens = num / 10;
        return units == 3 || units == 6 || units == 9
                || tens == 3 || tens == 6 || tens == 9;
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;

        for (int i = a; i <= b; i++) {
            if (isMagicNumber(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isMagicNumber(int num) {
        return num % 3 == 0 || is369(num);
    }

    private static boolean is369(int num) {
        // 각 자릿수가 3, 6, 9 중 하나를 포함하는지 확인
        while (num > 0) {
            int remainder = num % 10;
            num /= 10;
            if (remainder == 3 || remainder == 6 || remainder == 9) {
                return true;
            }
        }

        return false;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // 3, 6, 9 숫자가
    // 단 하나라도 포함되었는지를 확인합니다.
    public static boolean contains369(int n) {
        // 계속 10으로 나눠주며
        // 일의 자리를 조사합니다.
        while (n > 0) {
            if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
                return true;
            n /= 10;
        }

        return false;
    }

    // 3, 6, 9를 포함하거나 3의 배수인지를 판단합니다.
    public static boolean is369Number(int n) {
        return contains369(n) || (n % 3 == 0);
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        for (int i = a; i <= b; i++)
            if (is369Number(i))
                cnt++;

        System.out.println(cnt);
    }
}