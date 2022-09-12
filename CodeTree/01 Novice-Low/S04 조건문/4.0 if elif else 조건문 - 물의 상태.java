import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int temperature = sc.nextInt();

        // 출력
        if (temperature < 0) {
            System.out.println("ice");
        } else if (temperature >= 100) {
            System.out.println("vapor");
        } else {
            System.out.println("water");
        }
    }
}