import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][5];

        // 1행과 1열을 1로 채우기
        for (int i = 0; i < 5; i++) {
            arr[0][i] = 1; // 1행
            arr[i][0] = 1; // 1열
        }

        // 나머지 영역 채우기
        for (int row = 1; row < 5; row++) {
            for (int col = 1; col < 5; col++) {
                arr[row][col] = arr[row-1][col] + arr[row][col - 1];
            }
        }

        // 출력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}