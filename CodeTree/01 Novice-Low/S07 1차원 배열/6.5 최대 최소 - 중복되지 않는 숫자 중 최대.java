import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] countArr = new int[1001];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            countArr[arr[i]]++;
        }

        int maxVal = -1;
        for (int i = 1; i < 1001; i++) {
            if (countArr[i] == 1) {
                maxVal = i;
            }
        }

        if (maxVal == -1) {
            System.out.println(-1);
        } else {
            System.out.println(maxVal);
        }
    }
}

// 해설 1 - 최댓값 갱신 이전에 원소가 유일한지 확인하고 갱신
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] nums = new int[MAX_N];

        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // 최댓값 찾기
        int max = -1;
        for(int i = 0; i < n; i++) {
            int currNum = nums[i];
            // 최대가 될 수 있는 후보입니다.
            if(max < currNum) {
                // 갱신할 수 있는지 확인하기 위해 이 숫자의 등장 빈도를 셉니다.
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(nums[j] == currNum) {
                        count++;
                    }
                }
                // 이 숫자가 배열에서 유일할때만 갱신합니다.
                if(count == 1) {
                    max = currNum;
                }
            }
        }

        // 최댓값과 최솟값을 출력합니다.
        System.out.print(max);
    }
}

// 해설 2 - count배열 이용, 큰 수 부터 확인
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000; // 입력값 N의 최댓값
    public static final int MAX_NUM = 1000; // 원소의 최댓값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] nums = new int[MAX_N];

        // count 배열을 0으로 초기화
        // 편의상 배열의 index가 실제 숫자를 나타내도록 하기 위해
        // MAX_NUM+1개의 공간을 갖는 배열로 선언합니다.
        int[] count = new int[MAX_NUM + 1];

        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // step1. count 배열에 수의 등장 빈도를 셉니다.
        for(int i = 0; i < n; i++)
            count[nums[i]]++;

        // step2. 큰 수부터 체크하며 한 번 등장한 최대의 값을 찾습니다.
        int answer = -1;
        for(int maxCandidate = MAX_NUM; maxCandidate >= 0; maxCandidate--) {
            if(count[maxCandidate] == 1) {
                answer = maxCandidate;
                break;
            }
        }

        // 최댓값과 최솟값을 출력합니다.
        System.out.print(answer);
    }
}