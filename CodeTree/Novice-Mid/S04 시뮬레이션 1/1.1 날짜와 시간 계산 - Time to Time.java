import java.util.Scanner;

public class Main {
    static int a, b;
    static int c, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        // 시간 (분 단위) 계산
        int minute = (c * 60 + d) - (a * 60 + b);

        // 출력
        System.out.println(minute);
    }
}