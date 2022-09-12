import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // 1 ~ n 출력
        print1ToN(n);
        System.out.println();

        // n ~ 1 출력
        printNTo1(n);
    }

    private static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

    private static void printNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNTo1(n - 1);
    }
}