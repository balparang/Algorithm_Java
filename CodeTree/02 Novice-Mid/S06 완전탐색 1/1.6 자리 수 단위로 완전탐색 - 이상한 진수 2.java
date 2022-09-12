// Try 1 - fail
/*
    Test Case
    input : 1111
    정답 : 14
    -------------
    내 풀이 : 15
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int changeNum(int index, String[] arr) {
        String[] copyArr = arr.clone();

        // 자릿수[index]를 변경하여 새로운 숫자 생성
        int changedNum = Integer.parseInt(copyArr[index]) ^ 1;
        arr[index] = String.valueOf(changedNum);

        StringBuilder sb = new StringBuilder();
        for (String str : copyArr) {
            sb.append(str);
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    // brute force
    static int bruteForce(String binaryStr) {
        if (binaryStr.length() == 1) {
            return Integer.parseInt(binaryStr, 2) ^ 1;
        }

        int maxNum = Integer.MIN_VALUE;
        String[] binaryArr = binaryStr.split("");

        for (int i = 1; i < binaryArr.length; i++) {
            int newNum = changeNum(i, binaryArr);
            maxNum = Math.max(maxNum, newNum);
        }

        return maxNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String binaryStr = sc.next();

        // 완전 탐색
        int answer = bruteForce(binaryStr);

        // 출력
        System.out.println(answer);
    }
}

// Try 2 - pass : 코드 오류 수정
import java.util.Arrays;
        import java.util.Scanner;

public class Main {

    static int changeNum(int index, String[] arr) {
        String[] copyArr = arr.clone();

        // 자릿수[index]를 변경하여 새로운 숫자 생성
        int changedNum = Integer.parseInt(copyArr[index]) ^ 1;
        copyArr[index] = String.valueOf(changedNum); // 수정

        StringBuilder sb = new StringBuilder();
        for (String str : copyArr) {
            sb.append(str);
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    // brute force
    static int bruteForce(String binaryStr) {
        if (binaryStr.length() == 1) {
            return Integer.parseInt(binaryStr, 2) ^ 1;
        }

        int maxNum = Integer.MIN_VALUE;
        String[] binaryArr = binaryStr.split("");

        for (int i = 1; i < binaryArr.length; i++) {
            int newNum = changeNum(i, binaryArr);
            maxNum = Math.max(maxNum, newNum);
        }

        return maxNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String binaryStr = sc.next();

        // 완전 탐색
        int answer = bruteForce(binaryStr);

        // 출력
        System.out.println(answer);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력
        String binary = sc.next();

        // 각 i번째 자릿수를 바꾸었을 때의 십진수 값을 구해줍니다.
        int ans = INT_MIN;
        for (int i = 0; i < (int) binary.length(); i++) {
            // i번째 자릿수를 바꿉니다.
            binary = binary.substring(0, i) + (char) ((int) '0' + '1' - binary.charAt(i)) + binary.substring(i + 1);
            // 십진수로 변환합니다.
            int num = 0;
            for (int j = 0; j < (int) binary.length(); j++)
                num = num * 2 + (binary.charAt(j) - '0');

            // 가능한 십진수 값 중 최댓값을 구해줍니다.
            ans = Math.max(ans, num);

            // i번째 자릿수를 원래대로 돌려놓습니다.
            binary = binary.substring(0, i) + (char) ((int) '0' + '1' - binary.charAt(i)) + binary.substring(i + 1);
        }

        // 출력
        System.out.print(ans);
    }
}