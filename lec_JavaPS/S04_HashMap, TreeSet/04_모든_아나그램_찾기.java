import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> mapA = new HashMap<>(); // 문자열 a를 이용해서 만든 해쉬맵
        HashMap<Character, Integer> mapB = new HashMap<>();
        // 해쉬맵 초깃값
        for (char x : b.toCharArray()) mapB.put(x, mapB.getOrDefault(x, 0) + 1); // 문자열 b로 밸류 채움
        for (int i = 0; i < b.length() - 1; i++) mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);

        int lt = 0;
        for (int rt = b.length() - 1; rt < a.length(); rt++) {
            mapA.put(a.charAt(rt), mapA.getOrDefault(a.charAt(rt), 0) + 1);
            if (mapA.equals(mapB)) answer++;

            // a.charAt(lt)에 해당하는 밸류를 1만큼 감소시키고, 밸류가 0이라면 key를 remove
            mapA.put(a.charAt(lt), mapA.get(a.charAt(lt)) - 1);
            if (mapA.get(a.charAt(lt)) == 0) mapA.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a, b));

    }
}