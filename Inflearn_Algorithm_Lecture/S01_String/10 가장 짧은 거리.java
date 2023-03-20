import java.util.Scanner;

/**
 * 23.03.20
 */

public class Main {

    public static void main(String[] args) throws IOException {

        main.Main T = new main.Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        String word = st.nextToken();
        char ch = st.nextToken().charAt(0);

        // 출력
        int[] answer = T.solution(word, ch);

        String joined = Arrays.stream(answer)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

        System.out.println(joined);
    }

    public int[] solution(String word, char target) {

        int[] distArr = new int[word.length()];

        // 문자열을 순회하면서 최소 거리를 기록
        for (int i = 0; i < word.length(); i++) {

            // 현재 문자가 타겟과 일치하면 거리는 0
            if (word.charAt(i) == target) {
                distArr[i] = 0;
                continue;
            }

            // 타겟과의 최소 거리를 구한다.
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < word.length(); j++) {

                // 타겟 찾기
                if (word.charAt(j) == target) {

                    // 거리 계산
                    int dist = Math.abs(j - i);

                    // 최소 거리로 갱신
                    if (dist < minDist) {
                        minDist = dist;
                    }
                }
            }

            // 최소거리를 다 구했으면 거리를 기록한다.
            distArr[i] = minDist;
        }

        return distArr;
    }
}

/**
 * 해설
 */
public class Main {

    public static void main(String[] args) {

        main.Main T = new main.Main();

        // 입력
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char target = sc.next().charAt(0);

        // 출력
        for (int x : T.solution(str, target)) {
            System.out.print(x + " ");
        }
    }

    public int[] solution(String str, char target) {

        // 문자열의 길이가 100을 넘지 않으므로, 매우 큰 수라는 의미로 1000 할당
        int dist = 1000;

        int[] answer = new int[str.length()];

        // 좌 -> 우 방향으로 순회하면서 왼쪽 target 기준으로 거리 계산
        // 0 	1 	2 	3 	4 	5 	6 	7 	8 	9	10
        // t 	e 	a 	c 	h 	e 	r 	m 	o 	d	e
        // 1001 0 	1 	2 	3 	0 	1 	2 	3 	4	0
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == target) {
                dist = 0;
            } else {
                dist++;
            }
            answer[i] = dist;
        }

        // 좌 <- 우 방향으로 순회하면서 오른쪽 target 기준으로 거리 갱신
        // 0	1	2 	3 	4 	5 	6 	7 	8 	9	10
        // t	e	a 	c 	h 	e 	r 	m 	o 	d	e
        // 1	0	1 	2 	1 	0 	1 	2 	2 	1	0
        dist = 1000;

        for (int i = str.length() - 1; i >= 0; i--) {

            if (str.charAt(i) == target) {
                dist = 0;
            } else {
                dist++;

                // 기존값과 새로 구한 거리 중 작은 값으로 거리 갱신
                answer[i] = Math.min(answer[i], dist);
            }
        }

        return answer;
    }
}