import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        char a = sc.next().charAt(0);
        int b = sc.nextInt();

        // 변환
        int aInt = (int) a;
        char bChar = (char) b;

        // 출력
        System.out.printf("%d %c", aInt, bChar);
    }
}