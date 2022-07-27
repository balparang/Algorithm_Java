import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();

        // 출력
        if (a % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        if (a % 5 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}