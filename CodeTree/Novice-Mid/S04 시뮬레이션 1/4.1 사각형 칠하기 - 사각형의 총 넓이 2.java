import java.util.Scanner;

public class Main {
    static final int OFFSET = 100;
    static final int MAX_X = 200;
    static final int MAX_Y = 200;
    static final int MAX_N = 10;

    static int n;
    static int[] x1 = new int[MAX_N + 1];
    static int[] y1 = new int[MAX_N + 1];
    static int[] x2 = new int[MAX_N + 1];
    static int[] y2 = new int[MAX_N + 1];

    static int[][] coordSys = new int[MAX_X + 1][MAX_Y + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();

            // OFFSET
            x1[i] += OFFSET;
            y1[i] += OFFSET;
            x2[i] += OFFSET;
            y2[i] += OFFSET;
        }

        // 사각형 칠하기
        for (int i = 1; i <= n; i++) { // n개 사각형 칠하기
            // i 번째 사각형 칠하기
            for (int j = x1[i]; j < x2[i]; j++) {
                for (int k = y1[i]; k < y2[i]; k++) {
                    coordSys[j][k] = 1;
                }
            }
        }

        // 넓이 구하기
        int space = 0;
        for (int i = 0; i <= MAX_X; i++) {
            for (int j = 0; j <= MAX_Y; j++) {
                if (coordSys[i][j] == 1) {
                    space++;
                }
            }
        }

        System.out.println(space);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10;
    public static final int MAX_R = 200;
    public static final int OFFSET = 100;

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
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();

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
                    checked[x][y]++;

        // 직사각형 넓이의 총 합을 구합니다.
        int area = 0;
        for (int x = 0; x <= MAX_R; x++)
            for (int y = 0; y <= MAX_R; y++)
                if (checked[x][y] > 0)
                    area++;

        // 출력
        System.out.print(area);
    }
}