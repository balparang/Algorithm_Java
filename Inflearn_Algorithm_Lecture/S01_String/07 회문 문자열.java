// 문자를 직접 비교
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String word) {
        word = word.toLowerCase();

        // 회문 검사
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        // 출력
        System.out.println(sol.solution(word));
    }
}

// StringBuilder.reverse() 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String word) {
        String reverse = new StringBuilder(word).reverse().toString();

        // 회문 검사
        if (word.equalsIgnoreCase(reverse)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        // 출력
        System.out.println(sol.solution(word));
    }
}

/**
 * 23.03.20 - lt, rt 기법 이용
 */
public class Main {

    public static void main(String[] args) throws IOException {

        main.Main T = new main.Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();

        // 출력
        System.out.println(T.solution(str));
    }

    public String solution(String str) {

        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {

            // 회문이 아닌 경우
            if (str.charAt(lt) != str.charAt(rt)) {
                return "NO";
            }

            lt++;
            rt--;
        }

        return "YES";
    }
}
