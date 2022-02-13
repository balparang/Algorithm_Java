/*
 * 220214 월
 * cnt : 0을 1로 바꾼 횟수 <= k
 * rt는 0을 만나면 1로 바꾸고(실제 배열의 값은 안 바뀌지만 논리적으로 바뀌었다고 생각), lt는 rt가 1로 바꿔놓은 것을 다시 0으로 바꿈
 * rt - lt + 1 : 연속된 1의 수열의 길이
 */

import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++; // arr[rt]가 0이라면 1로 바꿔줌 (1로 바꿨다고 개념적으로 생각)
            while (cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}