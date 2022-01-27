import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos; // position

        while ((pos = str.indexOf(' ')) != -1) { // indexOf(String str), 해당 문자를 찾지 못했을 때는 -1을 리턴
            String tmp = str.substring(0, pos);
            int len = tmp.length();

            if (len > m) {
                m = len;
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        if (str.length() > m) { // 마지막 단어 체크
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 한 단어가 아니라 한 줄을 입력 받기 때문
        System.out.println(T.solution(str));
    }
}
---------------------------
// ref2
import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos; // position

        while ((pos = str.indexOf(' ')) != -1) { // indexOf(String str), 해당 문자를 찾지 못했을 때는 -1을 리턴
            String tmp = str.substring(0, pos); // [0] ~ [pos - 1] 까지 잘림
            int len = tmp.length();

            if (len > m) {
                m = len;
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        if (str.length() > m) { // 마지막 단어 체크
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 한 단어가 아니라 한 줄을 입력 받기 때문
        System.out.println(T.solution(str));
    }
}