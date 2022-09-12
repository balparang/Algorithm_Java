import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        // 배열에 원소 채우기
        int num = 0;
        for (int i = 0; i < col; i++) {
            // 짝수 열
            if (i % 2 == 0) {
                for (int j = 0; j < row; j++) {
                    arr[j][i] = num++;
                }
            }
            // 홀수 열
            else {
                for (int j = row - 1; j >= 0; j--) {
                    arr[j][i] = num++;
                }
            }
        }

        // 출력
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 입력받습니다.
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 2차원 배열을 구현합니다.
        int[][] arr = new int[100][100];

        // Step 1:
        int count = 0;
        for (int col = 0; col < m; col++) {
            if (col % 2 == 0) {
                // Case 1:
                for (int row = 0; row < n; row++) {
                    arr[row][col] = count;
                    count++;
                }
            } else {
                // Case 2:
                for (int row = n - 1; row >= 0; row--) {
                    arr[row][col] = count;
                    count++;
                }
            }
        }

        // 출력:
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}