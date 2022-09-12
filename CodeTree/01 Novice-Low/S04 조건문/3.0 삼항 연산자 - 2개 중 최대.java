import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 출력
        int maxnum = a > b ? a : b;
        System.out.println(maxnum);
    }
}