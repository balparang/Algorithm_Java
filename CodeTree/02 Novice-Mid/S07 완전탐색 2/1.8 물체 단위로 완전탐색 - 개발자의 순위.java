import java.util.Scanner;

public class Main {
    static final int MAX_K = 10;
    static final int MAX_N = 20;

    static int[][] records = new int[MAX_K + 1][MAX_N + 1];
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        k = sc.nextInt();
        n = sc.nextInt();

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                records[i][j] = sc.nextInt();
            }
        }

        // (i, j) 를 정하고 모순 발생시 제외
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

//                System.out.printf("(i, j) : (%d, %d)\n", i, j);

                boolean possible = true; // (i, j) 쌍의 유효성

                // 게임 기록을 보면서 모순이 발생하는지 확인
                for (int game = 1; game <= k; game++) {
                    int rankI = 0, rankJ = 0;

                    for (int l = 1; l <= n; l++) {
                        if (records[game][l] == i) rankI = l; // i의 순위
                        if (records[game][l] == j) rankJ = l; // i의 순위
                    }

//                    System.out.printf("rankI, rankJ = %d, %d\n", rankI, rankJ);

                    // i가 j보다 뒷순위인 경우 모순
                    if (rankI > rankJ) {
                        possible = false;
                        break;
                    }
                }

                if (possible) ans++;
            }
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_K = 10;
    public static final int MAX_N = 20;

    public static int k, n;
    public static int[][] arr = new int[MAX_K][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        k = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < k; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int ans = 0;

        // 모든 쌍에 대해서 불변의 순위인 쌍을 찾습니다.
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                // i번 개발자가 j번 개발자보다 항상 높은 순위인지 여부를 확인합니다.

                // i와 j가 같을 경우 넘어갑니다.
                if (i == j)
                    continue;

                // correct : i번 개발자가 j번 개발자보다 항상 높은 순위일때 true
                boolean correct = true;

                // k번의 모든 경기에 대해서 두 개발자의 위치를 찾고,
                // 하나라도 i번 개발자가 더 뒤에 있으면 correct를 false로 바꿉니다.
                for (int x = 0; x < k; x++) {
                    int indexI = 0, indexJ = 0;

                    for (int y = 0; y < n; y++) {
                        if (arr[x][y] == i)
                            indexI = y;
                        if (arr[x][y] == j)
                            indexJ = y;
                    }

                    if (indexI > indexJ)
                        correct = false;
                }

                if (correct)
                    ans++;
            }

        System.out.print(ans);
    }
}