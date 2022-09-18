import java.util.*;

public class Main {
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) { // 1과 자기 자신을 제외한( i <- 2 to num - 1
            if (num % i == 0) return false; //  약수가 존재하면 소수 아님
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int result = 0; // 뒤집힌 숫자

            while(tmp > 0) {
                int remainder = tmp % 10; // 나머지
                result = result * 10 + remainder;
                tmp = tmp / 10; // 몫, 123 -> 12
            }
            if(isPrime(result)) answer.add(result);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}