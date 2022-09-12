import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // 출력
        for (int i = n; i <= 100; i++) {
            System.out.print(i + " ");
        }
    }
}