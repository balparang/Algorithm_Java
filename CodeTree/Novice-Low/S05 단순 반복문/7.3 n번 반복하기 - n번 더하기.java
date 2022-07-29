import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a, n 입력
        int a = sc.nextInt();
        int n = sc.nextInt();

        // a에 n을 n번 더하여 개행하며 출력
        for (int i = 0; i < n; i++) {
            a += n;
            System.out.println(a);
        }
    }
}