import java.util.Scanner;

public class Main {
    public int solution(int n, int[] numArr) {
        int count = 1, maxHeight = numArr[0];

        for(int i = 1; i < n; i++){
            if(numArr[i] > maxHeight) { // i번째 학생이, 자신 앞의 학생들 중 가장 큰 학생보다 크면
                count++;
                maxHeight = numArr[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numArr = new int[n];
        for(int i = 0; i < n; i++) {
            numArr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, numArr));
    }
}