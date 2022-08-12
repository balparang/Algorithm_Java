import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 최솟값 구하기
        int minval = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minval) {
                minval = arr[i];
            }
        }

        // 최솟값에 해당하는 원소의 개수 구하기
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == minval) {
                cnt++;
            }
        }

        // 최솟값과 그에 해당하는 원소의 개수 출력
        System.out.printf("%d %d", minval, cnt);
    }
}

// 해설
##include <stdio.h>

        int main() {
        // 변수 선언
        int A[100], n, min, cnt;

        // 입력:
        scanf("%d", &n);
        for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);

        // 초기값을 적습니다. 최소가 될 첫 번째 후보입니다.
        min = A[0];
        cnt = 1; // Case 1

        // 나머지 원소들을 보며 답을 갱신합니다.
        for (int i = 1; i < n; i++){
        // Case 1
        if (min > A[i]){ // 지금까지 나왔던 값들 보다 더 작은 값이라면
        min = A[i];  // 최초의 최솟값이 되므로 그 값을 갱신하고
        cnt = 1;     // Count를 1로 초기화합니다.
        }
        // Case 2
        else if (min == A[i]){ // 지금까지의 최소와 같다면
        cnt++;             // Count를 1 증가해줍니다.
        }
        }

        // 출력:
        printf("%d %d", min, cnt);

        return 0;
        }