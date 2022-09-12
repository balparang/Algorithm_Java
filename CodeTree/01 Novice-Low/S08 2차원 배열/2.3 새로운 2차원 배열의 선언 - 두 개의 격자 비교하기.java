import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        // 배열 선언
        int[][] arr1 = new int[row][col];
        int[][] arr2 = new int[row][col];
        int[][] answer = new int[row][col];

        // 배열 입력
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        // 새로운 배열에 먼저 생성한 두 배열의 같은 위치에서의 원소가 같으면 0, 다르면 1을 입력
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr1[i][j] == arr2[i][j]) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = 1;
                }
            }
        }

        // 출력
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 해설 - 삼항 연산자 사용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 입력받습니다.
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 2차원 배열을 구현합니다.
        int[][] arr1 = new int[10][10];
        int[][] arr2 = new int[10][10];
        int[][] arr3 = new int[10][10];

        // 첫 번째 배열의 입력을 받습니다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr1[i][j] = sc.nextInt();

        // 두 번째 배열의 입력을 받습니다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr2[i][j] = sc.nextInt();

        // 두 배열의 같음 여부를 새로운 배열에 담습니다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr3[i][j] = arr1[i][j] == arr2[i][j] ? 0 : 1;

        // 새로운 배열을 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(arr3[i][j] + " ");
            System.out.println();
        }
    }
}