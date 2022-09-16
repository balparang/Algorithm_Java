// Try1 - fail: ans 갱신 시점 오류.

import java.util.Scanner;

public class Main {
    static final int MAX_X = 100;
    static final int MAX_N = 100;

    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // x, y축에 평행한 직선 정하기 & 정한 직선에 대해 1,2,3,4 분면 점의 개수 세기
        int ans = Integer.MAX_VALUE;

        for (int i = 2; i <= 100; i += 2) {
            int maxCnt = 0;

            for (int j = 2; j <= 100; j += 2) {
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt3 = 0;
                int cnt4 = 0;

                for (int k = 0; k < n; k++) {
                    if (x[k] > i) {
                        if (y[k] > j) {
                            cnt1++;
                        } else {
                            cnt4++;
                        }
                    } else {
                        if (y[k] > j) {
                            cnt2++;
                        } else {
                            cnt3++;
                        }
                    }
                }

                maxCnt = Math.max(cnt1, cnt2);
                maxCnt = Math.max(maxCnt, cnt3);
                maxCnt = Math.max(maxCnt, cnt4);
            }

            ans = Math.min(ans, maxCnt);
        }

        // 출력
        System.out.println(ans);
    }
}

// Try 2
import java.util.Scanner;

public class Main {
    static final int MAX_X = 100;
    static final int MAX_N = 100;

    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // x, y축에 평행한 직선 정하기 & 정한 직선에 대해 1,2,3,4 분면 점의 개수 세기
        int ans = Integer.MAX_VALUE;

        for (int i = 2; i <= MAX_X; i += 2) {
            int maxCnt = 0;

            for (int j = 2; j <= MAX_X; j += 2) {
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt3 = 0;
                int cnt4 = 0;

                for (int k = 0; k < n; k++) {
                    if (x[k] > i) {
                        if (y[k] > j) {
                            cnt1++;
                        } else {
                            cnt4++;
                        }
                    } else {
                        if (y[k] > j) {
                            cnt2++;
                        } else {
                            cnt3++;
                        }
                    }
                }

                maxCnt = Math.max(cnt1, cnt2);
                maxCnt = Math.max(maxCnt, cnt3);
                maxCnt = Math.max(maxCnt, cnt4);

                // 정답 갱신
                ans = Math.min(ans, maxCnt);
            }

        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_X = 100;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = MAX_N;

        // 모든 직선에 대해 전부 시도해 봅니다.
        for (int i = 0; i <= MAX_X; i += 2)
            for (int j = 0; j <= MAX_X; j += 2) {
                // x = i, y = j 를 기준으로 나눴을 때의 m을 구합니다.
                // segment : x = i, y = j를 기준으로 1 ~ 4사분면의 점의 개수
                int[] segment = new int[5];

                for (int k = 0; k < n; k++) {
                    // k번째 점이 몇사분면인지 확인하고 해당 위치의 segment를 1 증가시킵니다.
                    if (x[k] > i && y[k] > j)
                        segment[1]++;
                    else if (x[k] < i && y[k] > j)
                        segment[2]++;
                    else if (x[k] < i && y[k] < j)
                        segment[3]++;
                    else
                        segment[4]++;
                }

                // x = i, y = j로 나눴을때의 m을 구합니다.
                int curM = Math.max(segment[1], segment[2]);
                curM = Math.max(curM, segment[3]);
                curM = Math.max(curM, segment[4]);

                ans = Math.min(ans, curM);
            }

        System.out.print(ans);
    }
}