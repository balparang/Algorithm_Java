import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // 정수 배열 입력 & 문자열 변환
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sb.append(num);
        }
        String str = sb.toString();

        // 출력
        for (int i = 0; i < str.length(); i += 5) {
            for (int j = i; j < i + 5; j++) {
                System.out.print(str.charAt(j));

                if (j == str.length() - 1) {
                    break;
                }
            }
            System.out.println();
        }
    }
}

// 해설 : 개행하는 시점을 조건문으로 작성
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String[] str = new String[10];
        String strAll = "";

        // n을 입력받습니다.
        int n = sc.nextInt();

        // 공백 단위로 문자열을 입력받습니다.
        for (int i = 0; i < n; i++)
            str[i] = sc.next();

        // 문자열을 전부 붙입니다.
        for (int i = 0; i < n; i++)
            strAll += str[i];

        // 합쳐진 문자열의 길이를 구합니다.
        int len = strAll.length();

        // 합쳐진 문자열을 5개의 숫자마다 개행을 하여 출력합니다.
        for (int i = 0; i < len; i++) {
            System.out.print(strAll.charAt(i));
            if ((i + 1) % 5 == 0)
                System.out.println();
        }
    }
}