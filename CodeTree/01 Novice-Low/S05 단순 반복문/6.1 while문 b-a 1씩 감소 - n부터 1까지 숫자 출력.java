import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // n부터 1까지 1씩 감소하며 출력, while문 사용
        int i = n;
        while (i >= 1) {
            System.out.print(i + " ");
            i--;
        }
    }
}