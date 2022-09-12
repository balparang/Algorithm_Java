import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[4][4];

        // 배열 입력
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // i >= j 인 영역에 대하여 합 구하기
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i >= j) {
                    sum += arr[i][j];
                }
            }
        }

        // 출력
        System.out.println(sum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2차원 배열을 구현합니다.
        int[][] arr2d = new int[4][4];
        int sum = 0;

        // 각 줄마다 정수를 입력받습니다.
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                arr2d[i][j] = sc.nextInt();

        // 색칠된 칸에 있는 원소들의 합을 구합니다.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++)
                sum += arr2d[i][j];
        }

        System.out.println(sum);
    }
}