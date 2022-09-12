import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // 넓이 계산
        int area = n * n;

        // 출력
        System.out.println(area);
        if (area < 25) {
            System.out.println("tiny");
        }
    }
}