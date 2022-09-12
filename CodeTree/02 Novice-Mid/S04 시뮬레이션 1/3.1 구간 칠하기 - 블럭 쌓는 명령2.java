import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] blocks;

    static void stackBlock(int a, int b) {
        for (int i = a; i <= b; i++) {
            blocks[i]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        blocks = new int[n + 1];

        // 블럭 쌓기 : [a, b] 구간에 블럭을 하나씩 쌓는다.
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            stackBlock(a, b);
        }

        // 각 칸의 블럭 수 중 최댓값 출력
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (blocks[i] > max) {
                max = blocks[i];
            }
        }

        System.out.println(max);
    }
}

/** 해설
 * 1차원 배열을 새로 만들어, 주어진 구간에 대해 직접 값을 1씩 증가시키는 시뮬레이션을 진행
 */
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_K = 100;

    public static int n, k;
    public static int[] a = new int[MAX_K + 1];
    public static int[] b = new int[MAX_K + 1];

    public static int[] blocks = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        // 블럭을 특정 구간에 쌓아줍니다.
        for(int i = 1; i <= k; i++)
            for(int j = a[i]; j <= b[i]; j++)
                blocks[j]++;

        // 최댓값을 구합니다.
        int max = 0;
        for(int i = 1; i <= n; i++)
            if(blocks[i] > max)
                max = blocks[i];

        // 출력
        System.out.print(max);
    }
}