import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행, 열 크기 입력
        int row = sc.nextInt();
        int col = sc.nextInt();

        // 배열 선언
        int[][] matrix = new int[row][col];

        // 배열 입력
        int num = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = num;
                num++;
            }
        }

        // 출력
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}