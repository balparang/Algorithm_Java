import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        String strEven;

        // 문자열에서 짝수 번째 문자를 추출하여 새 문자열 생성
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 1) {
                sb.append(str.charAt(i));
            }
        }

        // 새 문자열을 역순으로 출력
        strEven = sb.toString();
        for (int i = strEven.length() - 1; i >= 0; i--) {
            System.out.print(strEven.charAt(i));
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 구현합니다.
        String str = sc.next();

        // 가장 먼저 출력해야 할 문자의 인덱스를 구합니다.
        int idx = str.length() - 1;
        if(idx % 2 == 0) idx--;

        // 문자열을 순회하여 조건대로 문자를 출력합니다.
        for(int i = idx; i >= 0; i -= 2) {
            System.out.print(str.charAt(i));
        }
    }
}