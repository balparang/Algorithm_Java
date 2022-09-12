import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // 1부터 b까지의 수 중 a의 배수를 곱
        int prod = 1;
        for (int i = 1; i <= b; i++){
            if (i % a == 0) {
                prod *= i;
            }
        }

        System.out.println(prod);
    }
}