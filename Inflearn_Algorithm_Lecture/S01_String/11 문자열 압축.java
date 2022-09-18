// 빈 문자 추가 테크닉
import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer = "";
        str = str + " ";
        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) { // i가 빈 문자 전까지. index 에러 방지
            if (str.charAt(i) != str.charAt(i + 1)) {
                answer += str.charAt(i);
                if(count > 1) answer += String.valueOf(count);
                count = 1;
            } else {
                count++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}