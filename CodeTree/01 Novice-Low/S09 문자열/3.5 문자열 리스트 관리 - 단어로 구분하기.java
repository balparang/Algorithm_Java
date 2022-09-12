import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String[] strArr = new String[10];

        // 배열 입력
        for (int i = 0; i < 10; i++) {
            strArr[i] = sc.next();
        }

        // 출력
        for (int i = 0; i < 10; i++) {
            System.out.println(strArr[i]);
        }
    }
}