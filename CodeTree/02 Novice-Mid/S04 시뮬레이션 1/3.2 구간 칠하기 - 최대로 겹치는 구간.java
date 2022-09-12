import java.util.Scanner;

public class Main {
    static final int OFFSET = 100;
    static int[] sections = new int[OFFSET * 2 + 1];
    static int n;
    static int[] a, b;

    static void stackSection(int a, int b) {
        for (int i = a; i <= b - 1; i++) {
            sections[i]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt() + OFFSET;
            b[i] = sc.nextInt() + OFFSET;
        }

        // 구간 쌓기
        for (int i = 0; i < n; i++) {
            stackSection(a[i], b[i]);
        }

        // 최대로 겹치는 구간에서, 선분의 겹친 개수 구하기
        int max = 0;
        for (int i = 0; i < sections.length; i++) {
            if (sections[i] > max) {
                max = sections[i];
            }
        }

        System.out.println(max);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_R = 200;
    public static final int OFFSET = 100;

    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];

    public static int[] checked = new int[MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();

            // OFFSET을 더해줍니다.
            x1[i] += OFFSET;
            x2[i] += OFFSET;
        }

        // 구간을 칠해줍니다.
        // 구간 단위로 진행하는 문제이므로
        // x2[i]에 등호가 들어가지 않음에 유의합니다.
        for (int i = 0; i < n; i++)
            for (int j = x1[i]; j < x2[i]; j++)
                checked[j]++;

        // 최댓값을 구합니다.
        int max = 0;
        for (int i = 0; i <= MAX_R; i++)
            if (checked[i] > max)
                max = checked[i];

        // 출력
        System.out.print(max);
    }
}