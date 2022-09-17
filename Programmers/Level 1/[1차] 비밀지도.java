// Try 1 - pass
// 다른 사람들의 풀이랑 비교했을 때 많이 길다. 공부해서 다음 번에 풀 때는 더 좋은 풀이를
// 추가하도록 하자.
import java.util.Arrays;

class Solution {
    static int size;
    static String[] binary1, binary2;
    static String[] answer;
    static String[][] secretMap;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        size = n;
        binary1 = new String[size];
        binary2 = new String[size];
        answer = new String[size];
        secretMap = new String[size][size];

        // arr1, arr2 이진수 배열로 변환
        for (int i = 0; i < size; i++) {
            int num = arr1[i];
            String binary = toBinary(num);
            binary1[i] = binary;
        }
        for (int i = 0; i < size; i++) {
            int num = arr2[i];
            String binary = toBinary(num);
            binary2[i] = binary;
        }

        // 이진수 배열을 맵에 기록
        for (int i = 0; i < size; i++) {
            String bin1 = binary1[i];
            String bin2 = binary2[i];

            for (int j = 0; j < size; j++) {
                if (bin1.charAt(j) == '1' || bin2.charAt(j) == '1') {
                    secretMap[i][j] = "#";
                } else {
                    secretMap[i][j] = " ";
                }
            }
        }

        // 맵을 문자열로 변환하여 리턴
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < size; j++) {
                sb.append(secretMap[i][j]);
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    // 주어진 정수를 2진수 문자열로 변환
    static String toBinary(int num) {
        int[] digits = new int[size];
        int idx = 0;

        while (true) {
            if (num < 2) {
                digits[idx++] = num;
                break;
            }

            digits[idx++] = num % 2;
            num /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }

        return sb.toString();
    }

//    public static void main(String[] args) {
//        int n = 5;
//        int[] arr1 = new int[]{9, 20, 28, 18, 11};
//        int[] arr2 = new int[]{30, 1, 21, 17, 28};
//
//        Solution sol = new Solution();
//        String[] answer = Arrays.toString()
//        System.out.println(sol.solution(5, arr1, arr2));
//    }
}