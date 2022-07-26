import java.util.Scanner;

// i와 j가 같아도 상관없는 이유: 어차피 같은 조건이므로(cnt는 최소 5가 됨)
public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        // 인덱스 번호와 학생 번호 일치
        for (int i = 1; i <= n; i++) { // i번 학생이
            int cnt = 0; // i번 학생과 같은 반이었던 학생의 수

            for (int j = 1; j <= n; j++) { // j번 학생과
                for (int k = 1; k <= 5; k++) { // k학년에서 같은 반인지 확인
                    // i번 학생이 k학년 반과 j번 학생의 k학년 반이 같으면
                    // i와 j는 같아도 상관없음(모든 학생에게 동일한 조건)
                    if(arr[i][k] == arr[j][k]) {
                        cnt++; // 같은 반이었던 학생의 수 1증가
                        break; // 같은 반이었던 학생에 대해서는 한 번만 카운트
                    }
                }
            }

            if(cnt > max) {
                max = cnt;
                answer = i; // i번 학생이 같은 반이었던 학생수가 제일 많음
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}