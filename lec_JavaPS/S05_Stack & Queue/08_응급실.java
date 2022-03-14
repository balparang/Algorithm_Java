import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }

        while (!Q.isEmpty()) {
            Person temp = Q.poll();
            for (Person x : Q) {
                if (x.priority > temp.priority) {
                    Q.offer(temp);
                    temp = null;
                    break;
                }
            }

            if (temp != null) {
                answer++;
                if (temp.id == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}