import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] nStrArr = String.valueOf(n).split("");

        // 역순 정렬
        Arrays.sort(nStrArr, Collections.reverseOrder());

        // 정렬된 배열을 문자열로 다시 변환
        StringBuilder sb = new StringBuilder();
        for (String num : nStrArr) {
            sb.append(num);
        }

        // 문자열을 정수로 변환하여 리턴
        return Long.parseLong(sb.toString());
    }
}

// 다른 사람의 풀이
public int reverseInt(int n){

    String str = Integer.toString(n);
    char[] c = str.toCharArray();
    Arrays.sort(c);
    StringBuilder sb = new StringBuilder(new String(c,0,c.length));
    return Integer.parseInt(((sb.reverse()).toString()));
}