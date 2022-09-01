// Try 1 - fail: k 횟수 이상이어야 한다.

import java.util.Scanner;

public class Main {
    static final int MAX_Q = 10000;
    static final int MAX_N = 100;

    static int n, m, k;

    static int[] queries = new int[MAX_Q];
    static int[] studentsNum = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        // 쿼리 입력
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }

        // 쿼리 배열을 순회하면서, 쿼리에 해당하는 학생에게 벌칙 부여
        int firstOne = -1; // 최초로 벌금 내는 학생
        for (int i = 0; i < m; i++) {
            studentsNum[queries[i]]++; // queries[i]: 벌칙 받을 학생

            if (studentsNum[queries[i]] == 3) {
                firstOne = queries[i];
                break;
            }
        }

        // 출력
        System.out.println(firstOne);
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    static final int MAX_Q = 10000;
    static final int MAX_N = 100;

    static int n, m, k;

    static int[] queries = new int[MAX_Q];
    static int[] studentsNum = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        // 쿼리 입력
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }

        // 쿼리 배열을 순회하면서, 쿼리에 해당하는 학생에게 벌칙 부여
        int firstOne = -1; // 최초로 벌금 내는 학생
        for (int i = 0; i < m; i++) {
            int target = queries[i];
            studentsNum[target]++; // queries[i]: 벌칙 받을 학생

            if (studentsNum[target] >= k) {
                firstOne = target;
                break;
            }
        }

        // 출력
        System.out.println(firstOne);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int n, m, k;
    public static int[] penalizedPerson = new int[MAX_M];
    public static int[] penaltyNum = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++)
            penalizedPerson[i] = sc.nextInt();

        // 각 패널티 횟수를 세서,
        // 최초로 K번 이상 벌칙을 받는 사람을 추적합니다.
        int ans = -1;
        for (int i = 0; i < m; i++) {
            int target = penalizedPerson[i];
            penaltyNum[target]++;

            if (penaltyNum[target] >= k) {
                ans = target;
                break;
            }
        }

        System.out.print(ans);
    }
}