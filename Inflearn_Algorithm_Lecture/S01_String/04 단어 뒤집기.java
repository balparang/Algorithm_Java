// StringBuilder 의 reverse 메서드 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<String> solution(String[] wordArr) {
        ArrayList<String> reverseArr = new ArrayList<>();

        for (String word : wordArr) {
            String reverse = new StringBuilder(word).reverse().toString();
            reverseArr.add(reverse);
        }

        return reverseArr;
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] wordArr = new String[count];

        for (int i = 0; i < count; i++) {
            wordArr[i] = br.readLine();
        }

        // 출력
        for (String word : sol.solution(wordArr)) {
            System.out.println(word);
        }
    }
}

// 배열을 이용하여 직접 단어 뒤집기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public ArrayList<String> solution(String[] wordArr) {
        ArrayList<String> reverseArr = new ArrayList<>();

        for (String word : wordArr) {
            char[] charArr = word.toCharArray();

            // lt : 배열 처음에서 출발하는 인덱스
            // rt : 배열 끝에서 출발하는 인덱스
            int lt = 0, rt = charArr.length - 1;
            while (lt < rt) {
                // 문자 스왑
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;

                // 인덱스 이동
                lt++;
                rt--;
            }

            String reverse = String.valueOf(charArr); // 문자 배열 -> 문자열
            reverseArr.add(reverse);
        }

        return reverseArr;
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] wordArr = new String[count];

        for (int i = 0; i < count; i++) {
            wordArr[i] = br.readLine();
        }

        // 출력
        for (String word : sol.solution(wordArr)) {
            System.out.println(word);
        }
    }
}

/**
 * 23.03.19
 * StringBuilder::reverse 이용
 */
public class Main {

    public static void main(String[] args) throws IOException {

        main.Main T = new main.Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine());
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            words[i] = br.readLine();
        }

        // 출력
        String[] result = T.solution(words);

        for (String s : result) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] words) {

        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = new StringBuilder(words[i]).reverse().toString();
        }

        return reversedWords;
    }
}

/**
 * 해설: 인덱스를 이용하여 글자 바꾸기 lt & rt 기법
 */
public class Main {

    public static void main(String[] args) {

        main.Main T = new main.Main();

        // 입력
        Scanner sc = new Scanner(System.in);
        int wordCount = sc.nextInt();
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = sc.next();
        }

        // 출력
        for (String word : T.solution(wordCount, words)) {
            System.out.println(word);
        }
    }

    /**
     * 인덱스를 이용하여 글자 바꾸기 lt & rt 기법
     */
    public ArrayList<String> solution(int wordCount, String[] words) {

        ArrayList<String> answer = new ArrayList<>();

        for (String word : words) {

            // 01234
            // study
            // lt -> [0] 부터 시작
            // rt -> [len-1] 부터 시작
            char[] chars = word.toCharArray();
            int lt = 0, rt = word.length() - 1;

            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;

                lt++;
                rt--;
            }

            answer.add(String.valueOf(chars));
        }

        return answer;
    }
}
