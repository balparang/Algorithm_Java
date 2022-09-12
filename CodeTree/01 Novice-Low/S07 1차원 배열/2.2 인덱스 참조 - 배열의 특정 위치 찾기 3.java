import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최대 정수 100개 입력
        int[] arr = new int[100];
        int cnt = 0; // 0이 아닌 원소의 개수

        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] == 0) {
                break;
            }

            cnt++;
        }

        // 처음으로 주어진 0에 대해 앞의 세 개의 수 합 계산
        int sum = 0;
        for (int i = cnt - 1; i >= cnt - 3; i--) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 (k : 0이 들어있는 인덱스의 번호)
        int[] arr = new int[100];
        int k = 0;

        // 0이 입력될 때까지 100개의 정수를 배열에 입력받아 저장합니다.
        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                k = i;
                break;
            }
        }

        // 출력
        System.out.print(arr[k - 3] + arr[k - 2] + arr[k - 1]);
    }
}