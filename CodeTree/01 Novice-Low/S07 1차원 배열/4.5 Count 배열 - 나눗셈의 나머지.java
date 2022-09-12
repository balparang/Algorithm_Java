import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] countArr = new int[b];

        while (true) {
            int quotient = a / b;
            int remainder = a % b;
            countArr[remainder]++;

            if (quotient < 1) {
                break;
            }

            a = quotient;
            System.out.println(Arrays.toString(countArr));
        }

        // 출력
        int sum = 0;
        for (int i = 0; i < b; i++) {
            if (countArr[i] != 0) {
                sum += Math.pow(countArr[i], countArr[i]);
                System.out.println("sum: " + sum);
            }
        }

        System.out.println(sum);
    }
}

// try2 - pass
import java.util.Scanner;
        import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] countArr = new int[b];

        while (true) {
            int quotient = a / b;
            int remainder = a % b;
            countArr[remainder]++;

            if (quotient <= 1) {
                break;
            }

            a = quotient;
        }

        // 출력
        int sum = 0;
        for (int i = 0; i < b; i++) {
            if (countArr[i] != 0) {
                sum += Math.pow(countArr[i], 2); // 문제를 잘못 읽었음.
            }
        }

        System.out.println(sum);
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 입력받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] countArr = new int[10]; // 나머지는 0부터 9까지 나올 수 있다.
        int ans = 0;

        // a가 1 이하가 될 때 까지 나누면서 나머지를 count배열에 저장하기
        while (a > 1) {
            countArr[a % b]++;
            a /= b;
        }

        // 나머지가 나온 횟수를 구해 정답 구하기
        for (int i = 0; i < b; i++) {
            ans += countArr[i] * countArr[i];
        }

        // 출력
        System.out.print(ans);
    }
}