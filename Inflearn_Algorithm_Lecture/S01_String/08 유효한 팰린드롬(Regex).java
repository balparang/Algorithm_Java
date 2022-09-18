// 정규표현식(Regex) 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String sentence) {
        // 알파벳 a~z를 제외한 문자 제거
        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");

        // 회문 검사
        String reverse = new StringBuilder(sentence).reverse().toString();
        if (sentence.equals(reverse)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        System.out.println(sol.solution(sentence));
    }
}