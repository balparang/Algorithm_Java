import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        char[] strToChar = str.toCharArray();
        int query = sc.nextInt();

        for (int i = 0; i < query; i++) {
            int queryType = sc.nextInt();

            // 1 a b : a 번째 문자와 b 번째 문자를 교환한 뒤 출력
            if (queryType == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(swap(a, b, strToChar));
            }
            // 2 a b : 문자 a를 전부 문자 b로 변경한 뒤 출력
            else {
                char targetCh = sc.next().charAt(0);
                char toChange = sc.next().charAt(0);
                System.out.println(changeAll(targetCh, toChange, strToChar));
            }
        }
    }

    public static String swap(int a, int b, char[] charArr) {
        char tmp = charArr[a - 1];
        charArr[a - 1] = charArr[b - 1];
        charArr[b - 1] = tmp;
        return String.valueOf(charArr);
    }

    public static String changeAll(char targetCh, char toChange, char[] charArr) {
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == targetCh) {
                charArr[i] = toChange;
            }
        }
        return String.valueOf(charArr);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();
        int q = sc.nextInt();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // q개의 질의를 수행합니다.
        for (int i = 0; i < q; i++) {
            // 몇번째 질의인지 확인합니다.
            int qType = sc.nextInt();

            if (qType == 1) {
                // a, b를 입력받은 후, a번째 문자와 b번째 문자를 교환하여 출력합니다.
                int a = sc.nextInt();
                int b = sc.nextInt();

                char tmp = str.charAt(a - 1);

                // a번째 문자의 자리에 b번째 문자를 넣습니다.
                str = str.substring(0, a - 1) + str.charAt(b - 1) + str.substring(a);

                // b번째 문자의 자리에 a번째 문자를 넣습니다.
                str = str.substring(0, b - 1) + tmp + str.substring(b);

                System.out.println(str);
            } else {
                // a, b를 입력받은 후, 문자 a를 전부 b로 변경한 뒤 출력합니다.
                char a = sc.next().charAt(0);
                char b = sc.next().charAt(0);

                // 문자 a를 전부 b로 변경합니다.
                for (int j = 0; j < len; j++)
                    if (str.charAt(j) == a)
                        str = str.substring(0, j) + b + str.substring(j + 1);

                System.out.println(str);
            }
        }
    }
}