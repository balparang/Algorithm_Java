import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        // 길이가 1이 아닌 경우에만 shift
        if (str.length() != 1) {
            str = str.substring(1) + str.substring(0, 0 + 1);
        }

        System.out.println(str);
    }
}