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

        // 차이의 최솟값 구하기
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(arr[j] - arr[i]);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
        }

        System.out.println(minDiff);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언:
        int n;
        int[] A = new int[10];

        // 입력:
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        // 숫자들이 오름차순으로 주어지기 때문에,
        // 두 숫자의 차의 최솟값은 반드시 인접한 두 숫자의 차 중에 최솟값이 있습니다.
        // 초기값을 적습니다. 최소가 될 첫 번째 후보입니다.
        int minVal = A[1] - A[0];

        // 나머지 원소들을 보며 최솟값을 갱신합니다.
        for (int i = 2; i < n; i++) {
            if (minVal > A[i] - A[i - 1]) { // 지금까지 나왔던 값들 보다 더 작은 값이라면
                minVal = A[i] - A[i - 1];  // 최솟값이 되므로 그 값을 갱신합니다.
            }
        }

        // 출력
        System.out.print(minVal);
    }
}