import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    static int n, k;

    static void solution() {
        while (!queue1.isEmpty()) {

            for (int i = 1; i <= k - 1; i++) {
                queue1.add(queue1.poll());
            }

            // K번째 원소 제거
            queue2.add(queue1.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();

        // 큐에 원소 추가
        for (int i = 1; i <= n; i++) {
            queue1.add(i);
        }

        // K번째 사람 제거
        solution();

        // queue2의 원소 출력
        for (int person : queue2) {
            System.out.print(person + " ");
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

        // 큐 선언
        Queue<Integer> q = new LinkedList<>();

        // 변수 선언 및 입력:
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 큐로 현재 남은 사람들을 관리합니다.
        for (int i = 0; i < n; i++)
            q.add(i + 1);

        while (q.size() != 1) {
            // k번째 사람을 찾습니다.
            // 이 과정에서 이미 탐색한 사람은 맨 뒤로 옮겨줍니다.
            for (int i = 0; i < k - 1; i++)
                q.add(q.poll());

            // k번째 사람을 제거합니다.
            System.out.print(q.poll() + " ");
        }
        // 마지막 사람을 제거합니다.
        System.out.print(q.peek());
    }
}