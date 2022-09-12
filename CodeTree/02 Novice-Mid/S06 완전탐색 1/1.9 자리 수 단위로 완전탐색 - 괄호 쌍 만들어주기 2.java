import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] a = str.toCharArray();
        int n = str.length();

        int cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n - 1; j++) {
                if (a[i] == '(' && a[i + 1] == '(' && a[j] == ')' && a[j + 1] == ')') {
                    cnt++;
                }
            }
        }

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
        int n = (int) str.length();

        // 모든 쌍을 다 잡아봅니다.
        int cnt = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n - 1; j++)
                if (str.charAt(i) == '(' && str.charAt(i + 1) == '('
                        && str.charAt(j) == ')' && str.charAt(j + 1) == ')')
                    cnt++;

        System.out.print(cnt);
    }
}