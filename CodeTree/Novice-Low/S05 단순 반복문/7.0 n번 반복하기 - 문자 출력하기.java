import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자 입력
        char c = sc.next().charAt(0);

        // 문자 공백없이 8회 출력
        for (int i = 0; i < 8; i++) {
            System.out.print(c);
        }
    }
}