// 정규표현식 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String sentence) {
        sentence = sentence.replaceAll("[^0-9]", "");
        return Integer.parseInt(sentence);
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        System.out.println(sol.solution(sentence));
    }
}

// Chracter.isDigit() 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String sentence) {
        StringBuilder sb = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) { // 현재 문자가 숫자인지 확인
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        System.out.println(sol.solution(sentence));
    }
}

// 아스키 코드를 이용. 자릿수를 올려가며 정답 갱신하는 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(String sentence) {
        int answer = 0;

        for (char c : sentence.toCharArray()) {
            if (c >= 48 && c <= 57) {
                answer = (answer * 10) + (c - 48); // 자릿수 올리면서 갱신
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        System.out.println(sol.solution(sentence));
    }
}