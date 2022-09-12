import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int aMath = sc.nextInt();
        int aEng = sc.nextInt();

        int bMath = sc.nextInt();
        int bEng = sc.nextInt();

        // 출력
        if (aMath > bMath && aEng > bEng) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}