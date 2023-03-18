package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        main.Main T = new main.Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        // 출력
        System.out.println(T.solution(sentence));
    }

    public String solution(String sentence) {

        // split
        String[] words = sentence.split(" ");

        // 길이가 가장 긴 단어 찾기 & 기록
        String longestWord = null;
        int maxLength = -1;

        for (String word : words) {
            if (word.length() > maxLength) { // 길이가 같을 경우 앞 순번이 우선 순위
                maxLength = word.length();
                longestWord = word;
            }
        }

        return longestWord;
    }
}

/**
 * 해설
 */
public class Main {

    public static void main(String[] args) {

        main.Main T = new main.Main();

        // 입력
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 출력
        System.out.println(T.solution(str));
    }

    // indexOf() & substring
    public String solution(String str) {

        String answer = "";
        int maxLength = Integer.MIN_VALUE;
        int position = 0;

        // 띄어쓰기의 위치를 발견 못하면 '-1' 리턴
        while ((position = str.indexOf(' ')) != -1) {

            String tmp = str.substring(0, position); // 단어 잘라내기

            if (tmp.length() > maxLength) {
                maxLength = tmp.length();
                answer = tmp;
            }

            // str 갱신
            str = str.substring(position + 1); // 띄어쓰기 이후 인덱스 ~ 끝까지
        }

        // 마지막 단어 확인
        if (str.length() > maxLength) {
            maxLength = str.length();
            answer = str;
        }

        return answer;
    }
}
