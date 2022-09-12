import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        char capital = sc.next().charAt(0);

        // 평가 계산
        String evaluation = null;
        if (capital == 'S') {
            evaluation = "Superior";
        } else if (capital == 'A') {
            evaluation = "Excellent";
        } else if (capital == 'B') {
            evaluation = "Good";
        } else if (capital == 'C') {
            evaluation = "Usually";
        } else if (capital == 'D') {
            evaluation = "Effort";
        } else {
            evaluation = "Failure";
        }

        // 출력
        System.out.println(evaluation);
    }
}