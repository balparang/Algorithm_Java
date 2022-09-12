import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();

        // 출력
        if (a < 10 || a > 20) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}