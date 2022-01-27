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