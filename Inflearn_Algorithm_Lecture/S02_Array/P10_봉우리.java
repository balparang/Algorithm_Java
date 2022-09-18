import java.util.Scanner;

public class Main {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true; // 봉우리인지 아닌지 판별하는 변수
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // 0 <= nx, ny < n 이어야함 (인덱스)
                    // nx, ny 인덱스 조건 범위가 크기 비교보다 우선 되어야함(연산 순서)
                    if (nx >= 0 && nx < n&& ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) { // 크거나 같은게 하나라도 있으면
                        flag = false;
                        break; // 더 이상 나머지 볼 필요 없음
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}