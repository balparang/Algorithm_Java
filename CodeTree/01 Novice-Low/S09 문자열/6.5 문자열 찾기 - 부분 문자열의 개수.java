import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String A = sc.next();
        String B = sc.next();
        int cnt = 0;

        // 문자열 B가 문자열 A의 부분 문자열로써 등장하는 횟수 구하기
        for (int i = 0; i <= A.length() - 1 - (B.length() - 1); i++) {
            boolean allSame = true;

            // 부분 문자열인지 확인
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i + j) != B.charAt(j)) {
                    allSame = false;
                    break;
                }
            }

            // B가 A의 부분 문자열이라면 등장 횟수 + 1
            if (allSame) {
                cnt++;
            }
        }

        // 출력
        System.out.println(cnt);
    }
}