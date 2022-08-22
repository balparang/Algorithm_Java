import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(getMin(a, b, c));
    }

    // 3개의 정수 중 가장 작은 수 리턴
    public static int getMin(int a, int b, int c) {
        if (a > b) {
            if (b > c) {
                return c;
            } else {
                return b;
            }
        } else { // a <= b
            if (c < a) {
                return c;
            } else {
                return a;
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // 최솟값을 반환하는 함수를 작성합니다.
    public static int min(int a, int b, int c) {
        int minVal = a;
        if (minVal > b)
            minVal = b;
        if (minVal > c)
            minVal = c;

        return minVal;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(min(a, b, c));
    }
}