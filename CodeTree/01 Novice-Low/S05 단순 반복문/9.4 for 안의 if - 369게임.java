// try1 - fail : 입력 35 인경우
/*
1 2 0 4 5 0 7 8 0 10 11 0 0 14 0 0 17 0 0 20 0 22 0 0 25 0 0 28 0 0 0 0 0 0 0
1 2 0 4 5 0 7 8 0 10 11 0 0 14 0 0 17 0 0 20 0 22 0 0 25 0 0 28 0 0 31 32 0 34 35
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 10 == 3 || i % 10 == 6 || i % 10 == 9) { // 반례 : 31
                System.out.print(0 + " ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}

// try2 - success
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 10 == 3 || i % 10 == 6 || i % 10 == 9
                    || i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
                System.out.print(0 + " ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n;

        // 입력
        n = sc.nextInt();

        // 출력
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0)
                System.out.print("0 ");
            else if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9)
                System.out.print("0 ");
            else if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9)
                System.out.print("0 ");
            else
                System.out.print(i + " ");
        }
    }
}