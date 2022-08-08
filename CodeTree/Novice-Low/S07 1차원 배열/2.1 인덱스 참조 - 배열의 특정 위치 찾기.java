import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        int evenSum = 0;
        for (int i = 1; i < 10; i += 2) {
            evenSum += arr[i];
        }

        int multipleSum = 0;
        int multipleCount = 0;
        for (int i = 2; i < 10; i += 3) {
            multipleSum += arr[i];
            multipleCount++;
        }

        // 출력
        System.out.print(evenSum + " ");
        System.out.printf("%.1f", (double) multipleSum / multipleCount);

    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int[] arr = new int[10];
        int sum2 = 0;
        int sum3 = 0;
        int cnt = 0;

        // 10개의 정수를 배열에 입력받아 저장합니다.
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // 짝수 번째 인덱스에 들어있는 수들의 합과 3의 배수 번째 인덱스에 들어있는 수들의 평균을 구합니다.
        for (int i = 0; i < 10; i++) {
            if ((i + 1) % 2 == 0)
                sum2 += arr[i];
            if ((i + 1) % 3 == 0) {
                sum3 += arr[i];
                cnt++;
            }
        }

        // 3의 배수 번째 인덱스에 들어있는 수들의 평균 구하기
        double avg3 = (double) sum3 / cnt;

        // 출력
        System.out.printf("%d %.1f", sum2, avg3);
    }
}