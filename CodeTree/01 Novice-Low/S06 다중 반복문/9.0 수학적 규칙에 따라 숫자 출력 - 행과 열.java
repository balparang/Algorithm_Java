import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((i + 1) * (j + 1) + " ");
            }

            System.out.println();
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // n칸의 정사각형에 i * j를 출력합니다.
        for(int i = 1; i <= a; i++) {
            for(int j = 1; j <= b; j++) {
                System.out.print((i * j) + " ");
            }
            System.out.println();
        }
    }
}