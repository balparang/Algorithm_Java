import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 -> 문자 배열 변환
        String inputStr = sc.next();
        char[] arr = inputStr.toCharArray();

        // 원소가 소문자이면 대문자로 변환
        for (int i = 0; i < arr.length; i++) {
            // 소문자 -> 대문자 변환
            if ('a' <= arr[i] && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] - 'a' + 'A');
            }
        }

        // 대문자만 출력
        for (int i = 0; i < arr.length; i++) {
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                System.out.print(arr[i]);
            }
        }
    }
}

// 해설: 변환하여 바로 출력
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String str;

        // 문자열을 입력받습니다.
        str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // 문자를 하나하나 확인하여 알파벳일 경우 모두 대문자로 출력합니다.
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                System.out.print(str.charAt(i));
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                System.out.print((char) (str.charAt(i) - 'a' + 'A'));
        }
    }
}