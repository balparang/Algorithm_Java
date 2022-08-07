// try1 - fail : 'Z' 출력 안 됨.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int alphabet = (int) 'A';  // 65

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) alphabet);
                alphabet++;

                if ((char) alphabet == 'Z') {
                    alphabet = (int) 'A';
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

        int alphabet = (int) 'A';  // 65

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) alphabet);
                alphabet++;

                if (alphabet > (int) 'Z') {
                    alphabet = (int) 'A';
                }
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
        int n = sc.nextInt();
        char cnt = 'A';

        // 알파벳을 삼각형 모양으로 출력합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(cnt);
                cnt++;
                if (cnt > 'Z')
                    cnt = 'A';
            }
            System.out.println();
        }
    }
}