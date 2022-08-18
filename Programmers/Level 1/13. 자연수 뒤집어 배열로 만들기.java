// Try 1 - pass : 문자열을 뒤집고, 뒤집은 문자열을 배열로 변환 (굳이 뒤집을 필요가 없었다.)
class Solution {
    public int[] solution(long n) {
        // 정수를 문자열로 변환
        String nStr = String.valueOf(n);

        // 변환한 문자열을 거꾸로 뒤집는다.
        StringBuilder sb = new StringBuilder();
        String reversedNStr = sb.append(nStr).reverse().toString();

        // 거꾸로 뒤집힌 문자열을 정수 배열로 표현
        int[] answer = new int[reversedNStr.length()];
        for (int i = 0; i < reversedNStr.length(); i++) {
            char ch = reversedNStr.charAt(i);
            answer[i] = Integer.parseInt(String.valueOf(ch));
        }

        return answer;
    }
}

// Try 2
class Solution {
    public int[] solution(long n) {
        // 정수를 문자열로 변환
        String nStr = String.valueOf(n);

        int[] answer = new int[nStr.length()];
        int idx = 0;

        for (int i = nStr.length() - 1; i >= 0; i--) {
            String num = String.valueOf(nStr.charAt(i));
            answer[idx++] = Integer.parseInt(num);
        }

        return answer;
    }
}

// 다른 사람의 풀이
class Solution {
    public int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt = 0;

        while (n > 0) {
            answer[cnt] = (int) (n % 10);
            n /= 10;
            System.out.println(n);
            cnt++;
        }
        return answer;
    }
}