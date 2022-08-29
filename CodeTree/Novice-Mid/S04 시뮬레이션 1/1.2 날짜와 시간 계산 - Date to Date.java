// Try 1 - fail: 주어진 달이 서로 같은 경우를 고려하지 않았다.
/**
 * Test Case
 * 12 23 12 23
 */

import java.util.Scanner;

public class Main {
    static int m1, d1;
    static int m2, d2;
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        m1 = sc.nextInt();
        d1 = sc.nextInt();
        m2 = sc.nextInt();
        d2 = sc.nextInt();

        // 날짜 계산
        int sum = 0;
        for (int i = m1; i <= m2; i++) {
            if (i == m1) {
                sum += days[i] - d1 + 1;
            } else if (i == m2) {
                sum += d2;
            } else {
                sum += days[i];
            }
        }

        // 출력
        System.out.println(sum);
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    static int m1, d1;
    static int m2, d2;
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        m1 = sc.nextInt();
        d1 = sc.nextInt();
        m2 = sc.nextInt();
        d2 = sc.nextInt();

        // 날짜 계산
        int sum = 0;
        for (int i = m1; i <= m2; i++) {
            if (m1 == m2) {
                sum += d2 - d1 + 1;
                break;
            }

            if (i == m1) {
                sum += days[i] - d1 + 1;
            } else if (i == m2) {
                sum += d2;
                break;
            } else {
                sum += days[i];
            }
        }

        // 출력
        System.out.println(sum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int numOfDays(int m, int d) {
        // 계산 편의를 위해 월마다 몇 일이 있는지를 적어줍니다.
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        // 1월부터 (m - 1)월 까지는 전부 꽉 채워져 있습니다.
        for (int i = 1; i < m; i++)
            totalDays += days[i];

        // m월의 경우에는 정확이 d일만 있습니다.
        totalDays += d;

        return totalDays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        // 출력
        System.out.println(numOfDays(m2, d2) - numOfDays(m1, d1) + 1);
    }
}