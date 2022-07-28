import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner();

        int a = sc.nextInt();

        if (10 <= a && a <= 20) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}