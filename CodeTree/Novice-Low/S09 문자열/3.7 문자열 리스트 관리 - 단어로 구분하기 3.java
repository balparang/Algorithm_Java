import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String[] strArr = new String[10];

        // 배열에 원소 입력
        for (int i = 0; i < 10; i++) {
            strArr[i] = sc.next();
        }

        // 역방향 순회하면서 원소 출력
        for (int i = 9; i >= 0; i--) {
            System.out.println(strArr[i]);
        }
    }
}