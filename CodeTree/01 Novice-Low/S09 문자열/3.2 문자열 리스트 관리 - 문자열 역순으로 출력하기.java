import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String[] strArr = new String[4];

        // 배열에 원소 입력
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = sc.next();
        }

        // 문자열 배열의 원소를 역순으로 출력
        for (int i = strArr.length - 1;  i >= 0; i--) {
            System.out.println(strArr[i]);
        }
    }
}