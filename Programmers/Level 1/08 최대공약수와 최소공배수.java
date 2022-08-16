// Try 1 - pass : 두 수를 1부터 두 수 중 작은 수 까지 나누며 최대공약수 구하는 방식
class Solution {
    public long[] solution(int n, int m) {
        // 변수 선언
        long[] answer = new long[2];
        int GCF = 1;
        long LCM = m;
        int smaller, bigger;

        if (n < m) {
            smaller = n;
            bigger = m;
        } else {
            smaller = m;
            bigger = n;
        }

        // 최대공약수 구하기
        for (int i = 1; i <= smaller; i++) {
            if (smaller % i == 0 && bigger % i == 0) {
                GCF = i;
            }
        }

        // 최소공배수 구하기
        int quot1 = smaller / GCF;
        int quot2 = bigger / GCF;
        LCM = (long) GCF * quot1 * quot2;

        // 리턴
        answer[0] = GCF;
        answer[1] = LCM;
        return answer;
    }
}

// Try 2 - pass : 유클리드 호제법(재귀)
class Solution {
    public long[] solution(int n, int m) {
        // 변수 선언
        long[] answer = new long[2];
        int GCD;
        int LCM;
        int A, B;

        if (n > m) {
            A = n;
            B = m;
        } else {
            A = m;
            B = n;
        }

        GCD = gcd(A, B);
        LCM = A * B / GCD;

        answer[0] = GCD;
        answer[1] = LCM;

        return answer;
    }

    // 유클리드 호제법
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
