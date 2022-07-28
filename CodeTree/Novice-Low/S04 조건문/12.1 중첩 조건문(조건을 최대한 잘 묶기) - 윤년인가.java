import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if (year % 4 == 0) {
            if (year % 400 == 0) {
                System.out.println(true);
            } else if (year % 100 == 0) {
                System.out.println(false);
            } else {
                System.out.println(true);
            }
        } else {
            System.out.println(false);
        }
    }
}

// 선생님 답안 (조건을 잘 묶기)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int y;

        // 입력
        y = sc.nextInt();

        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

// 선생님 답안 (중첩 조건문)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int y;

        // 입력
        y = sc.nextInt();

        // 출력
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                System.out.println("true");
            }
        } else {
            System.out.println("false");
        }
    }
}