import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        printRect(n);
    }

    public static void printRect(int n) {
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cnt++ + " ");

                if (cnt == 10) {
                    cnt = 1;
                }
            }
            System.out.println();
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    // n * n 크기의 사각형에 숫자를 출력하는 함수입니다.
    public static void printNum(int n) {
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cnt + " ");
                cnt++;
                if (cnt == 10)
                    cnt = 1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int rowNum = sc.nextInt();

        printNum(rowNum);

    }
}