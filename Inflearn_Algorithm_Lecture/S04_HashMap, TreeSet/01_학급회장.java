/**
 * 220215 월
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public int solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            // 카운팅
            map.put(x, map.getOrDefault(x, 0) + 1); // x의 key값을 가져오되, 없으면 0을 리턴하고 1을 더함
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }
}