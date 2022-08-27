import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(arr);
        Integer[] reverseArr = descendingSort(arr);

        // 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (Integer num : reverseArr) {
            System.out.print(num + " ");
        }
    }

    private static Integer[] descendingSort(int[] arr) {
        Integer[] newArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr, Collections.reverseOrder());
        return newArr;
    }
}

// 해설
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // 오름차순 정렬
        Arrays.sort(nums);

        for (int i = 0; i < n; i++)
            System.out.print(nums[i] + " ");
        System.out.println();

        // 내림차순 정렬
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2, Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            System.out.print(nums2[i] + " ");
        System.out.println();
    }
}