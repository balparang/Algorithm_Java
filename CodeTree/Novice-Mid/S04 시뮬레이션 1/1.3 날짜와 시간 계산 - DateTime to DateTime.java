// Try 1 - fail : 입력 날짜가 더 앞선다면 -1을 출력해야한다는 조건을 확인하지 않았음.
/**
 * Test Case
 * 11 4 15
 */

import java.util.Scanner;

public class Main {
    static int a, b, c;

    // 11.11.01 00:00:00 부터 흐른 분 계산
    static int calcMinute(int d, int h, int m) {
        return (d * 24 * 60) + (h * 60) + m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // 흐른 분 계산
        int result = calcMinute(a, b, c) - calcMinute(11, 11, 11);

        // 출력
        System.out.println(result);
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    static int a, b, c;

    // 11.11.01 00:00:00 부터 흐른 분 계산
    static int calcMinute(int d, int h, int m) {
        return (d * 24 * 60) + (h * 60) + m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // 흐른 분 계산
        int result = calcMinute(a, b, c) - calcMinute(11, 11, 11);

        // 출력
        if (result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 차이를 계산합니다.
        int diff = (a * 24 * 60 + b * 60 + c) - (11 * 24 * 60 + 11 * 60 + 11);

        // 출력
        if (diff < 0)
            System.out.print(-1);
        else
            System.out.print(diff);
    }
}