import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 큰 수에서 작은 수 뺀 값 출력
        int result = a > b ? a - b : b - a;
        System.out.println(result);
    }
}