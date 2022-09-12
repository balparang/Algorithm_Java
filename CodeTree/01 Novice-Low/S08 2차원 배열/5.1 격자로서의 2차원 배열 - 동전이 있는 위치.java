import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt(); // 격자 크기 n * n
        int m = sc.nextInt(); // 횟수
        int[][] arr = new int[n][n];

        // 동전 채우기
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r - 1][c - 1] = 1;
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

// 해설 : n + 1 * n + 1 사이즈 격자 사용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2차원 배열을 구현합니다.
        int[][] arr = new int[10][10];

        // n, m을 입력받습니다.
        int n = sc.nextInt();
        int m = sc.nextInt();

        // m회에 걸쳐 동전의 위치를 입력받고 올바른 위치에 1을 표기합니다.
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = 1;
        }

        // 채워진 배열을 출력합니다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}