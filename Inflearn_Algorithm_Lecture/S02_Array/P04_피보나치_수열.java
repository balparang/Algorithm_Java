// 배열 쓰지 않는 손코딩
import java.util.*;

public class Main {
    public void solution(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}

// memoization
import java.util.*;

public class Main {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = answer[1] = 1;

        for (int i = 2; i < n ; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int x : T.solution(n)) System.out.print(x + " ");
    }
}