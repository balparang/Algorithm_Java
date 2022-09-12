import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        if (3 <= m && m <= 5) {
            System.out.println("Spring");
        } else if (6 <= m && m <= 8) {
            System.out.println("Summer");
        } else if (9 <= m && m <= 11) {
            System.out.println("Fall");
        } else {
            System.out.println("Winter");
        }
    }
}

/* 선생님 답안 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int m;

        // 입력
        m = sc.nextInt();

        // 출력
        if(m >= 12 || m <= 2)
            System.out.println("Winter");
        else if(m <= 5)
            System.out.println("Spring");
        else if(m <= 8)
            System.out.println("Summer");
        else
            System.out.println("Fall");
    }
}