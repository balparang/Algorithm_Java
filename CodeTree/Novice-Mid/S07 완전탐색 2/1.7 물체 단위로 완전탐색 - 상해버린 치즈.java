// Try 1 - 구현 실패. 해설 보고 공부

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static final int MAX_D = 1000;
    static final int MAX_S = 50;

    static int n, m, d, s;
    static ArrayList<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    static int[][] eat = new int[MAX_D][3];
    static int[][] pain = new int[MAX_S][2];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        s = sc.nextInt();

        for (int i = 0; i < d; i++) {
            eat[i][0] = sc.nextInt();
            eat[i][1] = sc.nextInt();
            eat[i][2] = sc.nextInt();
        }

        for (int i = 0; i < s; i++) {
            pain[i][0] = sc.nextInt();
            pain[i][1] = sc.nextInt();
        }

        // 아파지기 먹은 치즈가 후보
        for (int i = 0; i < s; i++) {
            int person = pain[i][0];
            int sickTime = pain[i][1];

            for (int j = 0; j < d; j++) {
                // 아픈 사람이 먹은 시각이 아픈 시각 이전이라면 치즈를 후보로 추가
                if (eat[j][0] == person && eat[j][2] < sickTime) {
                    set.add(eat[j][1]);
                }
            }
        }

        System.out.println(set);

        // 아픈 사람이 먹지 않았던 치즈는 제외
        for (int i = 0; i < s; i++) {
            int person = pain[i][0];
            Set<Integer> copySet = new HashSet<>(set);
            Set<Integer> tmpSet = new HashSet<>();

            // 아픈 사람이 먹었던 모든 치즈 기록
            for (int j = 0; j < d; j++) {
                if (eat[j][0] == person) {
                    tmpSet.add(eat[j][1]);
                }
            }

//            copySet.removeAll(tmpSet); // 아픈 사람이 먹지 않은 치즈
//            set.removeAll(copySet); // [1, 2]
        }
    }
}

// 해설
import java.util.Scanner;

// 치즈를 먹은 정보를 나타내는 클래스 선언
class Info1 {
    int p, m, t;

    public Info1(int p, int m, int t) {
        this.p = p;
        this.m = m;
        this.t = t;
    }
};

// 치즈를 먹은 정보를 나타내는 클래스 선언
class Info2 {
    int p, t;

    public Info2(int p, int t) {
        this.p = p;
        this.t = t;
    }
};

public class Main {
    public static final int MAX_N = 50;
    public static final int MAX_D = 1000;

    public static int n, m, d, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        s = sc.nextInt();

        Info1[] info1 = new Info1[MAX_D];
        Info2[] info2 = new Info2[MAX_N];

        for (int i = 0; i < d; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            info1[i] = new Info1(p, m, t);
        }

        for (int i = 0; i < s; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            info2[i] = new Info2(p, t);
        }

        int ans = 0;

        // 하나의 치즈가 상했을 때 필요한 약의 수의 최댓값을 구합니다.
        for (int i = 1; i <= m; i++) {
            // i번째 치즈가 상했을 때 필요한 약의 수를 구합니다.

            // 우선 i번째 치즈가 상했다고 가정할 때 모순이 발생하지 않는지 확인합니다.
            // time배열을 만들어 각 사람이 언제 치즈를 먹었는지 저장합니다.
            int[] time = new int[MAX_N + 1];
            for (int j = 0; j < d; j++) {
                // i번째 치즈에 대한 정보가 아닌 경우 넘어갑니다.
                if (info1[j].m != i)
                    continue;

                // person이 i번째 치즈를 처음 먹었거나
                // 이전보다 더 빨리 먹게 된 경우 time배열을 갱신합니다.
                int person = info1[j].p;
                if (time[person] == 0)
                    time[person] = info1[j].t;
                else if (time[person] > info1[j].t)
                    time[person] = info1[j].t;
            }

            // possible : i번째 치즈가 상했을 수 있으면 true, 아니면 false
            boolean possible = true;

            for (int j = 0; j < s; j++) {
                // person이 i번째 치즈를 먹지 않았거나
                // i번째 치즈를 먹은 시간보다 먼저 아픈 경우 모순이 생깁니다.
                int person = info2[j].p;
                if (time[person] == 0)
                    possible = false;
                if (time[person] >= info2[j].t)
                    possible = false;
            }

            // 만약 i번째 치즈가 상했을 가능성이 있다면, 몇 개의 약이 필요한지 확인합니다.
            int pill = 0;
            if (possible) {
                // 한번이라도 i번째 치즈를 먹은 적이 있다면, 약이 필요합니다.
                for (int j = 1; j <= n; j++) {
                    if (time[j] != 0)
                        pill++;
                }
            }

            ans = Math.max(ans, pill);
        }

