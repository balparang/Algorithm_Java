/**
 * 23.03.20
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

        String answer = "";

        char lastChar = str.charAt(0);
        int duplicatedCount = 1;

        for (int i = 1; i < str.length(); i++) {

            char currentChar = str.charAt(i);

            if (currentChar == lastChar) {
                duplicatedCount++;
            } else {
                answer += toZipFormat(duplicatedCount, lastChar);

                lastChar = currentChar;
                duplicatedCount = 1;
            }

            // 마지막 연속된 문자 확인
            if (i == str.length() - 1) {
                answer += toZipFormat(duplicatedCount, lastChar);
            }
        }

        return answer;
    }

    private String toZipFormat(int count, char lastChar) {

        if (count == 1) {
            return String.valueOf(lastChar);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lastChar);
        sb.append(count);
        return sb.toString();
    }
}

/**
 * 해설: 빈 문자 추가 테크닉
 */

package main;

    import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        main.Main T = new main.Main();

        // 입력
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 출력
        System.out.println(T.solution(str));
    }

    public String solution(String str) {

        String answer = "";

        // 마지막 문자의 연속성을 별도로 고려하지 않기 위해, 빈 문자 추가
        str += " ";

        // 문자열을 순회하며, 중복 문자 개수 세기
        int cnt = 1;

        for (int i = 0; i < str.length() - 1; i++) {

            // 현재 문자가 다음 문자와 같으면 count + 1
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {

                // 문자가 다르면 더 이상 중복이 아니므로 answer 에 append
                answer += str.charAt(i);

                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                }

                cnt = 1;
            }
        }

        return answer;
    }
}
