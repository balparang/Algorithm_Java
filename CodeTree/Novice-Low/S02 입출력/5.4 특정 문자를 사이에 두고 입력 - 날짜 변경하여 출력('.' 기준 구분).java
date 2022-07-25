import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\."); // '.' 자체는 모든 단어를 의미. '.'을 기준으로 구분자를 사용하려면 '\\.' 과 같이 사용한다.

        int yyyy = sc.nextInt();
        int mm = sc.nextInt();
        int dd = sc.nextInt();

        // 출력
        System.out.printf("%d-%d-%d\n", mm, dd, yyyy);
    }
}