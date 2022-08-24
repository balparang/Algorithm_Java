import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 배열에 원소 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 짝수만 2로 나누기
        divideIfEven(arr);

        // 출력
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void divideIfEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] /= 2;
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 50;

    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void modify(int[] arr) {
        for (int i = 0; i < n; i++)
            if (arr[i] % 2 == 0)
                arr[i] /= 2;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        modify(arr);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}