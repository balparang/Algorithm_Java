import java.util.Scanner;

public class Main {
    static int m1, d1, m2, d2;
    static int[] days = new int[]{
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    static String[] dates = new String[]{
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
    };

    static int getDays(int m, int d) {
        // 11년 1월 1일부터 m월 d일까지의 날짜 수 계산
        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += days[i];
        }
        sum += d;

        return sum;
    }

    static String getDate(int diff) {
        if (diff < 0) {
            return dates[(diff % 7 + 7) % 7];
        }

        return dates[diff % 7];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        m1 = sc.nextInt();
        d1 = sc.nextInt();
        m2 = sc.nextInt();
        d2 = sc.nextInt();

        // 날짜 차이 계산
        int diff = getDays(m2, d2) - getDays(m1, d1);

        // 날짜에 해당하는 요일 계산
        String date = getDate(diff);

        // 출력
        System.out.println(date);
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
        // 변수 선언 및 입력
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        // 두 날짜간의 차이가 몇 일인지를 구합니다.
        int diff = numOfDays(m2, d2) - numOfDays(m1, d1);

        // 음수인 경우에는, 양수로 넘겨 계산해주면 올바르게 계산이 됩니다.
        while (diff < 0)
            diff += 7;

        // 알맞은 요일의 이름을 출력합니다.
        String[] dayOfWeek = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        System.out.print(dayOfWeek[diff % 7]);
    }
}