import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('('); // 여는 괄호면 일단 push
            else {  // 닫는 괄호면 레이저인지, 막대기의 끝인지 확인
                stack.pop(); // 레이저 또는 막대기의 여는 괄호 pop
                if (str.charAt(i - 1) == '(') answer += stack.size(); // 이전 타겟이 여는 괄호면 현재 타겟은 레이저의 닫는괄호
                else answer++; // 이전 타겟이 닫는 괄호면 현재 타겟은 막대기의 끝
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str));
    }
}