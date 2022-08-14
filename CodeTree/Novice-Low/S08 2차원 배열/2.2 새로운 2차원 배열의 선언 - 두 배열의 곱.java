import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 선언
        int[][] arr1 = new int[3][3];
        int[][] arr2 = new int[3][3];
        int[][] answer = new int[3][3];

        // 배열 입력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        // 배열 곱
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                answer[i][j] = arr1[i][j] * arr2[i][j];
            }
        }

        // 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}