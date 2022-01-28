// 배수들을 다 체크하는 에라토스테네스
import java.util.*;

public class Main {
    public int solution(int n) {
        int answer = 0;
        int[] check = new int[n + 1]; // [n]까지, 0으로 초기화 되어있음

        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) { // check[i]가 0 -> 숫자 i는 소수라는 뜻
                answer++;
                // 배수들을 전부 체크
                for (int j = i; j <= n; j = j + i) check[j] = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}