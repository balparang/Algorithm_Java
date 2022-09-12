import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = sc.next().charAt(0);
        int n = sc.nextInt();

        // c가 'A' 면 1부터 n까지 숫자 증가하면서 출력
        if (c == 'A') {
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
        }

        // c가 'D' 면 n부터 1까지 숫자 감소하면서 출력
        else {
            for (int i = n; i >= 1; i--) {
                System.out.print(i + " ");
            }
        }
    }
}