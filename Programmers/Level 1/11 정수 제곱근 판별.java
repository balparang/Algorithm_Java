// Try 1 - fail: 시간 초과
class Solution {
    public long solution(long n) {
        long answer = 0;

        for (int i = 0; i < n; i++) {
            if (i * i == n) {
                answer = (i + 1) * (i + 1);
                break;
            }
        }

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }
}

// Try 2 - pass
class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            answer = (long) Math.pow(sqrt + 1, 2);
        } else {
            answer = -1;
        }

        return answer;
    }
}

// 다른 사람의 풀이
class Solution {
    public long solution(long n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
    }
}