import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        char ch = sc.next().charAt(0);

        // String.indexOf() 를 사용하여 주어진 문자의 인덱스 찾기
        int indexOfCh = str.indexOf(ch);

        // indexOf() 의 리턴값이 -1 이라면 "No" 출력
        if (indexOfCh == -1) {
            System.out.println("No");
        } else {
            System.out.println(indexOfCh);
        }
    }
}

// 해설 - 직접 찾기
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String str;
        char a;

        // 문자열을 입력받습니다.
        str = sc.next();

        // 문자를 입력받습니다.
        a = sc.next().charAt(0);

        int length = str.length();
        int startIdx = -1;

        // 문자열 a가 존재하는지 확인하고 존재할 경우 그 인덱스를 기록합니다.
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == a) {
                startIdx = i;
                break;
            }
        }

        // 문자열 a가 존재하지 않는다면 No를 출력합니다.
        if (startIdx == -1) {
            System.out.println("No");
        } else {
            System.out.println(startIdx);
        }
    }
}