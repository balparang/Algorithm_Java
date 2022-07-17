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