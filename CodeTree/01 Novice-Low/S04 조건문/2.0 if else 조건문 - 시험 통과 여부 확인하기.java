import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int score = sc.nextInt();

        // 출력
        if (score >= 80) {
            System.out.println("pass");
        } else {
            System.out.printf("%d more score", 80 - score);
        }
    }
}