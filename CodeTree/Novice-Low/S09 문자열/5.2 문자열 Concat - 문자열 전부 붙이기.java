import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수선언
        int n = sc.nextInt();
        String[] strArr = new String[n];

        // 배열에 원소 입력
        for (int i = 0; i < n; i++) {
            strArr[i] = sc.next();
        }

        // 문자열 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        // 이어붙인 문자열 출력
        System.out.println(sb.toString());
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String[] str = new String[10];
        String strAll = "";

        // n을 입력받습니다.
        int n = sc.nextInt();

        // 문자열을 입력받습니다.
        for(int i = 0; i < n; i++)
            str[i] = sc.next();

        // 문자열을 전부 붙입니다.
        for(int i = 0; i < n; i++)
            strAll += str[i];

        // 합쳐진 문자열을 출력합니다.
        System.out.println(strAll);
    }
}
