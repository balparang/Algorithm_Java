import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        int eeCnt = 0, ebCnt = 0;

        // "ee"와 "ab" 가 나온 횟수 구하기
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("ee")) {
                eeCnt++;
            }
            if (str.substring(i, i + 2).equals("eb")) {
                ebCnt++;
            }
        }

        // 출력
        System.out.println(eeCnt + " " + ebCnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();
        int cnt1 = 0;
        int cnt2 = 0;

        // 문자열 'ee'와 'eb'가 몇 번 나왔는지 확인합니다.
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == 'e' && str.charAt(i + 1) == 'e')
                cnt1++;
            if (str.charAt(i) == 'e' && str.charAt(i + 1) == 'b')
                cnt2++;
        }

        // 문자열 'ee'와 'eb'가 각각 몇 번 나왔는지 출력합니다.
        System.out.print(cnt1 + " " + cnt2);
    }
}