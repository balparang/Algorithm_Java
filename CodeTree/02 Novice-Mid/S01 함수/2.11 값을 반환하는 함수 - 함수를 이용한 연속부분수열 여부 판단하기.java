import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n1 = sc.nextInt(); // 수열 A의 길이
        int n2 = sc.nextInt(); // 수열 B의 길이
        int[] A = new int[n1];
        int[] B = new int[n2];

        // 수열 입력
        for (int i = 0; i < n1; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            B[i] = sc.nextInt();
        }

        // 연속 부분 수열인지 확인
        if (isSuccessiveSequence(A, B)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isSuccessiveSequence(int[] A, int[] B) {
        for (int i = 0; i <= A.length - B.length; i++) {
            boolean allSame = true;

            for (int j = 0; j < B.length; j++) {
                if (A[i + j] != B[j]) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) {
                return true;
            }
        }

        return false;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;

    public static int n1, n2;
    public static int[] a = new int[MAX_N];
    public static int[] b = new int[MAX_N];

    // n번째 인덱스부터 시작하는 n2길이의 a수열과
    // b수열이 완전히 일치하는지 확인합니다..
    public static boolean isSame(int n) {
        for (int i = 0; i < n2; i++)
            if (a[i + n] != b[i])
                return false;

        return true;
    }

    // b가 a의 연속부분수열인지 확인합니다.
    public static boolean isSubsequence() {
        for (int i = 0; i <= n1 - n2; i++)
            if (isSame(i))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        n1 = sc.nextInt();
        n2 = sc.nextInt();

        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();


        if (isSubsequence())
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}