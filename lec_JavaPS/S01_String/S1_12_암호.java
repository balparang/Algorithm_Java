// subString, parseInt 사용
import java.util.Scanner;

public class Main {
    public String solution(int n, String str) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            // '#'을 '1'로 바꾼 문자열을 다시 '*'을 '0'으로 바꿈
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); // 2진수로 표기된 문자열 tmp를 10진수로 변환
            answer += (char)num;
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}