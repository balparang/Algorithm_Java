import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public String solution(String str) {

        String answer;
        char[] s = str.toCharArray();
        int lt = 0, rt = s.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) { // 알파벳이 아니라면
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) { // 알파벳이 아니라면
                rt--;
            } else {
                char tmp = s[lt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}

/**
 * 23.03.19
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

        // 문자를 순회하면서, 특수문자가 아닌경우에만 switch
        char[] chars = str.toCharArray();
        int lt = 0, rt = chars.length - 1;

        while (lt < rt) {

            if (!Character.isAlphabetic(chars[lt])) { // 알파벳인 경우 switch
                lt++;
                continue;
            }

            if (!Character.isAlphabetic(chars[rt])) {
                rt--;
                continue;
            }

            // chars[lt] && chars[rt] 가 모두 알파벳.
            // switch chars[lt] <-> chars[rt]
            char tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;

            lt++;
            rt--;
        }

        return String.valueOf(chars);
    }
}