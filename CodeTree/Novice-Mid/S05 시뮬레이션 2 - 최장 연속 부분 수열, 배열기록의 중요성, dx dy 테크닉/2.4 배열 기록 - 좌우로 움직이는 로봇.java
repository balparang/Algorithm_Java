import java.util.Scanner;

public class Main {
    static final int MAX_T = 1000000;

    static int n, m;
    static int[] posA = new int[MAX_T + 1];
    static int[] posB = new int[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // A 위치 기록
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int d = sc.next().charAt(0);

            while (t-- > 0) {
                if (d == 'R') {
                    posA[timeA] = posA[timeA - 1] + 1;
                } else {
                    posA[timeA] = posA[timeA - 1] - 1;
                }
                timeA++;
            }
        }

        // B 위치 기록
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int d = sc.next().charAt(0);

            while (t-- > 0) {
                if (d == 'R') {
                    posB[timeB] = posB[timeB - 1] + 1;
                } else {
                    posB[timeB] = posB[timeB - 1] - 1;
                }
                timeB++;
            }
        }

        // 이동이 먼저 멈춘 로봇의 위치를 나중에 멈추는 로봇의 '초' 까지 유지 [3, 0, 0] -> [3, 3, 3]
        // A 가 먼저 멈춘 경우
        if (timeA < timeB) {
            for (int i = timeA; i < timeB; i++) {
                posA[i] = posA[timeA - 1];
            }
        }
        // B 가 먼저 멈춘 경우
        else if (timeA > timeB) {
            for (int i = timeB; i < timeA; i++) {
                posB[i] = posB[timeB - 1];
            }
        }

        // 로봇 위치가 같은지 확인
        int ans = 0;
        int timeLimit = Math.max(timeA, timeB);
        for (int i = 1; i < timeLimit; i++) {
            // 이전 초에서는 위치가 달라야함
            if (posA[i] == posB[i] && posA[i - 1] != posB[i - 1]) {
                ans++;
            }
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
