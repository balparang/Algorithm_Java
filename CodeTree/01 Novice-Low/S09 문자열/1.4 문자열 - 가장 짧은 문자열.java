import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = new String[3];
        for (int i = 0; i < 3; i++) {
            strArr[i] = sc.next();
        }

        int maxLength = strArr[0].length();
        int minLength = strArr[0].length();
        for (int i = 1; i < 3; i++) {
            if (strArr[i].length() < minLength) {
                minLength = strArr[i].length();
            }

            if (strArr[i].length() > maxLength) {
                maxLength = strArr[i].length();
            }
        }

        System.out.println(maxLength - minLength);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = sc.next();

        // 문자열의 길이를 구합니다.
        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        // 세 문자열 중 가장 긴 길이와 가장 짧은 길이를 구합니다.
        int mx = len1;
        if (mx < len2) mx = len2;
        if (mx < len3) mx = len3;
        int mn = len1;
        if (mn > len2) mn = len2;
        if (mn > len3) mn = len3;

        // 문제에서 구하고자 하는 값을 출력합니다.
        System.out.print(mx - mn);
    }
}