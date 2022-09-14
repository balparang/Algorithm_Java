import java.util.Scanner;

public class Main {
    static final int MAX_N = 10;
    static final int MAX_AB = 100;

    static int n;
    static int[] x1 = new int[MAX_N];
    static int[] x2 = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        // 세 개의 선분을 정하여 완전탐색
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    int[] segments = new int[MAX_AB + 1];
                    boolean possible = true;

                    // n - 3 개의 선분들이 겹치는 지 확인
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue;

                        // n - 3개의 선분들을 기록
                        for (int x = x1[l]; x <= x2[l]; x++) {
                            segments[x]++;
                        }
                    }

                    // 겹침 발생하면 현재 케이스는 가능성 없다.
                    for (int l = 0; l <= MAX_AB; l++) {
                        if (segments[l] > 1) {
                            possible = false;
                            break;
                        }
                    }

                    // 겹치지 않는다면 가능성 + 1
                    if (possible) {
                        ans++;
                    }
                }
            }
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_A = 100;
    public static final int MAX_N = 10;

    public static int n;
    public static int[] l = new int[MAX_N];
    public static int[] r = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        // 3개의 선분을 모두 골라보면서
        // 모두 겹쳐지지 않도록 하는 가짓수를 구합니다.
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    // i, j, k번 선분을 제외했을 때
                    // 모든 선분이 겹치지 않으면 정답을 1 추가합니다.

                    // overlap : 모든 선분이 겹치지 않으면 false
                    boolean overlap = false;
                    int[] arr = new int[MAX_A + 1];

                    for (int x = 0; x < n; x++) {
                        // 제외한 3개의 선분이면 넘어갑니다.
                        if (x == i || x == j || x == k)
                            continue;

                        for (int y = l[x]; y <= r[x]; y++)
                            arr[y]++;
                    }

                    for (int x = 0; x <= MAX_A; x++)
                        if (arr[x] > 1)
                            overlap = true;

                    if (overlap == false)
                        ans++;
                }

        System.out.print(ans);
    }
}