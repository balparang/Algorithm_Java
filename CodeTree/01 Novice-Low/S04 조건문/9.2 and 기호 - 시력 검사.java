import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        double L = sc.nextDouble();
        double R = sc.nextDouble();

        // 출력
        if (L > 1.0 && R > 1.0) {
            System.out.println("High");
        } else if (L > 0.5 && R > 0.5) {
            System.out.println("Middle");
        } else {
            System.out.println("Low");
        }
    }
}