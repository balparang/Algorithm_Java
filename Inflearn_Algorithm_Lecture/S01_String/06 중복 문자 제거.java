/**
 * 해설
 */

public class Main {

    public static void main(String[] args) {

        main.Main T = new main.Main();

        // 입력
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 출력
        System.out.println(T.solution(str));
    }

    public String solution(String str) {

        String answer = "";

        for (int i = 0; i < str.length(); i++) {

			/*
			 	ksekkset
			 	k 0 0
			 	s 1 1
			 	e 2 2
			 	k 3 0 // 현재 문자의 인덱스와 indexOf 위치가 다르면 중복 문자이다.
			 	k 4 0
			 	s 5 1
			 	e 6 2
			 	t 7 7
			 */
            // System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));

            // 인덱스와 indexOf 가 일치하는 문자만 담으면, 중복문자가 제거되고 순서가 유지된다.
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }
}