import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(str.substring(2, 9 + 1)); // 3번째 부터 10번째 까지
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String str;

        // 문자열을 입력받습니다.
        str = sc.nextLine();

        // 문자열의 3번째부터 10번째까지를 출력합니다.
        for(int i = 2; i < 10; i++) {
            System.out.print(str.charAt(i));
        }
    }
}