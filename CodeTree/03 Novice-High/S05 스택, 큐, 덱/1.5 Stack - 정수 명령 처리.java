import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Stack<Integer> stack = new Stack<>();
    static int n;

    static void command(String order) {
        switch (order) {
            case "push":
                int num = sc.nextInt();
                stack.push(num);
                break;
            case "pop":
                System.out.println(stack.pop());
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                if (stack.empty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "top":
                System.out.println(stack.peek());
                break;
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String order = sc.next();
            command(order);
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
        int n = sc.nextInt();

        // 스택 선언
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                int x = sc.nextInt();
                s.push(x);
            } else if (command.equals("pop")) {
                System.out.println(s.pop());
            } else if (command.equals("size")) {
                System.out.println(s.size());
            } else if (command.equals("empty")) {
                if (s.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else {
                System.out.println(s.peek());
            }
        }
    }
}

