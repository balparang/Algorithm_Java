import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            if (str.equals("push")) {
                int num = sc.nextInt();
                queue.add(num);
            } else if (str.equals("pop")) {
                System.out.println(queue.poll());
            } else if (str.equals("size")) {
                System.out.println(queue.size());
            } else if (str.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str.equals("front")) {
                System.out.println(queue.peek());
            }
        }
    }
}

// 해설
import java.util.Scanner;
        import java.util.Queue;
        import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();

        // 큐 선언
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                int x = sc.nextInt();
                q.add(x);
            } else if (command.equals("pop")) {
                System.out.println(q.poll());
            } else if (command.equals("size")) {
                System.out.println(q.size());
            } else if (command.equals("empty")) {
                if (q.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else {
                System.out.println(q.peek());
            }
        }
    }
}