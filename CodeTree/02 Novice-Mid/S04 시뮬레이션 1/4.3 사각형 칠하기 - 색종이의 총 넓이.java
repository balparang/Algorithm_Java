import java.util.Scanner;

public class Main {
    static final int OFFSET = 100;
    static final int MAX_R = 200;
    static final int MAX_N = 100;

    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];
    static int[][] checked = new int[MAX_R + 1][MAX_R + 1];

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();

            // OFFSET 적용
            x[i] += OFFSET;
            y[i] += OFFSET;
        }

        // 사각형 색칠하기
        for (int i = 0; i < n; i++) { // n개의 색종이를 색칠
            // 색종이 하나씩 색칠
            for (int j = x[i]; j < x[i] + 8; j++) {
                for (int k = y[i]; k < y[i] + 8; k++) {
                    checked[j][k] = 1;
                }
            }

        }

        // 칠해진 넓이 구하기
        int area = 0;
        for (int i = 0; i <= MAX_R; i++) {
            for (int j = 0; j <= MAX_R; j++) {
                if (checked[i][j] == 1) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int OFFSET = 100;
    public static final int MAX_R = 200;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] y1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];
    public static int[] y2 = new int[MAX_N];

    public static int[][] checked = new int[MAX_R + 1][MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = x1[i] + 8;
            y2[i] = y1[i] + 8;

            // OFFSET을 더해줍니다.
            x1[i] += OFFSET;
            y1[i] += OFFSET;
            x2[i] += OFFSET;
            y2[i] += OFFSET;
        }

        // 직사각형을 칠해줍니다.
        // 격자 단위로 진행하는 문제이므로
        // x2, y2에 등호가 들어가지 않음에 유의합니다.
        for (int i = 0; i < n; i++)
            for (int x = x1[i]; x < x2[i]; x++)
                for (int y = y1[i]; y < y2[i]; y++)
                    checked[x][y] = 1;

        // 직사각형 넓이의 총 합을 구합니다.
        int area = 0;
        for (int x = 0; x <= MAX_R; x++)
            for (int y = 0; y <= MAX_R; y++)
                if (checked[x][y] > 0)
                    area++;

        System.out.print(area);
    }
}