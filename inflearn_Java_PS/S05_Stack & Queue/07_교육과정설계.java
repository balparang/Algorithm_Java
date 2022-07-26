import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) Q.offer(x);

        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) { // 필수과목에는 있는데
                if (x != Q.poll()) return "NO"; // 듣는 순서가 안 맞으면 NO, 듣는 순서가 맞을 때는 그냥 넘어감
            }
        }

        if (!Q.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a, b));
    }
}