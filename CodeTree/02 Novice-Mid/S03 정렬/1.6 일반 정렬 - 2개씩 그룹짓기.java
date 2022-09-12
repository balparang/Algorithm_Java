import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        arr = new int[2 * n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 원소의 합 중 최댓값이 최소가 되도록 하기
        // 오름차순 정렬
        Arrays.sort(arr);

        // 양 끝을 더하기
        int maxSum = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            int tmpSum = arr[i] + arr[arr.length - 1 - i];
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
            }
        }

        // 출력
        System.out.println(maxSum);
    }
}

// 해설
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[2 * MAX_N];

        for(int i = 0; i < 2 * n; i++)
            nums[i] = sc.nextInt();

        // nums[0]부터 nums[2n - 1]까지를 정렬함
        Arrays.sort(nums, 0, 2 * n);

        int groupMax = 0;
        for(int i = 0; i < n; i++) {
            // i번째와 2n - 1 - i번째 원소를 매칭
            int groupSum = nums[i] + nums[2*n - 1 - i];
            if(groupSum > groupMax)
                // 최댓값 갱신
                groupMax = groupSum;
        }

        System.out.print(groupMax);

    }
}