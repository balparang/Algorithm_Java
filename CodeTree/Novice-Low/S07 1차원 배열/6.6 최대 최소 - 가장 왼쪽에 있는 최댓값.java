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

        // 가장 왼쪽에 있는 최댓값 탐색
        int maxIndex = n; // 최댓값 인덱스

        while (maxIndex != 0) {
            int max = Integer.MIN_VALUE;
            int tmpIndex = maxIndex;

            for (int i = 0; i <= tmpIndex - 1; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
            }

            // 최댓값이 몇 번째에 위치해있는지 출력
            System.out.print(maxIndex + 1 + " ");
        }
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] a = new int[MAX_N];

        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int prevMaxIdx = n;

        // 첫 번째 원소가 최대가 되기 전까지 계속 반복합니다.
        while(true) {
            // 최대값 후보의 시작은 항상 첫 번째 원소입니다.
            int maxIdx = 0;

            // 두 번째 원소부터 바로 직전 최대로 뽑힌
            // 원소 전까지 보면서 그 중 최대 index를 갱신합니다.
            // index를 오름차순으로 보기 때문에
            // 최댓값이 여러개인 경우 가장 왼쪽에 있는
            // 원소가 뽑히게 됩니다.
            for(int i = 1; i < prevMaxIdx; i++)
                if(a[i] > a[maxIdx])
                    maxIdx = i;

            System.out.print((maxIdx + 1) + " ");

            // 최대인 원소가 첫 번째 원소라면 종료합니다.
            if(maxIdx == 0)
                break;

            // 바로 직전 최대 index를 갱신해줍니다.
            prevMaxIdx = maxIdx;
        }
    }
}

// 해설 2
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int[] a = new int[MAX_N];

        int[] indices = new int[MAX_N];
        int cnt = 0;

        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        // 첫 번째 원소는 항상 답이 됩니다.
        indices[cnt++] = 0;

        // 바로 직전에 답으로 추가한 원소보다
        // 현재 원소가 더 큰 경우에만 답으로 추가합니다.
        for(int i = 1; i < n; i++) {
            int lastIdx = indices[cnt - 1];
            if(a[i] > a[lastIdx])
                indices[cnt++] = i;
        }

        for(int i = cnt - 1; i >= 0; i--) {
            int idx = indices[i];
            System.out.print((idx + 1) + " ");
        }
    }
}