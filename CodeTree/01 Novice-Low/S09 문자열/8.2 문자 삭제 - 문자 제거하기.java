// Try 1 - runtime error :
// 테스트케이스 - ab 2

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        // 문자가 하나 남으면 종료
        while (str.length() != 1) {
            int n = sc.nextInt();

            // 주어진 정수가 문자열의 길이 이상이면 마지막 문자를 제거
            if (n > str.length()) {
                str = str.substring(0, str.length() - 1);
            }
            // 주어진 정수 번째의 문자를 제거 (0번 부터)
            else {
                str = str.substring(0, n) + str.substring(n + 1);
            }

            System.out.println(str);
        }
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        // 문자가 하나 남으면 종료
        while (str.length() != 1) {
            int n = sc.nextInt();

            // 주어진 정수가 문자열의 길이 '이상'이면 마지막 문자를 제거
            if (n >= str.length()) {
                str = str.substring(0, str.length() - 1);
            }
            // 주어진 정수 번째의 문자를 제거 (0번 부터)
            else {
                str = str.substring(0, n) + str.substring(n + 1);
            }

            System.out.println(str);
        }
    }
}

// Try 3 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        // 문자가 하나 남으면 종료
        while (str.length() != 1) {
            int n = sc.nextInt();

            // 주어진 정수가 문자열의 길이 이상이면 마지막 문자를 제거
            if (n >= str.length() - 1) {
                str = str.substring(0, str.length() - 1);
            }
            // 주어진 정수 번째의 문자를 제거 (0번 부터)
            else {
                str = str.substring(0, n) + str.substring(n + 1);
            }

            System.out.println(str);
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // 문자가 하나 남을 때까지 반복합니다.
        while (len > 1) {
            // 정수를 입력받습니다.
            int a = sc.nextInt();

            // 정수가 문자열의 길이 이상이면 마지막 문자를 가리키게 변경합니다.
            if (a >= len)
                a = len - 1;

            // a번 자리의 원소를 제거합니다.
            str = str.substring(0, a) + str.substring(a + 1);
            len--;

            // 현재 문자열을 출력합니다.
            System.out.println(str);
        }
    }
}