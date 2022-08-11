import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 원소 개수
        int q = sc.nextInt(); // 질의 개수
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 질의 처리
        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();

            // case 1 : a 번째 원소 출력, 첫 번째 부터 출력
            if (queryType == 1) {
                int a = sc.nextInt();
                System.out.println(arr[a - 1]);
            }

            // case 2 : 숫자 a 있는지 판단
            else if (queryType == 2) {
                int idx = -1; // 숫자 a와 일치하는 인덱스
                int a = sc.nextInt();

                // 배열에서 숫자 a와 같은 것이 있는지 탐색
                for (int j = 0; j < n; j++) {
                    if (arr[j] == a) {
                        idx = j;
                        break; // 숫자 a와 두 개 이상 일치하면 더 작은 원소 인덱스 저장
                    }
                }

                if (idx == -1) {
                    System.out.println(0);
                } else {
                    System.out.println(idx + 1); // 몇 번째 원소인지 출력
                }
            }

            // case 3 : a b, a 번째 원소부터 b번째 원소까지 숫서 대로 공백 두고 출력
            else {
                int a = sc.nextInt();
                int b = sc.nextInt();

                for (int j = a; j <= b; j++) {
                    System.out.print(arr[j - 1] + " ");
                }

                System.out.println();
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 n과 q을 입력받습니다.
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[100];

        // arr를 입력받습니다.
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // q개의 질의를 수행합니다.
        for (int i = 0; i < q; i++) {
            // 몇번째 질의인지 확인합니다.
            int qType = sc.nextInt();

            if (qType == 1) {
                // a를 입력받은 후, a번째 원소를 출력합니다.
                int a = sc.nextInt();

                // a번째 원소를 출력합니다.
                System.out.println(arr[a - 1]);
            } else if (qType == 2) {
                // a를 입력받은 후, 배열에 숫자 a가 있다면 가장 index가 작은 원소가 몇번째인지 출력합니다. 없다면 0을 출력합니다.
                int a = sc.nextInt();

                // 가장 index가 작은 원소에 있는 숫자 a를 찾습니다.
                int idx = -1;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == a) {
                        idx = j;
                        break;
                    }
                }

                // 숫자 a가 몇번째인지 출력합니다. 없다면 0을 출력합니다.
                System.out.println(idx + 1);
            } else {
                // a, b를 입력받은 후, a번째 원소부터 b번째 원소까지 공백을 사이에 두고 출력합니다.
                int a = sc.nextInt();
                int b = sc.nextInt();

                // a번째 원소부터 b번째 원소까지 공백을 사이에 두고 출력합니다.
                for (int j = a - 1; j < b; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
    }
}