import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer = "NO";
        // A-Z가 '아니면(^의 의미)', "" 빈 문자화 시켜라
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) { // 팰린드롬 확인
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}