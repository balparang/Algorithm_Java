import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String[] strArr = new String[10];
        char ch;
        int matchCount = 0;

        // 데이터 입력
        for (int i = 0; i < 10; i++) {
            strArr[i] = sc.next();
        }
        ch = sc.next().charAt(0);

        // 배열을 순회하면서 특정 알파벳으로 끝나는 문자열 출력
        for (String str : strArr) {
            if (str.charAt(str.length() - 1) == ch) {
                System.out.println(str);
                matchCount++;
            }
        }

        // 주어진 문자로 끝나는 문자열이 없다면 "None" 출력
        if (matchCount == 0) {
            System.out.println("None");
        }
    }
}