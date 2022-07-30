import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

        // 자기 자신을 제외한 약수의 합
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        char result = (sum == n) ? 'P' : 'N';
        System.out.println(result);
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n;
        int sum = 0;

        n = sc.nextInt();

        // 1부터 n-1까지의 수 중에서 약수를 찾습니다.
        for(int i = 1; i < n; i++) {
            if(n % i == 0)
                sum += i;
        }

        // sum과 n이 같다면 P을, 다르다면 N을 출력합니다.
        if(sum == n)
            System.out.print("P");
        else
            System.out.print("N");
    }
}