import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();

        // 살수 있는 물건 계산
        String str = null;
        if (n >= 3000) {
            str = "book";
        } else if (n >= 1000) {
            str = "mask";
        } else if (n >= 500) {
            str = "pen";
        } else {
            str = "no";
        }

        // 출력
        System.out.println(str);
    }
}