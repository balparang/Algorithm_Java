// Try 1 - fail : 사진의 크기에 대한 정의를 제대로 읽지 않음.

import java.util.Scanner;

public class Main {
    static final int MAX_P = 100;
    static final int MAX_N = 100;

    static char[] placed = new char[MAX_P + 1];

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            char symbol = sc.next().charAt(0);
            placed[idx] = symbol;
        }

        // 양 끝 구간을 완전탐색. 구간크기 0 ~ 100
        int maxSize = 0;

        for (int i = 0; i <= MAX_P; i++) {
            for (int j = i; j <= MAX_P; j++) {
                // 현재 구간의 사진 최대 크기
                int currSize = 0;
                int G = 0, H = 0;

                for (int k = i; k <= j; k++) {
                    if (placed[k] == 'G') {
                        G++;
                    } else if (placed[k] == 'H') {
                        H++;
                    }
                }

                if (satisfied(G, H, j - i + 1)) {
                    currSize = j - i; // [1, 1] 인 경우 size 0
                    System.out.printf("i, j = %d, %d\n", i, j);
                }

                maxSize = Math.max(maxSize, currSize);
            }
        }

        // 출력
        System.out.println(maxSize);
    }

    private static boolean satisfied(int g, int h, int length) {
        if (g == 0 && h == 0) {
            return false;
        }
        return g == h || g == length || h == length;
    }
}

// Try 2 - pass: 사진의 크기에 대한 정의 추가. (구간의 끝에는 사람이 서 있어야한다.)
import java.util.Scanner;

public class Main {
    static final int MAX_P = 100;
    static final int MAX_N = 100;

    static char[] placed = new char[MAX_P + 1];

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            char symbol = sc.next().charAt(0);
            placed[idx] = symbol;
        }

        // 양 끝 구간을 완전탐색. 구간크기 0 ~ 100
        int maxSize = 0;

        for (int i = 0; i <= MAX_P; i++) {
            for (int j = i; j <= MAX_P; j++) {
                // 현재 구간의 사진 최대 크기
                int currSize = 0;
                int G = 0, H = 0;

                for (int k = i; k <= j; k++) {
                    if (placed[k] == 'G') {
                        G++;
                    } else if (placed[k] == 'H') {
                        H++;
                    }
                }

                if (satisfied(G, H, j - i + 1)) {
                    // 양쪽 끝에 사람이 서 있는 경우
                    if (placed[i] != '\0' && placed[j] != '\0') {
                        currSize = j - i; // [1, 1] 인 경우 size 0
//                        System.out.printf("i, j = %d, %d\n", i, j);
                    }
                }

                maxSize = Math.max(maxSize, currSize);
            }
        }

        // 출력
        System.out.println(maxSize);
    }

    private static boolean satisfied(int g, int h, int length) {
        if (g == 0 && h == 0) {
            return false;
        }
        return g == h || g == length || h == length;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;

    public static int n, k;
    public static int[] arr = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);

            if (c == 'G')
                arr[x] = 1;
            else
                arr[x] = 2;
        }

        // 모든 구간의 시작점을 잡아봅니다.
        int maxLen = 0;
        for (int i = 0; i <= MAX_NUM; i++) {
            for (int j = i + 1; j <= MAX_NUM; j++) {
                // i와 j 위치에 사람이 있는지 확인합니다.
                if (arr[i] == 0 || arr[j] == 0)
                    continue;

                // 해당 구간 내 g와 h의 개수를 구합니다.
                int cntG = 0;
                int cntH = 0;

                for (int k = i; k <= j; k++) {
                    if (arr[k] == 1)
                        cntG++;
                    if (arr[k] == 2)
                        cntH++;
                }

                // 조건을 만족할 때 구간의 길이를 구해 최댓값과 비교합니다.
                if (cntG == 0 || cntH == 0 || cntG == cntH) {
                    int len = j - i;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        System.out.print(maxLen);
    }
}