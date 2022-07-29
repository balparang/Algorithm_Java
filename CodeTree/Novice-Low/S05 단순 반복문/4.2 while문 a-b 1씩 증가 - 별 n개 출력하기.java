import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // n개의 줄에 걸쳐 * 을 한 줄에 하나씩 출력
        int i = 1;
        while (i <= n) { // n회 반복
            System.out.println("*");
            i++;
        }
    }
}

