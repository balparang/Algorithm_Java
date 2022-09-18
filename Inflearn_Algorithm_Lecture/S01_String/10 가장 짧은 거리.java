import java.util.Scanner;

public class Main {
    public int[] solution(String str, char target) {
        int[] answer = new int[str.length()];
        int p = 1000; // p가 1000인 이유 : (조건) 문자열 길이 최대 100

        // 좌 -> 우 방향 탐색. 각 알파벳 기준 좌측의 target문자와의 거리 비교
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) { // target문자와 일치하면 거리는 '0'
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        // 좌 <- 우 방향 탐색. 각 알파벳 기준 우측의 target문자와의 거리 계산
        p = 1000; // 거리값 초기화
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == target) { // target문자와 일치하면 거리는 '0'
                p = 0;
            } else {
                p++;
                if (p < answer[i]) {
                    answer[i] = p;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);

        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}