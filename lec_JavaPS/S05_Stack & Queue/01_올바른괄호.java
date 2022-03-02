import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else { // 닫는 괄호인데
                if (stack.isEmpty()) return "NO"; // 스택이 비어있는 경우
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO"; // 여는 괄호가 스택에 남아 있는 경우
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}