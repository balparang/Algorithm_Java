import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int sum = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += Integer.parseInt(String.valueOf(ch));
            }
        }

        System.out.println(sum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String str;
        int ans = 0;

        // 문자열을 입력받습니다.
        str = sc.next();

        // 문자열을 순회하여 숫자들만 골라 더해줍니다.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                ans += (str.charAt(i) - '0');
        }

        System.out.print(ans);
    }
}