// try1 - fail : 공백을 출력할 때도 cnt를 증가시켰음.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char cnt = 'A';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    System.out.print(cnt + " ");
                } else {
                    System.out.print("  ");
                }

                cnt++;
                if (cnt > 'Z') {
                    cnt = 'A';
                }
            }

            System.out.println();
        }
    }
}

// try2 - pass
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char cnt = 'A';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    System.out.print(cnt + " ");
                    cnt++;

                    if (cnt > 'Z') {
                        cnt = 'A';
                    }
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}

// 선생님 답안 - j를 구간을 나눠서 출력
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();
        char cnt = 'A';

        // 알파벳을 역삼각형 모양으로 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("  ");
            for (int j = 0; j < n - i; j++) {
                System.out.print(cnt + " ");
                cnt++;
                if (cnt > 'Z')
                    cnt = 'A';
            }
            System.out.println();
        }
    }
}