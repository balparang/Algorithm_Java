import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수, 배열 선언
        int n = sc.nextInt();
        int[] arr = new int[n];
        int idx = -1;
        int cnt = 0;

        // 배열 입력, 원소가 2라면 cnt 1씩 증가
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 2) {
                cnt++;
            }

            if (cnt == 3) {
                idx = i;
                break;
            }
        }


        // 출력
        System.out.println(idx + 1);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 n과 배열을 입력받습니다.
        int n = sc.nextInt();
        int[] arr = new int[100];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 2가 나온 횟수를 카운트해 줍니다.
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 2)
                cnt++;

            // 2가 3번째로 등장할 때 그 위치를 출력합니다.
            if (cnt == 3) {
                System.out.print(i + 1);
                break;
            }
        }
    }
}