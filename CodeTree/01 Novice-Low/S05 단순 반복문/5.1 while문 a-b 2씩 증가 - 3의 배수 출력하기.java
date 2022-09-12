import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // 1 to n, 3의 배수 모두 출력
        int i = 1;
        while (i <= n) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
    }
}

// 선생님 답안 (중첩 안 쓰고 풀이)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n;
        int i = 3;

        // 입력
        n = sc.nextInt();

        // 출력
        while(i <= n) {
            System.out.print(i + " ");
            i += 3;
        }
    }
}