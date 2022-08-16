// Try 1 - fail : 테스트 케이스 "a"
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        char lastChar = str.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        // Run Length 인코딩
        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);

            if (lastChar == currChar) {
                cnt++;
            } else {
                sb.append(lastChar);
                sb.append(cnt);
                lastChar = currChar;
                cnt = 1;
            }

            if (i == str.length() - 1) {
                sb.append(lastChar);
                sb.append(cnt);
            }
        }

        // 출력
        System.out.println(sb.toString().length());
        System.out.println(sb);
    }
}

// Try 2 - pass : 길이가 1인 문자열에 대한 코드 추가
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        char lastChar = str.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        // Run Length 인코딩
        // case 1: 길이가 1인 문자열이 주어지는 경우
        if (str.length() == 1) {
            sb.append(lastChar);
            sb.append(cnt);
        }

        // case 2: 길이가 2이상인 문자열이 주어지는 경우
        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);

            if (lastChar == currChar) {
                cnt++;
            } else {
                sb.append(lastChar);
                sb.append(cnt);
                lastChar = currChar;
                cnt = 1;
            }

            if (i == str.length() - 1) {
                sb.append(lastChar);
                sb.append(cnt);
            }
        }

        // 출력
        System.out.println(sb.toString().length());
        System.out.println(sb);
    }
}