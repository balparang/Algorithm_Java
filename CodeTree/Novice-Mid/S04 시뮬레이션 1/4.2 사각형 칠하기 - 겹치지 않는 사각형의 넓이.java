import java.util.Scanner;

public class Main {
    static final int MAX_R = 2000;
    static final int OFFSET = 1000;

    // A [x1, y1, x2, y2], B[], M[]
    static int[][] coords = new int[3][4];

    static int[][] checked = new int[MAX_R + 1][MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                coords[i][j] = sc.nextInt();
                // OFFSET
                coords[i][j] += OFFSET;
            }
        }
        // 사각형 색칠, M 사각형은 2로 색칠
        // A, B 색칠
        for (int i = 0; i < 2; i++) {
            // 사각형 하나 색칠
            for (int j = coords[i][0]; j < coords[i][2]; j++) { // x1 ~ x2
                for (int k = coords[i][1]; k < coords[i][3]; k++) { // y1 ~ y2
                    checked[j][k] = 1;
                }
            }
        }

        // M 색칠
        for (int i = coords[2][0]; i < coords[2][2]; i++) {
            for (int j = coords[2][1]; j < coords[2][3]; j++) {
                checked[i][j] = 2;
            }
        }

        // A, B 사각형을 포함하는 최소 직사각형 내부에서 '1'로 칠해진 개수 구하기
        // 포함하는 최소 직사각형의 행, 열 범위 구하기
        int x1 = Math.min(coords[0][0], coords[1][0]); // A[x1], B[x1] 비교
        int x2 = Math.max(coords[0][2], coords[1][2]);
        int y1 = Math.min(coords[0][1], coords[1][1]);
        int y2 = Math.max(coords[0][3], coords[1][3]);

        // 1로 칠해진 개수 구하기
        int cnt = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (checked[i][j] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}