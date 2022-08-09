import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100]; // 최대 100개
        int cnt = 0; // 채워진 원소의 개수

        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] == 0) {
                break;
            }

            cnt++;
        }

        for (int i = 0; i < cnt; i++) {
            if (arr[i] % 2 == 1) {
                System.out.print(arr[i] + 3 + " ");
            } else {
                System.out.print(arr[i] / 2 + " ");
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 선언
        int[] arr = new int[100];
        int[] newArr = new int[100];
        int zeroPoint = 0;

        // 입력받은 정수로부터 출력할 값을 새로운 배열에 저장하고, 0이 나오면 for문을 탈출
        for(int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] == 0) {
                zeroPoint = i;
                break;
            }
            if(arr[i] % 2 == 0)
                newArr[i] = arr[i] / 2;
            else
                newArr[i] = arr[i] + 3;
        }

        // 0이 나오기 전까지의 배열의 인덱스에 저장된 값을 출력
        for(int i = 0; i < zeroPoint; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}