import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        String sumStr = Integer.toString(sum);

        int cnt = 0;
        for (char ch : sumStr.toCharArray()) {
            if (ch == '1') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자를 입력받습니다.
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 두 숫자를 더합니다.
        int c = a + b;
        String cStr;
        int cnt = 0;

        // 더한 값을 문자열로 바꿉니다.
        cStr = Integer.toString(c);

        // 문자열의 길이를 구합니다.
        int len = cStr.length();

        // 문자열에서 1이 나오는 개수를 체크합니다.
        for (int i = 0; i < len; i++)
            if (cStr.charAt(i) == '1')
                cnt++;

        // 1이 나오는 횟수를 출력합니다.
        System.out.print(cnt);
    }
}