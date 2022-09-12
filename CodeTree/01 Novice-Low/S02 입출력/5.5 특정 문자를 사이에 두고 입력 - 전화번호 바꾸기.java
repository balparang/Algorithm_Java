import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-"); // '-' 기준으로 구분

        String a = sc.next(); // 정수형으로 입력 시 010 이 10으로 저장되는 문제 -> 문자열로 입력
        int xxxx = sc.nextInt();
        int yyyy = sc.nextInt();

        // 출력
        System.out.printf("%s-%d-%d\n", a, yyyy, xxxx);
    }
}