import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // feedback: 문자열이 알파벳으로만 이루어졌기 때문에,
            // if if 보다 if else 사용이 더 나아보인다.
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch - 'a' + 'A'));
            }

            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch - 'A' + 'a'));
            }
        }

        System.out.println(sb.toString());
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String str;

        // 문자열을 입력받습니다.
        str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // 소문자와 대문자를 바꾸어 출력합니다.
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                System.out.print((char) (str.charAt(i) - 'A' + 'a'));
            } else {
                System.out.print((char) (str.charAt(i) - 'a' + 'A'));
            }
        }
    }
}