import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int n = 0;

        while (true) {
            if (a >= 1000) {
                System.out.println(n);
                break;
            }

            if (a % 2 == 0) {
                a = a * 3 + 1;
            } else {
                a = a * 2 + 2;
            }

            n++;
        }
    }
}

// 선생님 답안
