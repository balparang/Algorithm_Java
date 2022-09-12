import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int L = str.length();

        // L회 반복하며 우측으로 한 칸씩 shift
        System.out.println(str);

        for (int i = 0; i < L; i++) {
            str = str.substring(L - 1) + str.substring(0, L - 1);
            System.out.println(str);
        }
    }
}

// 해설(동일)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // 문자열을 출력합니다.
        System.out.println(str);

        // 문자열을 오른쪽으로 한 칸 쉬프트하고 문자열을 출력합니다. 이를 len회 반복합니다.
        for (int i = 0; i < len; i++) {
            // 문자열을 오른쪽으로 한 칸 쉬프트합니다.
            str = str.substring(len - 1) + str.substring(0, len - 1);

            // 문자열을 출력합니다.
            System.out.println(str);
        }
    }
}