import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 길이가 n 인 정사각형
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(i + 1);
            }

            System.out.println();
        }
    }
}