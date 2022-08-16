import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int arrLen = sc.nextInt();
        String[] strArr = new String[arrLen];
        int lenSum = 0;
        int aCount = 0;

        // 배열에 원소 입력
        for (int i = 0; i < arrLen; i++) {
            strArr[i] = sc.next();
        }

        // 모든 문자열의 합과, 첫 번째 문자로 'a'가 나오는 횟수 구하기
        for (int i = 0; i < arrLen; i++) {
            lenSum += strArr[i].length();

            if (strArr[i].charAt(0) == 'a') {
                aCount++;
            }
        }

        // 출력
        System.out.println(lenSum + " " + aCount);
    }
}