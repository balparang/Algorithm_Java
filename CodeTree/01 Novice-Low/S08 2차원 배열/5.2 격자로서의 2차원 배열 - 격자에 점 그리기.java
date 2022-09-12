import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt(); // 격자 크기 n * n
        int m = sc.nextInt(); // 횟수
        int[][] arr = new int[n + 1][n + 1];
        int count = 1;

        // 점 채우기
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = count++;
        }

        // 출력
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}