import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 입력
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 온전수 개수 구하기
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            // 온전수 인지 확인
            if (isOnjeonsu(i)) {
                cnt++;
            }
        }

        // 출력
        System.out.println(cnt);
    }

    private static boolean isOnjeonsu(int i) {
        if (i % 2 == 0) {
            return false;
        }
        if (i % 10 == 5) {
            return false;
        }
        if (i % 3 == 0 && i % 9 != 0) {
            return false;
        }
        return true;
    }
}