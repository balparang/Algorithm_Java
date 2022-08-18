import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] strToCharArr = str.toCharArray();

        // 앞에서 두 번째 문자와 뒤에서 두 번째 문자를 'a'로 변경
        strToCharArr[1] = 'a';
        strToCharArr[strToCharArr.length - 2] = 'a';

        // 출력
        System.out.println(String.valueOf(strToCharArr));
    }
}

// 해설 : substring()
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // 문자열의 앞에서 두 번째 원소와 뒤에서 두 번째 원소를 'a'로 대체합니다.
        str = str.substring(0, 1) + "a" + str.substring(2);
        str = str.substring(0, len - 2) + "a" + str.substring(len - 1);

        // 대체된 이후의 문자열을 출력합니다
        System.out.println(str);
    }
}