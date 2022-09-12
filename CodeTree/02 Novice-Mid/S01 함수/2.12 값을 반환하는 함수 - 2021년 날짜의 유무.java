import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int M = sc.nextInt();
        int D = sc.nextInt();

        // 유효한 날짜인지 확인
        if (isValidDate(M, D)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isValidDate(int M, int D) {
        if (M < 1 || M > 12) {
            return false;
        }
        if (M == 2) {
            return D >= 1 && D <= 28;
        }
        if (M <= 7) {
            if (M % 2 == 0) {
                return D >= 1 && D <= 30;
            } else {
                return D >= 1 && D <= 31;
            }
        } else {
            if (M % 2 == 0) {
                return D >= 1 && D <= 31;
            } else {
                return D >= 1 && D <= 30;
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // 윤년이 아닐 때 m번째 달의 마지막 날을 반환하는 함수를 작성합니다.
    public static int lastDayNumber(int m) {
        if (m == 2)
            return 28;
        if (m == 4 || m == 6 || m == 9 || m == 11)
            return 30;

        return 31;
    }

    // 윤년이 아닐 때 m월 d일이 존재하는지 여부를 확인하는 함수를 작성합니다.
    public static boolean judgeDay(int m, int d) {
        if (m <= 12 && d <= lastDayNumber(m))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int m = sc.nextInt();
        int d = sc.nextInt();

        if (judgeDay(m, d))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}