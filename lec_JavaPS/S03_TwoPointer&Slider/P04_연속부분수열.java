// sum : [left] ~ [right]까지의 합
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < n; rt++) { // 1. rt증가하고
            sum += arr[rt]; // 2. 더하고
            if (sum == m) answer++; // 3. 확인(lt ~ rt의 합)
            while(sum >= m) {
                sum -= arr[lt++]; // 빼고 증가
                if(sum == m) answer++;
            }
        }

        return answer;
    }
}