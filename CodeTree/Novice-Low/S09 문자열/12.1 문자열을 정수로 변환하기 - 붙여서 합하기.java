import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Astr = sc.next();
        String Bstr = sc.next();

        String ABstr = Astr + Bstr;
        String BAstr = Bstr + Astr;

        int sum = Integer.parseInt(ABstr) + Integer.parseInt(BAstr);
        System.out.println(sum);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String a;
        String b;
        String str1;
        String str2;

        // 문자열을 입력받습니다.
        a = sc.next();
        b = sc.next();

        // str1에는 a, b 순으로 문자열을 붙입니다.
        str1 = a + b;

        // str2에는 a, b 순으로 문자열을 붙입니다.
        str2 = b + a;

        // 합쳐진 문자열을 숫자로 바꿉니다.
        int str1Int = Integer.parseInt(str1);
        int str2Int = Integer.parseInt(str2);

        // 두 숫자의 합을 출력합니다.
        System.out.print(str1Int + str2Int);
    }
}