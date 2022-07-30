import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // a 부터 b까지의 곱
        int prod = 1;
        for (int i = a; i <= b; i++) {
            prod *= i;
        }

        System.out.println(prod);
    }
}