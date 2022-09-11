import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;

    static int n;
    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];

    // 선택한 세 점이 x,y 축 각각에 평행한지 검사
    static boolean satisfied(int c1, int c2, int c3) {
        boolean isParallelToX = false;
        boolean isParallelToY = false;

        // 세 점 중 두 점의 y좌표가 같으면 x축 평행
        if (y[c1] == y[c2] || y[c2] == y[c3] || y[c3] == y[c1]) {
            isParallelToX = true;
        }
        // 세 점 중 두 점의 x좌표가 같으면 y축 평행
        if (x[c1] == x[c2] || x[c2] == x[c3] || x[c3] == x[c1]) {
            isParallelToY = true;
        }

        return isParallelToX && isParallelToY;
    }


    // 삼각형 넓이의 2배한 값을 리턴
    static int getArea(int c1, int c2, int c3) {
        return Math.abs((x[c1] * y[c2] + x[c2] * y[c3] + x[c3] * y[c1])
                - (x[c2] * y[c1] + x[c3] * y[c2] + x[c1] * y[c3]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 세 개의 점을 완전탐색하여 정하기
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 선택한 세 점이 조건을 만족하면, 최대넓이 갱신
                    if (satisfied(i, j, k)) {
                        maxArea = Math.max(maxArea, getArea(i, j, k));
                    }
                }
            }
        }

        // 출력
        System.out.println(maxArea);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];

    // 삼각형의 넓이에 2를 곱한 값을 반환합니다.
    public static int area(int i, int j, int k) {
        return Math.abs((x[i] * y[j] + x[j] * y[k] + x[k] * y[i]) -
                (x[j] * y[i] + x[k] * y[j] + x[i] * y[k]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 3개의 점을 모두 골라보면서
        // 조건을 만족하는 경우 중
        // 최대 넓이를 계산합니다.
        int maxArea = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    // x값이 같은 쌍이 있으며, y값 역시 같은 쌍이 있는 경우에만
                    // 최대 넓이를 계산합니다.
                    if ((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) &&
                            (y[i] == y[j] || y[i] == y[k] || y[j] == y[k]))
                        maxArea = Math.max(maxArea, area(i, j, k));

        System.out.println(maxArea);
    }
}