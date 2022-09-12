import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(j + 1);
                }
            } else {
                for (int j = 0; j < n; j++) {
                    System.out.print(n - j);
                }
            }

            System.out.println();
        }
    }
}
