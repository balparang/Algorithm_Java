import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] A, B; // 이동 명령
    static int[] Amove, Bmove; // 움직인 결과

    static void move(int[] order, int[] move) {
        int idx = 1;

        for (int k : order) {
            // Case 1 : R
            if (k > 0) {
                for (int j = 0; j < k; j++) {
                    move[idx] = move[idx - 1] + 1;
                    idx++;
                }
            }
            // Case 2 : L
            else {
                for (int j = 0; j < -1 * k; j++) {
                    move[idx] = move[idx - 1] - 1;
                    idx++;
                }
            }
        }
    }

    static int check() {
        for (int i = 1; i < Amove.length; i++) {
            if (Amove[i] == Bmove[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N];
        B = new int[M];

        int totalTime = 0;
        for (int i = 0; i < N; i++) {
            char direction = sc.next().charAt(0);

            if (direction == 'R') {
                A[i] = sc.nextInt();
            } else {
                A[i] = sc.nextInt() * (-1);
            }
            totalTime += Math.abs(A[i]);
        }
        for (int i = 0; i < M; i++) {
            char direction = sc.next().charAt(0);

            if (direction == 'R') {
                B[i] = sc.nextInt();
            } else {
                B[i] = sc.nextInt() * (-1);
            }
        }

        Amove = new int[totalTime + 1];
        Bmove = new int[totalTime + 1];

        // 이동 명령에 따라 이동하고, 움직인 결과에 초단위로 기록
        move(A, Amove);
        move(B, Bmove);

        // A, B가 만나는지 확인
        System.out.println(check());
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_T = 1000000;

    public static int n, m;
    public static int[] posA = new int[MAX_T + 1];
    public static int[] posB = new int[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // A가 매 초마다 서있는 위치를 기록
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while (t-- > 0) {
                if (d == 'R')
                    posA[timeA] = posA[timeA - 1] + 1;
                else
                    posA[timeA] = posA[timeA - 1] - 1;

                timeA++;
            }
        }

        // B가 매 초마다 서있는 위치를 기록
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while (t-- > 0) {
                if (d == 'R')
                    posB[timeB] = posB[timeB - 1] + 1;
                else
                    posB[timeB] = posB[timeB - 1] - 1;

                timeB++;
            }
        }

        // 최초로 만나는 시간을 구합니다.
        int ans = -1;
        for (int i = 1; i < timeA; i++) {
            if (posA[i] == posB[i]) {
                ans = i;
                break;
            }
        }

        // 출력
        System.out.print(ans);
    }
}