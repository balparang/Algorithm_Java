// Try 1 - pass

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str1 = sc.next();
        String str2 = sc.next();

        // 정수 이외의 문자 전까지 정수 추출
        int str1Idx = findIndex(str1);
        int str1Num;

        if (str1Idx == -1) {
            // 문자열이 전부 정수인 경우
            str1Num = Integer.parseInt(str1);
        } else {
            // 일부만 정수인 경우, 정수가 아닌 문자 이전까지 substring
            str1Num = Integer.parseInt(str1.substring(0, str1Idx));
        }

        int str2Idx = findIndex(str2);
        int str2Num;

        if (str2Idx == -1) {
            str2Num = Integer.parseInt(str2);
        } else {
            str2Num = Integer.parseInt(str2.substring(0, str2Idx));
        }

        // 출렭
        int sum = str1Num + str2Num;
        System.out.println(sum);
    }

    // 정수가 아닌 문자의 위치 추출
    public static int findIndex(String str) {
        int idx = -1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                idx = i;
                break;
            }
        }

        return idx;
    }
}

// Try 2 - pass : 해설 참고하여 리팩토링
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str1 = sc.next();
        String str2 = sc.next();

        // 정수 이외의 문자 전까지 정수 추출
        int str1Idx = findIndex(str1);
        int str1Num = Integer.parseInt(str1.substring(0, str1Idx));
        int str2Idx = findIndex(str2);
        int str2Num = Integer.parseInt(str2.substring(0, str2Idx));

        // 출력
        int sum = str1Num + str2Num;
        System.out.println(sum);
    }

    // 인덱스 추출
    public static int findIndex(String str) {
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                break;
            }
            idx++;
        }
        return idx;
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
        String str1;
        String str2;

        // 문자열을 입력받습니다.
        a = sc.next();
        b = sc.next();

        // 문자열의 길이를 구합니다.
        int lenA = a.length();
        int lenB = b.length();

        int idx1 = 0;
        int idx2 = 0;

        // a의 정수로 변환 가능한 최대 인덱스를 찾습니다.
        for (int i = 0; i < lenA; i++)
            if (a.charAt(i) <= '9' && a.charAt(i) >= '0')
                idx1++;
            else break;

        // b의 정수로 변환 가능한 최대 인덱스를 찾습니다.
        for (int i = 0; i < lenB; i++)
            if (b.charAt(i) <= '9' && b.charAt(i) >= '0')
                idx2++;
            else break;

        // a의 정수로 변환 가능한 부분을 다른 문자열로 옮깁니다.
        str1 = a.substring(0, idx1);

        // b의 정수로 변환 가능한 부분을 다른 문자열로 옮깁니다.
        str2 = b.substring(0, idx2);

        // 합쳐진 문자열을 숫자로 바꿉니다.
        int str1Int = Integer.parseInt(str1);
        int str2Int = Integer.parseInt(str2);

        // 두 숫자의 합을 출력합니다.
        System.out.print(str1Int + str2Int);
    }
}