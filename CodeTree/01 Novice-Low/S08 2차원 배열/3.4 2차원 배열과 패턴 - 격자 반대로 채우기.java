import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        boolean isReverse = true; // 행을 역방향으로 순회할지에 대한 여부
        int count = 1;

        for (int i = n - 1; i >= 0; i--) {
            // 행을 역방향으로 순회
            if (isReverse) {
                for (int j = n - 1; j >= 0; j--) {
                    arr[j][i] = count++;
                }
                isReverse = false;
            }
            // 행을 정방향으로 순회
            else {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = count++;
                }
                isReverse = true;
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", arr[i][j]);
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

        // n을 입력받습니다.
        int n = sc.nextInt();

        // 2차원 배열을 구현합니다.
        int[][] arr = new int[10][10];

        // 격자를 채워줍니다.
        int count = 1;
        for (int col = n - 1; col >= 0; col--) {
            if ((n - 1 - col) % 2 == 0) { // 가장 마지막 열은 항상 n - 1 - col 이 값이 0이 된다.
                // 이 케이스에는 아래에서 위로 값을 채워줍니다.
                for (int row = n - 1; row >= 0; row--) {
                    arr[row][col] = count;
                    count++;
                }
            } else {
                // 이 케이스에는 위에서 아래로 값을 채워줍니다.
                for (int row = 0; row < n; row++) {
                    arr[row][col] = count;
                    count++;
                }
            }
        }

        // 출력:
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}