import java.util.Scanner;

public class Main {

    static int n;
    static int a, b, c; // 100, 10, 1의 자리 숫자

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (Math.abs(i - a) <= 2 || Math.abs(j - b) >= 2
                            || Math.abs(k - c) <= 2) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int n;
    public static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // 모든 조합을 다 만들어 봅니다.
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++) {
                    // 한 자리라도 주어진 조합과의 거리가 2 이내인지 확인합니다.
                    if (Math.abs(a - i) <= 2 || Math.abs(b - j) <= 2 ||
                            Math.abs(c - k) <= 2)
                        cnt++;
                }

        System.out.println(cnt);
    }
}