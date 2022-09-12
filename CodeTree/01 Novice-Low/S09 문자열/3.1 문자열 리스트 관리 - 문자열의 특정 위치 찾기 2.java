import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String[] arr = new String[]{"apple", "banana", "grape", "blueberry", "orange"};
        char ch = sc.next().charAt(0);

        // 문자열 중 세 번째나 네 번째 문자와 일치하는 문자열과 총 개수 찾기
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(2) == ch || arr[i].charAt(3) == ch) {
                System.out.println(arr[i]);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}