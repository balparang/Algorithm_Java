import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        double avg = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 250) {
                break;
            }

            sum += arr[i];
            cnt++;
        }

        avg = (double) sum / cnt;

        System.out.printf("%d %.1f", sum, avg);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int[] arr = new int[10];
        int sum = 0;
        int cnt = 0;

        // 10개의 정수를 입력받습니다.
        for(int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // 10개의 정수 중 250 이상의 수가 나올 때 까지의 수의 합계와 개수를 구합니다.
        for(int i = 0; i < 10; i++) {
            if(arr[i] >= 250)
                break;
            sum += arr[i];
            cnt++;
        }

        // 평균을 구합니다.
        double avg = (double)sum / cnt;

        // 출력
        System.out.printf("%d %.1f", sum, avg);
    }
}