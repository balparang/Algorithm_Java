import java.util.Scanner;

public class Main {
    static int strLen;
    static String inputStr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        strLen = sc.nextInt();
        inputStr = sc.next();

        // 모든 길이에 대해 완전탐색
        int ans = 0;

        for (int size = 1; size <= strLen; size++) { // 문자열의 길이가 size 일 때,

            boolean satisfied = true; // 현재 size가 문제의 조건을 만족하는지 여부

            // 현재 size에 해당하는 문자열이 (예: 길이가 2인 경우 "AB", "BC", ... )
            // 2번 이상 등장한 경우 현재 size 제외
            for (int startIdx = 0; startIdx <= strLen - size; startIdx++) {
                int endIdx = startIdx + size;

                String target = inputStr.substring(startIdx, endIdx);

                int appearCount = countAppear(target);

//                System.out.println("target = " + target);
//                System.out.println("appearCount = " + appearCount);

                if (appearCount >= 2) {
                    satisfied = false;
                    break;
                }
            }

            if (satisfied) {
                ans = size;
                break;
            }
        }

        // 출력
        System.out.println(ans);
    }

    static int countAppear(String target) {
        int size = target.length();
        int cnt = 0;

        for (int i = 0; i <= strLen - size; i++) {
            String sequence = inputStr.substring(i, i + size);
            if (sequence.equals(target)) {
                cnt++;
            }
        }

        return cnt;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int n;
    public static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        str = sc.next();

        int ans = 1;

        // 1씩 늘려가면서 어느 길이까지 2번 등장하지는지 모두 시도해봅니다.
        for (int i = 1; i < n; i++) {
            // 모든 길이가 i인 부분 문자열에 대해 쌍을 짓고
            // 둘이 완전히 똑같은지 확인합니다.

            // twice : i 길이의 2회 이상 등장하는 부분 문자열이 존재하면 true
            boolean twice = false;

            for (int j = 0; j <= n - i; j++) {
                for (int k = j + 1; k <= n - i; k++) {
                    // issame : j부터 i길이의 부분 문자열과
                    // k부터 i길이의 부분 문자열이 완전히 같으면 true
                    boolean issame = true;

                    for (int l = 0; l < i; l++) {
                        if (str.charAt(j + l) != str.charAt(k + l))
                            issame = false;
                    }

                    if (issame) twice = true;
                }
            }

            if (twice)
                ans = i + 1;
            else
                break;
        }

        System.out.print(ans);
    }
}