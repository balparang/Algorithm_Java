import java.util.Scanner;

public class Main {
    static final int MAX_N = 1000;

    static int n, k;
    static int[] prime = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();

        prime[0] = prime[1] = 0;

        // 2부터 n까지 모든 정수 적기
        for (int i = 2; i <= n; i++) {
            prime[i] = i;
        }

        // K번째 지워진 수 찾기
        int ans = Eratos();

        // 출력
        System.out.println(ans);
    }

    static int Eratos() {
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (prime[i] == 0) continue;

            // P를 지우고, 지우지 않은 P의 배수 오름차순으로 삭제
            prime[i] = 0; // P
            cnt++;

            if (cnt == k) {
                return i;
            }

            // 아직 지우지 않은 P의 배수 지우기
            for (int j = 2 * i; j <= n; j += i) {
                if (prime[j] == 0) continue;

                prime[j] = 0;
                cnt++;

                if (cnt == k) {
                    return j;
                }
            }
        }

        return 0;
    }
}