import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 크기 비교
        if (a <= b && a <= c) { // a가 가장 작은 경우
            System.out.println(a);
        } else if (b <= a && b <= c) { // b가 가장 작은 경우
            System.out.println(b);
        } else { // c가 가장 작은 경우
            System.out.println(c);
        }
    }
}