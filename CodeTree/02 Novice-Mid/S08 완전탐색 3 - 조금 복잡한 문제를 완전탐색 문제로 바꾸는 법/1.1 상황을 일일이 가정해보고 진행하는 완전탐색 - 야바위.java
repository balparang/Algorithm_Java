// Try 1 - fail : 최대 점수를 출력해야한다(오독)

import java.util.Scanner;

class Order {
    int a, b, c;

    public Order(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {

    static final int MAX_N = 100;

    static Order[] orders = new Order[MAX_N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            orders[i] = new Order(a, b, c);
        }

        // 공이 처음 1 ~ 3번에 놓여있는 경우, 각 경우의 최대 점수구하기
        int maxScore = 0, start = 0;

        for (int i = 1; i <= 3; i++) {
            int[] cups = new int[3 + 1];
            int score = 0;

            // 컵 순서 바꾸고 점수 확인하는 시뮬레이션
            for (int j = 0; j < n; j++) {
                cups[i] = 1;
                swap(orders[j].a, orders[j].b, cups);

                if (cups[orders[j].c] == 1) {
                    score++;
                }
            }

            if (score > maxScore) {
                maxScore = score;
                start = i;
            }
        }

        // 어디에 공을 넣고 시작해야하는지 출력
        System.out.println(start);
    }

    // swap
    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// Try2 - pass
import java.util.Scanner;

class Order {
    int a, b, c;

    public Order(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {

    static final int MAX_N = 100;

    static Order[] orders = new Order[MAX_N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            orders[i] = new Order(a, b, c);
        }

        // 공이 처음 1 ~ 3번에 놓여있는 경우, 각 경우의 최대 점수구하기
        int maxScore = 0;

        for (int i = 1; i <= 3; i++) {
            int[] cups = new int[3 + 1];
            int score = 0;

            // 컵 순서 바꾸고 점수 확인하는 시뮬레이션
            for (int j = 0; j < n; j++) {
                cups[i] = 1;
                swap(orders[j].a, orders[j].b, cups);

                if (cups[orders[j].c] == 1) {
                    score++;
                }
            }

            maxScore = Math.max(maxScore, score);
        }

        // 최대 점수 출력
        System.out.println(maxScore);
    }

    // swap
    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_NUM = 3;

    public static int n;
    public static int[] a = new int[MAX_N];
    public static int[] b = new int[MAX_N];
    public static int[] c = new int[MAX_N];
    public static int[] yabawi = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int maxScore = 0;

        // 시작 위치를 전부 가정해 봅니다.
        // 그 중 최대 점수를 계산합니다.
        for (int i = 1; i <= 3; i++) {
            // 종이컵을 전부 비워줍니다.
            yabawi[1] = yabawi[2] = yabawi[3] = 0;

            // i번째 종이컵에 처음 조약돌을 넣고 시작합니다.
            yabawi[i] = 1;

            int score = 0;
            // 게임을 순서대로 진행합니다.
            for (int j = 0; j < n; j++) {
                // 두 종이컵을 교환합니다.
                int temp = yabawi[a[j]];
                yabawi[a[j]] = yabawi[b[j]];
                yabawi[b[j]] = temp;

                // 교환 이후 c[j]번에 돌이 있다면 점수를 얻게 됩니다.
                if (yabawi[c[j]] == 1)
                    score++;
            }

            // 최대 점수를 갱신합니다.
            maxScore = Math.max(maxScore, score);
        }

        System.out.println(maxScore);
    }
}