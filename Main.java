import java.util.*;

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sumColumn, sumRow; // 행의 합, 열의 합
        int diag1 = 0, diag2 = 0;

        // 행, 열의 합
        for (int i = 0; i < n; i++) {
            sumColumn = sumRow = 0;
            for (int j = 0; j < n; j++) {
                sumColumn += arr[i][j];
                sumRow += arr[j][i];
            }
            answer = Math.max(answer, sumColumn);
            answer = Math.max(answer, sumRow);
        }

        // diagonal
        for (int i = 0; i < n; i++) {
            diag1 += arr[i][i];
            diag2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, diag1);
        answer = Math.max(answer, diag2);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, arr));
    }
}