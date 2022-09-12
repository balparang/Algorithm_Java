import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int oddSum = 0, evenSum = 0;

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) { // 홀수 번째
                oddSum += arr[i];
            } else { // 짝수 번째
                evenSum += arr[i];
            }
        }

        int answer = 0;
        if (oddSum > evenSum) {
            answer = oddSum - evenSum;
        } else {
            answer = evenSum - oddSum;
        }

        System.out.println(answer);
    }
}