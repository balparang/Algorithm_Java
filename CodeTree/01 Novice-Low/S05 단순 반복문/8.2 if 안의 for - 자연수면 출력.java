import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // a가 자연수라면 a를 b번 반복하여 출력
        if (a > 0) {
            for (int i = 0; i < b; i++) {
                System.out.print(a);
            }
        }
        // a가 0이하라면 0을 출력
        else {
            System.out.print(0);
        }
    }
}