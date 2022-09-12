import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str1 = sc.next();
        String str2 = sc.next();

        // A + B 와 B + A가 같은 지 확인
        String str1ConcatStr2 = str1 + str2;
        String str2ConcatStr1 = str2 + str1;

        if (str1ConcatStr2.equals(str2ConcatStr1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
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

        // 문자열 c에 문자열 a와 b를 붙입니다.
        String c = a + b;

        // 문자열 d에 문자열 b와 a를 붙입니다.
        String d = b + a;

        // 두 문자열이 같다면 true를, 같지 않다면 false를 출력합니다.
        if (c.equals(d))
            System.out.print("true");
        else
            System.out.print("false");
    }
}