import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 출력
        System.out.println(n);
        if (n < 0)
            System.out.println("minus");
    }
}