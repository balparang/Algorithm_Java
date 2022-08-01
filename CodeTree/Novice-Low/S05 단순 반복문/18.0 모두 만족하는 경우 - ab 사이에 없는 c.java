import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean satisfied = true; // c의 배수가 전혀없으면 true

        for (int i = a; i <= b; i++) {
            if (i % c == 0) {
                satisfied = false; // c의 배수가 하나 이상 존재
            }
        }

        if (satisfied) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        boolean satisfied = true;

        for (int i = a; i <= b; i++) {
            // a에서 b사이의 값 중 c의 배수가 있는지 확인합니다.
            if (i % c == 0)
                satisfied = false;
        }

        //출력
        if (satisfied == true)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}