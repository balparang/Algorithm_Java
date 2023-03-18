import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		// 문자열 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = br.readLine().toLowerCase();
		char targetChar = br.readLine().toLowerCase().charAt(0);

		// 카운팅
		String[] splitted = inputLine.split("");
		int cnt = 0;

		for (String s : splitted) {

			if (s.equals(String.valueOf(targetChar))) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}

/**
 * 해설 풀이
 */
public class Main {

	public int solution(String str, char t) {

		int answer = 0;

		// 대문자로 통일
		str = str.toUpperCase();
		t = Character.toUpperCase(t);

		// 일치하는 문자 개수 카운팅
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == t) {
				answer++;
			}
		}

		// toCharArray 이용: for (char x : str.toCharArray) {}

		return answer;
	}

	public static void main(String[] args) {

		Main T = new Main();

		// 입력
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);

		// 출력
		System.out.println(T.solution(str, c));
	}
}