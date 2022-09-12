import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] strToCharArr = str.toCharArray();
        char firstCh = str.charAt(0);
        char secondCh = str.charAt(1);

        // 첫 번째 문자와 같은 문자는 두 번째 문자로, 두 번째 문자와 같은 문자는 첫 번째 문자로
        for (int i = 0; i < strToCharArr.length; i++) {
            if (strToCharArr[i] == firstCh) {
                strToCharArr[i] = secondCh;
            } else if (strToCharArr[i] == secondCh) {
                strToCharArr[i] = firstCh;
            }
        }

        System.out.println(String.valueOf(strToCharArr));
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();

        // 문자열의 첫 번째 문자와 두 번째 문자를 저장합니다.
        char a = str.charAt(0);
        char b = str.charAt(1);

        // 문자열을 순회하면서 첫 번째 문자와 두 번째 문자를 교환합니다.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                str = str.substring(0, i) + b + str.substring(i + 1);
            else if (str.charAt(i) == b)
                str = str.substring(0, i) + a + str.substring(i + 1);
        }

        // 교환된 이후의 문자열을 출력합니다.
        System.out.println(str);
    }
}