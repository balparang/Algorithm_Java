import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean satisfied = true; // n이 소수이면 true

        for (int i = 2; i <= n - 1; i++) {
            // 소수 판별 -> 1과 자기자신을 제외한 약수가 하나라도 있다면 소수 아님
            if (n % i == 0) {
                satisfied = false;
                break;
            }
        }

        if (satisfied) {
            System.out.println("P");
        } else {
            System.out.println("C");
        }
    }
}

// 선생님 답안
