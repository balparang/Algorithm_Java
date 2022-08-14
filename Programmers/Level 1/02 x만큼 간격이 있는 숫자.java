// Try 1 - fail(테스트케이스 13, 14번 fail) : int, long 타입의 범위를 고려하지 않음.
/*
    - x 는 최대 1000만, n은 1000, 즉 연산의 결과로 1000만 * 1000 = 1000억 이 나올 수 있다.
    - int 의 범위는 약 -21억 ~ 21억, 즉 int 형으로 배열 생성 시 정확한 답을 못 담을 수 있다.
    - long의 범위는 조 단위가 넘는다.
*/
class Solution {
    public int[] solution(int x, int n) {
        int[] arr = new int[n];
        int elem = x;

        for (int i = 0; i < n; i++) {
            arr[i] = elem;
            elem += x;
        }

        return arr;
    }
}

// Try 2 - pass
class Solution {
    public long[] solution(int x, int n) {
        long[] arr = new long[n];
        long elem = (long) x;

        for (int i = 0; i < n; i++) {
            arr[i] = elem;
            elem += x;
        }

        return arr;
    }
}

// 다른 사람의 풀이 - 별도의 원소를 저장하기 위한 변수를 선언한게 아니라 배열만을 이용하여 풀이
import java.util.*;
class Solution {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;

    }
}
