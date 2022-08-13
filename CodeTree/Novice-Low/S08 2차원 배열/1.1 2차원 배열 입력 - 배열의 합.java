import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 선언
        int[][] arr2d = new int[4][4];

        // 배열 입력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr2d[i][j] = sc.nextInt();
            }
        }

        // 행의 합 구하기
        for (int i = 0; i < 4; i++) {
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                sum += arr2d[i][j];
            }

            // 출력
            System.out.println(sum);
        }
    }
}