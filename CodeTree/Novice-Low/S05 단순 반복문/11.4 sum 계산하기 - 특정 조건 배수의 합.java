// try1 - fail : 반례 50 13
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (i % 5 == 0)
                sum += i;
        }

        System.out.print(sum);
    }
}

// try2 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;

        // a, b 크기 판별
        int max = a > b ? a : b;
        int min = a < b ? a : b;

        for (int i = min; i <= max; i++) {
            if (i % 5 == 0) {
                sum += i;
            }
        }

        System.out.print(sum);
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        int sum = 0;

        // Case 1. b가 더 큰 경우
        if(a <= b) {
            for(int i = a; i <= b; i++) {
                if(i % 5 == 0)
                    sum += i;
            }
        }
        // Case 2. a가 더 큰 경우
        else {
            for(int i = b; i <= a; i++) {
                if(i % 5 == 0)
                    sum += i;
            }
        }

        // 출력
        System.out.println(sum);
    }
}