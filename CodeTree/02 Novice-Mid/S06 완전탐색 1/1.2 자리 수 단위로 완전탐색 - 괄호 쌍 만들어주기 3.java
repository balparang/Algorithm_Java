import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String brackets = sc.next();
        int len = brackets.length();

        // 완전탐색: 모든 괄호쌍 확인
        int cnt = 0;

        for (int i = 0; i < len - 1; i++) {
            char lBracket = brackets.charAt(i);

            for (int j = i; j < len; j++) {
                char rBracket = brackets.charAt(j);

                if (lBracket == '(' && rBracket == ')') {
                    cnt++;
                }
            }
        }

        // 출력
        System.out.println(cnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        str = sc.next();
        int n = str.length();

        // 모든 쌍을 다 잡아봅니다.
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (str.charAt(i) == '(' && str.charAt(j) == ')')
                    cnt++;

        System.out.println(cnt);
    }
}