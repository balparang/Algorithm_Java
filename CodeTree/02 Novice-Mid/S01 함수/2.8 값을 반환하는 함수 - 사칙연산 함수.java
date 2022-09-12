import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        char operator = sc.next().charAt(0);
        int b = sc.nextInt();

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
            System.out.println("False");
        } else {
            System.out.printf("%d %c %d = %d", a, operator, b, calc(a, operator, b));
        }
    }

    private static int calc(int a, char operator, int b) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // 두 수의 합을 반환하는 함수를 작성합니다.
    public static int plus(int a, int b) {
        return a + b;
    }

    // a에서 b를 뺀 값을 반환하는 함수를 작성합니다.
    public static int minus(int a, int b) {
        return a - b;
    }

    // 두 수의 곱을 반환하는 함수를 작성합니다.
    public static int times(int a, int b) {
        return a * b;
    }

    // a를 b로 나눈 나머지를 반환하는 함수를 작성합니다.
    public static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();

        if (o == '+')
            System.out.print(a + " + " + c + " = " + plus(a, c));
        else if (o == '-')
            System.out.print(a + " - " + c + " = " + minus(a, c));
        else if (o == '*')
            System.out.print(a + " * " + c + " = " + times(a, c));
        else if (o == '/')
            System.out.print(a + " / " + c + " = " + divide(a, c));
        else
            System.out.print("False");

    }
}