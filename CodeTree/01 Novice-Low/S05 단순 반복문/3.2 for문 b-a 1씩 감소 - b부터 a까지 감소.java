import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // b부터 a까지 1씩 감소
        for (int i = b; i >= a; i--) {
            System.out.print(i + " ");
        }
    }
}