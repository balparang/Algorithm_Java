import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static Stack<Integer> solution(int s, int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (stack.contains(arr[i])) { // stack에 해당 작업 있을 시

                while (stack.peek() != arr[i]) {
                    tmpStack.push(stack.pop());
                }
                int target = stack.pop();

                while (!tmpStack.isEmpty()) {
                    stack.push(tmpStack.pop());
                }
                stack.push(target);

            } else { // stack에 해당 작업 없을 시

                if (stack.size() < s) {

                    stack.push(arr[i]);

                } else {

                    while (stack.size() != 1) {
                        tmpStack.push(stack.pop());
                    }
                    stack.pop();
                    while (!tmpStack.isEmpty()) {
                        stack.push(tmpStack.pop());
                    }
                    stack.push(arr[i]);
                }

            }
        }

        return stack;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = solution(n, s, arr);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}