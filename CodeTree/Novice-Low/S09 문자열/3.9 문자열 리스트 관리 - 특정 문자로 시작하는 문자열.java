import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int arrLen = sc.nextInt();
        String[] strArr = new String[arrLen];
        char ch;
        int cnt = 0;
        int lenSum = 0;

        // 데이터 입력
        for (int i = 0; i < arrLen; i++) {
            strArr[i] = sc.next();
        }
        ch = sc.next().charAt(0);

        // 특정 문자로 시작하는 문자열의 개수 카운팅 & 문자열 길이의 평균 구하기기
        for (int i = 0; i < arrLen; i++) {
            if (strArr[i].charAt(0) == ch) {
                lenSum += strArr[i].length();
                cnt++;
            }
        }

        // 출력 "개수 평균길이"
        System.out.printf("%d %.2f", cnt, (double) lenSum / cnt);
    }
}