import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        while (a <= b) {
            System.out.print(a + " ");
            a = a % 2 == 0 ? a + 3 : a * 2;
        }
    }
}

// 답안 수정
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int i = a; // 별도의 인덱스를 선언하는 편이 더 좋다.

        while (i <= b) {
            System.out.print(i + " ");
            i = i % 2 == 0 ? i + 3 : i * 2;
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a, b, i;

        // 입력
        a = sc.nextInt();
        b = sc.nextInt();

        i = a;

        // 출력
        while(i <= b) {
            System.out.print(i + " ");
            if(i % 2 == 1)
                i *= 2;
            else
                i += 3;
        }
    }
}