        System.out.print(ans);
    }
}

// Try 2 - pass
import java.util.Scanner;

// info1 : 먹은 정보
class Info1 {
    int p, m, t;

    public Info1(int p, int m, int t) {
        this.p = p;
        this.m = m;
        this.t = t;
    }
}

// info2 : 아픈 정보
class Info2 {
    int p, t;

    public Info2(int p, int t) {
        this.p = p;
        this.t = t;
    }
}

public class Main {
    static final int MAX_N = 50;
    static final int MAX_M = 50;
    static final int MAX_D = 1000;
    static final int MAX_S = MAX_N;

    static int n, m, d, s;
    static Info1[] info1 = new Info1[MAX_D];
    static Info2[] info2 = new Info2[MAX_S];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        s = sc.nextInt();

        for (int i = 0; i < d; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            info1[i] = new Info1(p, m, t);
        }
        for (int i = 0; i < s; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            info2[i] = new Info2(p, t);
        }

        // 치즈 하나에 대하여 완전탐색 (1번 ~ m번 치즈)
        int ans = 0;

        for (int i = 1; i < m + 1; i++) {
            // i번째 치즈를 먹은 시각을 각 사람별로 기록
            int[] time = new int[MAX_N + 1];

            for (int j = 0; j < d; j++) {
                // 현재 치즈와 관련된 정보가 아니면 스킵
                if (info1[j].m != i) continue;

                int person = info1[j].p;
                // 현재 사람이 i번째 치즈를 처음 먹는 경우 그대로 기록
                if (time[person] == 0) {
                    time[person] = info1[j].t;
                }
                // 기록된 시각보다 먹은 시각이 빠른 경우(한 치즈를 2번 이상 먹는 경우) 시각 갱신
                // (현재 사람이 i번째 치즈를 처음 먹은 시각을 기록)
                else if (time[person] > info1[j].t) {
                    time[person] = info1[j].t;
                }
            }

            // 주어진 단서를 조합하여 모순이 일어나는 경우 가능성 제외
            boolean possible = true; // 현재 치즈가 상했을 가능성

            for (int j = 0; j < s; j++) {
                int person = info2[j].p;
                // 모순 1 :아픈 사람 중에 현재 치즈를 먹은 적이 없는 경우
                if (time[person] == 0) {
                    possible = false;
                    break;
                }

                // 모순 2 : 아픈 시각 보다 현재 치즈를 먹은 시각이 늦거나 같은 경우
                // (치즈는 하나만 상하므로 상한 치즈가 아픈 시각보다 늦을 수 없다.)
                if (time[person] >= info2[j].t) {
                    possible = false;
                    break;
                }
            }

            // 현재 치즈가 상했을 가능성이 있는 경우, 필요한 약의 개수 구하기
            int pills = 0;
            if (possible) {
                // 현재 약을 먹은 사람 수 세기
                for (int j = 0; j <= n; j++) {
                    if (time[j] > 0) pills++;
                }
            }

            // 약의 최대 개수 갱신
            ans = Math.max(ans, pills);
        }

        // 출력
        System.out.println(ans);
    }
}