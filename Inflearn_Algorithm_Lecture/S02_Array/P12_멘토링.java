import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;

                for (int k = 0; k < m; k++) {
                    int posI = 0, posJ = 0;

                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) posI = s;
                        if (arr[k][s] == j) posJ = s;
                    }
                    if (posI < posJ) count++;
                }

                if(count == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));
    }
}