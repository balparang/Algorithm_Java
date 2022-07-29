import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // 1부터 n까지 출력
        int i = 1;
        while (i <= n) {
            System.out.print(i + " ");
            i++;
        }
    }
}