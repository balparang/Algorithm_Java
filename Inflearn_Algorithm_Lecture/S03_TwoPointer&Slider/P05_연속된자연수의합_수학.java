import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0, cnt = 1;
        n--;
        while (n > 0) {
            cnt++; // cnt = 2 // cnt = 3
            n = n - cnt; // n에서 1과 2를 뺌, 현재 n이 12 // 12 - 3 = 9,
            if(n % cnt == 0) answer++; // 12가 2로 나눠떨어져져서 1, 2에 6씩 더해 (7,8) 조합 완성 // 몫 3으로 나눠떨어짐 (4, 5, 6)완성성
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}