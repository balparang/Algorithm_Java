import java.util.Scanner;

public class Main {
    static final int MAX_N = 100;
    static int[][] points = new int[MAX_N][2]; // [i][0] : i번째 x좌표

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        // 체크포인트를 하나씩 건너 뛰면서, 맨해튼 거리 계산
        int minDist = Integer.MAX_VALUE;

        // i번째 체크 포인트를 건너뛰기
        for (int i = 1; i <= n - 2; i++) {
            int lastX = points[0][0];
            int lastY = points[0][1];

            int totalDist = 0;

            for (int j = 1; j <= n - 1; j++) {
                // i번째 체크포인트는 건너뛰고 거리계산
                if (j == i) {
                    continue;
                }

                int currX = points[j][0];
                int currY = points[j][1];
                totalDist += getDistance(currX, currY, lastX, lastY);

                lastX = currX;
                lastY = currY;
            }

            minDist = Math.min(minDist, totalDist);
        }

        // 출력
        System.out.println(minDist);
    }

    private static int getDistance(int currX, int currY, int lastX, int lastY) {
        return Math.abs(currX - lastX) + Math.abs(currY - lastY);
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 각 i번째 체크포인트를 건너 뛰었을 때의 거리를 구해줍니다.
        int ans = INT_MAX;
        for (int i = 1; i < n - 1; i++) {
            // 거리를 구합니다.
            int dist = 0;
            int prevIdx = 0;
            for (int j = 1; j < n; j++) {
                if (j == i) continue;
                dist += Math.abs(x[prevIdx] - x[j]) + Math.abs(y[prevIdx] - y[j]);
                prevIdx = j;
            }

            // 가능한 거리 중 최솟값을 구해줍니다.
            ans = Math.min(ans, dist);
        }

        // 출력
        System.out.print(ans);
    }
}