import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 선언
        int[] arr = new int[100];
        int[] countArr = new int[11];

        // 입력
        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] == 0) {
                break;
            }
            if (arr[i] < 10) {
                continue;
            }

            countArr[arr[i] / 10]++;
        }

        // 출력
        for (int i = 10; i >= 1; i--) {
            System.out.printf("%d - %d\n", i * 10, countArr[i]);
        }
    }
}