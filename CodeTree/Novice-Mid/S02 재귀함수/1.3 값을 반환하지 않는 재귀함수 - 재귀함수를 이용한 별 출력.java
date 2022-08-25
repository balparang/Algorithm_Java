import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt();

        // 재귀함수 호출
        printStar(n);
    }

    private static void printStar(int n) {
        if (n == 0) {
            return;
        }

        printStar(n - 1);
        System.out.print("*".repeat(n));
        System.out.println();
    }
}