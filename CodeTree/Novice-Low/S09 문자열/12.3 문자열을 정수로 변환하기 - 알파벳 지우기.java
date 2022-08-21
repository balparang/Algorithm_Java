import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수
        String str1 = sc.next();
        String str2 = sc.next();

        // 문자열 -> 정수 변환
        int str1Num = strToNum(str1);
        int str2Num = strToNum(str2);

        // 출력
        int sum = str1Num + str2Num;
        System.out.println(sum);
    }

    public static int strToNum(String str) {
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String a;
        String b;
        String str1 = "";
        String str2 = "";

        // 문자열을 입력받습니다.
        a = sc.next();
        b = sc.next();

        // 문자열의 길이를 구합니다.
        int lenA = a.length();
        int lenB = b.length();
        int cnt1 = 0;
        int cnt2 = 0;

        // a의 정수로 변환 가능한 부분을 다른 문자열로 옮깁니다.
        for (int i = 0; i < lenA; i++)
            if (a.charAt(i) <= '9' && a.charAt(i) >= '0')
                str1 += a.charAt(i);

        // b의 정수로 변환 가능한 부분을 다른 문자열로 옮깁니다.
        for (int i = 0; i < lenB; i++)
            if (b.charAt(i) <= '9' && b.charAt(i) >= '0')
                str2 += b.charAt(i);

        // 합쳐진 문자열을 숫자로 바꿉니다.
        int str1Int = Integer.parseInt(str1);
        int str2Int = Integer.parseInt(str2);

        // 두 숫자의 합을 출력합니다.
        System.out.print(str1Int + str2Int);
    }
}