// StringBuilder 의 reverse 메서드 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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