import java.util.Scanner;

public class Main {
    static final int MAX_N = 1003;
    static int n;
    static int[] rooms = new int[MAX_N + 1]; // room[1] : 1번방에 들어가야하는 인원 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            rooms[i] = sc.nextInt();
        }

        // 1~N 번 방을 시작점으로 하면서, 최소가 되는 거리의 합을 구하기
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int dist = getDistSum(i); // i를 시작 방으로 설정
            ans = Math.min(ans, dist);
        }

        // 출력
        System.out.println(ans);
    }

    private static int getDistSum(int startRoom) {
        int curr = startRoom;
        int dist = 0; // 시작 방과의 거리
        int distSum = 0;

        for (int i = 1; i <= n; i++) {
            distSum += rooms[curr++] * dist++;
            if (curr == n + 1) {
                curr = 1;
            }
        }

        return distSum;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 1003;

    public static int n;
    public static int[] a = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        // 각 i번째 방으로 모였을 때의 합을 구해줍니다.
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int sumDist = 0;
            for (int j = 0; j < n; j++) {
                int dist = (j + n - i) % n; // j - i + n 으로 해석하는게 더 직관적이라 생각한다.
                sumDist += dist * a[j];
            }

            // 가능한 거리의 합 중 최솟값을 구해줍니다.
            ans = Math.min(ans, sumDist);
        }

        System.out.print(ans);
    }
}