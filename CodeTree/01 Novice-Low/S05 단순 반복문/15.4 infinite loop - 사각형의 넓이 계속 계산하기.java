import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int width = sc.nextInt();
            int height = sc.nextInt();
            char c = sc.next().charAt(0);

            System.out.println(width * height);

            if (c == 'C') {
                break;
            }
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            // 변수 선언 및 입력
            int w, h;
            char a;
            w = sc.nextInt();
            h = sc.nextInt();
            a = sc.next().charAt(0);

            // 사각형의 넓이를 출력합니다. 문자 C가 입력되면 종료합니다.
            System.out.println(w * h);

            if(a == 'C')
                break;
        }
    }
}