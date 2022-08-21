import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String inputStr = sc.next();

        // 숫자 또는 알파벳 출력, 단 대문자는 소문자로 변경하여 출력
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);

            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                System.out.print(ch);
            }

            if (ch >= 'A' && ch <= 'Z') {
                System.out.print((char) (ch - 'A' + 'a'));
            }
        }
    }
}