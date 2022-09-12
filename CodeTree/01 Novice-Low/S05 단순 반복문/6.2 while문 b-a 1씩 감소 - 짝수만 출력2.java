import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // b, a 입력. 둘 다 짝수
        int b = sc.nextInt();
        int a = sc.nextInt();

        // b부터 a까지 짝수 출력
        int i = b;
        while (i >= a) {
            System.out.print(i + " ");
            i -= 2;
        }

    }
}