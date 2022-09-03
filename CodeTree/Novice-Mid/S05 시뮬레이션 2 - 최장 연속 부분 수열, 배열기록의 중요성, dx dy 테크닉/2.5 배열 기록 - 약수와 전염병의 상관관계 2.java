// Try 1 - fail
/*
Test Case
        3 2 1 3
        1 1 2
        2 1 2
        3 2 3
*/

import java.util.Arrays;
import java.util.Scanner;

class Order {
    int order;
    int x, y;

    public Order(int order, int x, int y) {
        this.order = order;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int t = sc.nextInt();

        int[] infected = new int[n + 1];
        int[] handShakes = new int[n + 1]; // 악수 할 수 있는 횟수

        infected[p] = 1; // 최초 감염자 기록
        Arrays.fill(handShakes, k); // 악수할 수 있는 횟수 초기화

        Order[] orders = new Order[t];
        for (int i = 0; i < t; i++) {
            int order = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            orders[i] = new Order(order, x, y);
        }

        // orders[] 를 order 오름차순으로 정렬
        Arrays.sort(orders, (o1, o2) -> o1.order - o2.order);

        // orders[] 순회하면서 감염자 기록
        for (int i = 0; i < t; i++) {
            Order cur = orders[i];
            // 악수 횟수가 남아있으면서, 둘 중 한 명이 감염된 상태인 경우
            if (handShakes[cur.x] != 0 && handShakes[cur.y] != 0) {
                if (infected[cur.x] == 1 || infected[cur.y] == 1) {
                    infected[cur.x] = 1;
                    infected[cur.y] = 1;
                    handShakes[cur.x]--;
                    handShakes[cur.y]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(infected[i]);
        }
    }
}

// Try 2 - pass
import java.util.Arrays;
        import java.util.Scanner;

class Sequence {
    int order;
    int x, y;

    public Sequence(int order, int x, int y) {
        this.order = order;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int MAX_N = 100;
    static final int MAX_K = 250;
    static final int MAX_T = 250;

    static boolean[] infected = new boolean[MAX_N + 1];
    static int[] handshake = new int[MAX_N + 1];
    static Sequence[] sequences = new Sequence[MAX_T];

    static int n, k, p, t; // n 명 개발자, 최대 악수 횟수 k, 초기 감염자 p, 시퀀스 t개

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextInt();
        t = sc.nextInt();

        // 악수 횟수 초기화
        Arrays.fill(handshake, k);

        // 초기 감염자 지정
        infected[p] = true;

        // 시퀀스 입력
        for (int i = 0; i < t; i++) {
            int order = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            sequences[i] = new Sequence(order, x, y);
        }

        // 시퀀스 순서에 맞게 정렬
        Arrays.sort(sequences, 0, t, (a, b) -> {
            return a.order - b.order;
        });

        // 시뮬레이션 진행
        for (int i = 0; i < t; i++) {
            Sequence seq = sequences[i];

            // x, y 둘다 감염된 경우
            if (infected[seq.x] && infected[seq.y]) {
                // 악수 횟수 소진
                if (handshake[seq.x] > 0) {
                    handshake[seq.x]--;
                }
                if (handshake[seq.y] > 0) {
                    handshake[seq.y]--;
                }
            }

            // x 만 감염된 경우
            else if (infected[seq.x] && !infected[seq.y]) {
                // 악수횟수 남아있으면 소모하고, 상대방 감염
                if (handshake[seq.x] > 0) {
                    handshake[seq.x]--;
                    infected[seq.y] = true;
                }
            }

            // y 만 감염된 경우
            else if (!infected[seq.x] && infected[seq.y]) {
                // 악수횟수 남아있으면 소모하고, 상대방 감염
                if (handshake[seq.y] > 0) {
                    handshake[seq.y]--;
                    infected[seq.x] = true;
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}

// 해설 - 전체 악수의 횟수도 기록 가능!
import java.util.Scanner;
        import java.util.Arrays;

// 악수의 정보를 나타내는 클래스 선언
class Shake implements Comparable<Shake> {
    int time;
    int person1;
    int person2;

    public Shake(int time, int person1, int person2) {
        this.time = time;
        this.person1 = person1;
        this.person2 = person2;
    }

    @Override
    public int compareTo(Shake shake) {
        // 시간을 기준으로 오름차순으로 정렬합니다.
        return time - shake.time;
    }
};

public class Main {
    public static final int MAX_T = 250;
    public static final int MAX_N = 100;

    public static int n, k, p, t;
    public static int[] shakeNum = new int[MAX_N + 1];
    public static boolean[] infected = new boolean[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextInt();
        t = sc.nextInt();
        infected[p] = true;

        Shake[] shakes = new Shake[MAX_T];

        for (int i = 0; i < t; i++) {
            int time = sc.nextInt();
            int person1 = sc.nextInt();
            int person2 = sc.nextInt();
            // Shake 객체를 생성해 벡터에 추가합니다.
            shakes[i] = new Shake(time, person1, person2);
        }

        // custom comparator를 활용한 정렬
        Arrays.sort(shakes, 0, t);

        // 각 악수 횟수를 세서,
        // K번 초과로 악수를 했을 시 전염시키지 않습니다.
        for (int i = 0; i < t; i++) {
            int target1 = shakes[i].person1;
            int target2 = shakes[i].person2;

            // 감염되어 있을 경우 악수 횟수를 증가시킵니다.
            if (infected[target1])
                shakeNum[target1]++;
            if (infected[target2])
                shakeNum[target2]++;

            // target1이 감염되어 있고 아직 K번 이하로 악수했다면 target2를 전염시킵니다.
            if (shakeNum[target1] <= k && infected[target1])
                infected[target2] = true;

            // target2가 감염되어 있고 아직 K번 이하로 악수했다면 target1을 전염시킵니다.
            if (shakeNum[target2] <= k && infected[target2])
                infected[target1] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (infected[i])
                System.out.print(1);
            else
                System.out.print(0);
        }

    }
}