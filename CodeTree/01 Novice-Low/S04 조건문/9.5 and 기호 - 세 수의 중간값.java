import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 크기 비교
        if (b > a && b < c) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}