class Solution {
    public boolean solution(int x) {
        boolean answer = false;

        int tmp = x;
        int sum = 0;

        while (tmp > 0) {
            int lastNum = tmp % 10;
            sum += lastNum;
            tmp /= 10;
        }

        if (x % sum == 0) {
            answer = true;
        }

        return answer;
    }
}

// 다른 사람의 풀이
public class HarshadNumber {
    public boolean isHarshad(int num) {

        String[] temp = String.valueOf(num).split("");

        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }

        if (num % sum == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        HarshadNumber sn = new HarshadNumber();
        System.out.println(sn.isHarshad(18));
    }
}