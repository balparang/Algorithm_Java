import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int score = sc.nextInt();

        // 출력
        String result = score == 100 ? "pass" : "failure";
        System.out.println(result);
    }
}