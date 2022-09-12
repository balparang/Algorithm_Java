import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 크기 비교
        if (a <= b && a <= c) { // a가 가장 작은 경우
            System.out.println(a);
        } else if (b <= a && b <= c) { // b가 가장 작은 경우
            System.out.println(b);
        } else { // c가 가장 작은 경우
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

        // a가 가장 작은 경우
        if (a <= b && a <= c) {
            System.out.println(a);
        }
        // b가 가장 작은 경우
        else if (b <= a && b <= c) {
            System.out.println(b);
        }
        // c가 가장 작은 경우
        else {
            System.out.println(c);
        }
    }
}