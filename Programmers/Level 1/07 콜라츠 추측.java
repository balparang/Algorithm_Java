// Try 1 - fail(테스트 케이스 3번)
// 입력이 626331 인 경우 출력이 -1이 나와야 하는데, 488로 나오는 문제
// 원인 : 연산과정에서 int의 범위를 넘어서는 오버플로우 발생
class Solution {
    public int solution(int num) {
        int tmp = num;
        int count = 0;

        while (tmp != 1) {
            if (tmp % 2 == 0) {
                tmp /= 2;
            } else {
                tmp = tmp * 3 + 1;
            }
            count++;

            if (count > 500) {
                count = -1;
                break;
            }
        }

        return count;
    }
}

// Try 2 - pass : int -> long 타입 이용
class Solution {
    public int solution(int num) {
        long tmp = (long) num;
        int count = 0;

        while (true) {
            if (tmp == 1) {
                break;
            }

            if (tmp % 2 == 0) {
                tmp /= 2;
            } else {
                tmp = 3 * tmp + 1;
            }
            count++;

            if (count > 500) {
                count = -1;
                break;
            }
        }

        return count;
    }
}

// 다른 사람의 풀이 : while문 말고 for문을 이용
class Collatz {
    public int collatz(int num) {
        long n = (long) num;
        for (int i = 0; i < 500; i++) {
            if (n == 1) return i;
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
        }
        return -1;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Collatz c = new Collatz();
        int ex = 6;
        System.out.println(c.collatz(ex));
    }
}