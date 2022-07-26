/**
 * 220213 일
 * S3.04 연속부분수열 문제와 비슷함
 * 입력이 15인 경우
 * 15 / 2 = 7, 7+8은 15이므로 배열에 8까지만 담으면 됨 (2개 이상의 연속된 자연수의 합)
 */

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i + 1;
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}