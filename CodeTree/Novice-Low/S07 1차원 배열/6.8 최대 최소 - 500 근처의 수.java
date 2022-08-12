import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int[] arr = new int[10];

        // 배열 입력
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // 500미만 최댓값, 500초과 최솟값 탐색
        int max = Integer.MIN_VALUE; // 500미만 최댓값
        int min = Integer.MAX_VALUE; // 500미만 최솟값

        for (int i = 1; i < 10; i++) {
            if (arr[i] > max && arr[i] < 500) {
                max = arr[i];
            }

            if (arr[i] < min && arr[i] > 500) {
                min = arr[i];
            }
        }

        System.out.printf("%d %d", max, min);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열을 구현합니다.
        int[] arr = new int[10];

        // 10개의 정수를 입력받습니다.
        for (int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();

        // maxVal : 500 미만의 가장 큰 수, minVal : 500 초과의 가장 작은 수
        int maxVal = 1;
        int minVal = 1000;

        // 10개의 숫자들 중 500근처의 수들을 구합니다.
        for (int i = 0; i < 10; i++) {
            if (arr[i] < 500 && arr[i] > maxVal)
                maxVal = arr[i];

            if (arr[i] > 500 && arr[i] < minVal)
                minVal = arr[i];
        }

        // 구한 값을 출력합니다.
        System.out.print(maxVal + " " + minVal);
    }
}