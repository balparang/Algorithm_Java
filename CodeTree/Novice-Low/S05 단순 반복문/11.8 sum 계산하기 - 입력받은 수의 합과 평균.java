import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Your Program Goes Here

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += sc.nextInt();
        }

        double avg = (double) sum / n;

        System.out.printf("%d %.1f", sum, avg);
    }
}