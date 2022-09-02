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