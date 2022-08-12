import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열을 앞에서부터 순회하며 사는 시점 탐색
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {

            // 사는 시점 이후부터 순회하며 파는 시점 탐색
            for (int j = i + 1; j < n; j++) {
                int profit = arr[j] - arr[i]; // 이익 = 판매가 - 구매가

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        System.out.println(maxProfit);
    }
}

// 해설 1 - 완전 탐색
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언:
        int n;
        int[] price = new int[MAX_NUM];

        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            price[i] = sc.nextInt();

        // 배열을 앞에서부터 순회하며 사는 시점의 후보를 선택합니다
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            // 사는 시점의 다음 해부터 순회하며 파는 시점의 후보를 선택합니다
            for(int j = i + 1; j < n; j++) {
                int profit = price[j] - price[i];

                if(profit > maxProfit)
                    maxProfit = profit;
            }
        }

        System.out.print(maxProfit);
    }
}

// 해설 2 - Observation, O(1)
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언:
        int n;
        int[] price = new int[MAX_NUM];

        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            price[i] = sc.nextInt();

        // 배열을 앞에서부터 순회하며 최소값을 갱신해줍니다.
        // 각 원소에 대하여 해당 시점의 최소값과의 차이가
        // 최대가 될 때를 갱신해줍니다.
        int maxProfit = 0;
        int minPrice = price[0];
        for(int i = 0; i < n; i++) {
            int profit = price[i] - minPrice;

            // 답을 갱신해줍니다.
            if(profit > maxProfit)
                maxProfit = profit;

            // 지금까지의 최솟값을 갱신해줍니다.
            if(minPrice > price[i])
                minPrice = price[i];
        }

        System.out.print(maxProfit);
    }
}
