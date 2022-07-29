import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // a이상 b이하의 홀수 출력
        for (int i = a; i >= b; i -= 2) {
            System.out.print(i + " ");
        }
    }
}