import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();

        // 출력
        char result = a == 1 ? 't' : 'f';
        System.out.println(result);
    }
}