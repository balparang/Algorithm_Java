import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        System.out.println(a >= b ? 1 : 0);
        System.out.println(a > b ? 1 : 0);
        System.out.println(b >= a ? 1 : 0);
        System.out.println(b > a ? 1 : 0);
    }
}