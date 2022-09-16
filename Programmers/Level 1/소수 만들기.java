// Try 1 - fail : runtime error (69.1)
// 세 수의 합은 최대 3000이 될 수 있으므로 index out of range 에러가 발생한 듯하다.

import java.util.Arrays;

class Solution {
    static int MAX_N = 1000;

    static int[] prime = new int[MAX_N + 1];

    public int solution(int[] nums) {
        int cnt = 0;
        int len = nums.length;

        // 에라토스테네스의 체 기록
        Eratos();

        // (i, j, k) 합이 소수인지 확인
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (prime[sum] != 0) cnt++;
                }
            }
        }

        return cnt;
    }

    static void Eratos() {
        // 소수가 아니라면 0
        prime[0] = prime[1] = 0;

        // 2부터 n까지 기록
        for (int i = 2; i <= MAX_N; i++) {
            prime[i] = i;
        }

        for (int i = 2; i <= MAX_N; i++) {
            if (prime[i] == 0) continue;

            // i의 배수들은 소수가 아니므로 0으로 체크
            for (int j = 2 * i; j <= MAX_N; j += i) {
                prime[j] = 0;
            }
        }
    }
}

// Try 2 - fail(73.1) : 틀린 결과
// Eratos()를 수정해주지 않았다.
class Solution {
    static int MAX_N = 1000;

    static int[] prime = new int[MAX_N * 3 + 1];

    public int solution(int[] nums) {
        int cnt = 0;
        int len = nums.length;

        // 에라토스테네스의 체 기록
        Eratos();

        // (i, j, k) 합이 소수인지 확인
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (prime[sum] != 0) cnt++;
                }
            }
        }

        return cnt;
    }

    static void Eratos() {
        // 소수가 아니라면 0
        prime[0] = prime[1] = 0;

        // 2부터 n까지 기록
        for (int i = 2; i <= MAX_N; i++) {
            prime[i] = i;
        }

        for (int i = 2; i <= MAX_N; i++) {
            if (prime[i] == 0) continue;

            // i의 배수들은 소수가 아니므로 0으로 체크
            for (int j = 2 * i; j <= MAX_N; j += i) {
                prime[j] = 0;
            }
        }
    }
}

// Try 3 - pass
class Solution {
    static int MAX_N = 1000 * 3;

    static int[] prime = new int[MAX_N + 1];

    public int solution(int[] nums) {
        int cnt = 0;
        int len = nums.length;

        // 에라토스테네스의 체 기록
        Eratos();

        // (i, j, k) 합이 소수인지 확인
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (prime[sum] != 0) cnt++;
                }
            }
        }

        return cnt;
    }

    static void Eratos() {
        // 소수가 아니라면 0
        prime[0] = prime[1] = 0;

        // 2부터 n까지 기록
        for (int i = 2; i <= MAX_N; i++) {
            prime[i] = i;
        }

        for (int i = 2; i <= MAX_N; i++) {
            if (prime[i] == 0) continue;

            // i의 배수들은 소수가 아니므로 0으로 체크
            for (int j = 2 * i; j <= MAX_N; j += i) {
                prime[j] = 0;
            }
        }
    }
}