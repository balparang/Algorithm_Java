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

/**
 * 해설
 */
public class Main {

    public static void main(String[] args) throws IOException {

        main.Main T = new main.Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 출력
        System.out.println(T.solution(str));
    }

    public String solution(String str) {

		 /*
		 	모든 문자를 대문자로 만들고,
		 	대문자가 아닌 문자를 정규식을 이용하여 제거
		 */
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String reversed = new StringBuilder(str).reverse().toString();
        if (reversed.equals(str)) {
            return "YES";
        }

        return "NO";
    }
}