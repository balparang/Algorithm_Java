import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력. a, b는 짝수
        int a = sc.nextInt();
        int b = sc.nextInt();

        // a to b, 자연수 중 짝수만 출력. 중첩 사용 제한
        int i = a;
        while (i <= b) {
            System.out.print(i + " ");
            i += 2;
        }
    }
}