import java.util.Scanner;
import java.util.Stack;

public class Main {

    static boolean solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) return false;
                stack.pop();
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        if (solution(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

// 해설
import java.util.Scanner;
        import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        String str = sc.next();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                s.push('(');
            else {
                if (s.empty()) {
                    System.out.print("No");
                    System.exit(0);
                }
                s.pop();
            }
        }

        if (s.isEmpty()) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}