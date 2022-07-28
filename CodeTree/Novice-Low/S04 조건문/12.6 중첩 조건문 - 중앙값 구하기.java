import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // a가 중앙값인 경우
        if ((c < a && a < b) || (b < a && a < c)) {
            System.out.println(a);
        }

        // b가 중앙값인 경우
        else if ((a < b && b < c) || (c < b && b < a)) {
            System.out.println(b);
        }

        // c가 중앙값인 경우
        else {
            System.out.println(c);
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a, b, c;

        // 입력
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // 출력
        if(a > b) {
            if(c > a) {
                // a > b, c > a 일때 (c > a > b)
                System.out.println(a);
            }
            // a > b, a > c 일때 (a가 가장 크고, b와 c중 더 큰 수가 중앙값)
            else if(b > c) {
                System.out.println(b);
            }
            else {
                System.out.println(c);
            }
        }
        else {
            if(c > b) {
                // b > a, c > b 일때 (c > b > a)
                System.out.println(b);
            }
            // b > a, b > c 일때 (b가 가장 크고, a와 c중 더 큰 수가 중앙값)
            else if(a > c) {
                System.out.println(a);
            }
            else {
                System.out.println(c);
            }
        }
    }
}