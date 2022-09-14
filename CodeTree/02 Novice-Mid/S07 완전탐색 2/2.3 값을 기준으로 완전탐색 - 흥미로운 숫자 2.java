import java.util.Scanner;

public class Main {
    static int X, Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        X = sc.nextInt();
        Y = sc.nextInt();

        // X ~ Y 중 흥미 숫자 개수 찾기 - 각 자리수를 정하고 완전탐색
        int ans = 0;

        for (int i = X; i <= Y; i++) {
            String numStr = String.valueOf(i);
            String[] numArr = numStr.split("");

            // 현재 숫자가 흥미 숫자인지 판단
            for (int j = 0; j < numArr.length; j++) {
                String target = numArr[j];
                boolean isFunNumber = true;
                String otherNum = null;

                for (int k = 0; k < numStr.length(); k++) {
                    if (k == j) continue;

                    // target과 같은 숫자가 나타나면 안 된다.
                    if (numArr[k].equals(target)) {
                        isFunNumber = false;
                        break;
                    }

                    // target을 제외한 숫자는 하나의 숫자로 통일되어야한다.
                    if (otherNum == null) {
                        otherNum = numArr[k];
                    } else if (!otherNum.equals(numArr[k])) {
                        isFunNumber = false;
                        break;
                    }
                }

                if (isFunNumber) ans++;
            }
        }

        // 출력
        System.out.println(ans);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static int x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        x = sc.nextInt();
        y = sc.nextInt();

        int ans = 0;

        // 각 숫자에 대해
        // 흥미로운 숫자인지 아닌지 여부를 판단합니다.
        for (int i = x; i <= y; i++) {
            // digit배열을 만들어 각 자리 숫자의 개수를 저장합니다.
            // allDigits에는 총 자릿수의 개수를 저장합니다.
            int num = i;
            int[] digit = new int[10];
            int allDigits = 0;
            while (num > 0) {
                digit[num % 10]++;
                allDigits++;
                num /= 10;
            }

            // intersting : i가 흥미로운 숫자이면 true, 아니면 false
            boolean interesting = false;

            // 흥미로운 숫자가 되기 위해서는,
            // 숫자 하나만 allDigits - 1회 등장해야 합니다.
            for (int j = 0; j < 10; j++)
                if (digit[j] == allDigits - 1)
                    interesting = true;

            if (interesting)
                ans++;
        }

        System.out.print(ans);
    }
}

// 다른 사람의 풀이 - 숫자가 나온 횟수 기록
import java.io.*;
import java.util.*;

public class Main {

    static int X, Y;
    static int[] countArr;

    public static void main(String[] args) throws Exception {
        countArr = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int num = X; num <= Y; num++) {
            Arrays.fill(countArr, 0);
            boolean isInteresting = false;
            char[] chars = String.valueOf(num).toCharArray();
            for (char c : chars) {
                countArr[c - '0']++;
            }

            for (int count : countArr) {
                if (count == chars.length - 1) {
                    isInteresting = true;
                    break;
                }
            }

            if (isInteresting) answer++;
        }

        System.out.println(answer);
    }
}