import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 선언
        int[][] arr2d = new int[2][4];

        // 배열 입력
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                arr2d[i][j] = sc.nextInt();
            }
        }

        // 가로, 세로, 전체 평균 구하기
        int wholeSum = 0;

        // 가로 합, 전체 합 구하기
        for (int i = 0; i < 2; i++) {
            int horizontalSum = 0;

            for (int j = 0; j < 4; j++) {
                horizontalSum += arr2d[i][j];
                wholeSum += arr2d[i][j];
            }
            System.out.printf("%.1f ", (double) horizontalSum / 4);
        }
        System.out.println();

        // 세로 합 구하기
        for (int j = 0; j < 4; j++) {
            int verticalSum = 0;

            for (int i = 0; i < 2; i++) {
                verticalSum += arr2d[i][j];
            }
            System.out.printf("%.1f ", (double) verticalSum / 2);
        }
        System.out.println();

        System.out.printf("%.1f", (double) wholeSum / (2 * 4));
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2차원 배열을 구현합니다.
        int[][] arr2d = new int[2][4];
        int sum = 0;

        // 각 줄마다 정수를 입력받습니다.
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 4; j++)
                arr2d[i][j] = sc.nextInt();

        // 가로 평균을 출력합니다.
        for (int i = 0; i < 2; i++) {
            sum = 0;
            for (int j = 0; j < 4; j++)
                sum += arr2d[i][j];
            System.out.printf("%.1f ", (double) sum / 4);
        }
        System.out.println();

        // 세로 평균을 출력합니다.
        for (int i = 0; i < 4; i++) {
            sum = 0;
            for (int j = 0; j < 2; j++)
                sum += arr2d[j][i];
            System.out.printf("%.1f ", (double) sum / 2);
        }
        System.out.println();

        // 전체 평균을 출력합니다.
        sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++)
                sum += arr2d[i][j];
        }
        System.out.printf("%.1f", (double) sum / 8);
    }
}