import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        int len = A.length();
        int cnt = 0;

        while (true) {
            A = A.substring(len - 1) + A.substring(0, len - 1);
            cnt++;

            if (A.equals(B)) {
                System.out.println(cnt);
                break;
            }

            if (cnt == len) {
                System.out.println(-1);
                break;
            }
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String a = sc.next();
        String b = sc.next();

        int len = a.length();
        int cnt = 0;

        // 문자열 a를 우측으로 한 칸씩 밀어보면서 문자열 b와 같아지는지 확인합니다.
        for (int i = 0; i < len; i++) {
            // 문자열을 오른쪽으로 한 칸 쉬프트합니다.
            a = a.substring(len - 1, len) + a.substring(0, len - 1);

            cnt++;

            // 문자열이 같을 경우 민 횟수를 출력합니다.
            if (a.equals(b)) {
                System.out.println(cnt);
                break;
            }

            // 만약 불가능하다면 -1을 출력합니다.
            if (i == len - 1)
                System.out.println(-1);
        }
    }
}