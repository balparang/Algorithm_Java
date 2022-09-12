import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int midTerm = sc.nextInt();
        int finalTerm = sc.nextInt();

        if (midTerm < 90) {
            System.out.println(0);
        } else if (finalTerm >= 95) { // midTerm >= 90
            System.out.println(100000);
        } else if (finalTerm >= 90) { // midTerm >= 90, finalTerm 90~94
            System.out.println(50000);
        } else { // midTerm >= 90, finalTerm < 90
            System.out.println(0);
        }
    }
}

/* 선생님 답안 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int f = sc.nextInt();

        if (m >= 90 && f >= 95) {
            System.out.println("100000");
        } else if (m >= 90 && f >= 90) {
            System.out.println("50000");
        } else {
            System.out.println("0");
        }
    }
}