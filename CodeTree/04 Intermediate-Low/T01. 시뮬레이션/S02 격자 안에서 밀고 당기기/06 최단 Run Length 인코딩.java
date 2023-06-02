/*
	23.06.02
	- 가능한 횟수만큼 shift -> encode(shifted) -> update min length
	- shift 결과를 메모이제이션을 사용하면 성능이 더 좋아질 것 같다.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static String A;
	static int n; // length of A

	// encode as run-length
	static String encode(String target) {
		StringBuilder encoded = new StringBuilder();

		// set first char
		encoded.append(target.charAt(0));
		int cnt = 1; // successive char count

		for (int i = 1; i < n; i++) {
			if (target.charAt(i) == target.charAt(i - 1)) {
				cnt++;
				continue;
			}
			encoded.append(cnt);
			encoded.append(target.charAt(i));
			cnt = 1;
		}

		// set last
		encoded.append(cnt);

		return encoded.toString();
	}

	// shift for count
	static String shift(String target, int cnt) {
		String[] shifted = target.split("");

		while (cnt-- > 0) {
			String tmp = shifted[shifted.length - 1];

			for (int i = shifted.length - 1; i >= 1; i--) {
				shifted[i] = shifted[i - 1];
			}

			shifted[0] = tmp;
		}

		return String.join("", shifted);
	}

	// simulate
	static int getMinLen() {

		if (n == 1) {
			return 2;
		}

		int minLen = Integer.MAX_VALUE;

		// 길이가 1인경우 실행되지 않음
		// for shift Count 1 to n - 1
		for (int cnt = 1; cnt < n; cnt++) {
			// shifted <- shift(cnt)
			String shifted = shift(A, cnt);

			// encoded <- encode(shifted)
			String encoded = encode(shifted);

			// update Min Length
			minLen = Math.min(minLen, encoded.length());
		}

		return minLen;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);

		A = sc.nextLine();
		n = A.length();

		// simulate
		int minLen = getMinLen();

		// 출력
		System.out.println(minLen);
	}
}

/*
	해설 - 문자열을 계속 바꿔가며 진행
*/

import java.util.Scanner;

public class Main {
	public static String runLengthEncoding(String input){
		// 이 함수는 input 문자열을 Run-Length-Encoding한 결과를 반환합니다.
		String encoded = "";

		// 입력의 첫번째 값을 읽고 초기화합니다.
		char currChar = input.charAt(0);
		int numChar = 1;
		for(int i = 1; i < (int) input.length(); i++){
			if(input.charAt(i) == currChar)
				numChar++;
			else {
				// 지금까지 세어온 currChar와 numChar를 기록합니다.
				encoded += currChar;
				encoded += String.valueOf(numChar);
				// currChar와 numChar를 현재 값으로 초기화합니다.
				currChar = input.charAt(i);
				numChar = 1;
			}
		}
		// 마지막 덩어리에 해당하는 currChar와 numChar를 기록합니다.
		encoded += currChar;
		encoded += String.valueOf(numChar);
		return encoded;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();

		int minLength = runLengthEncoding(A).length(); // 초기값은 shift안했을 때의 값
		int n = A.length();
		int numShift = n - 1; // 0부터 length - 1

		while(numShift-- > 0){
			// 문자열 A를 오른쪽으로 1번 shift합니다.
			// 오른쪽부터 채워넣어야하며, 마지막 값은 temp에 저장된 값을 사용해야함을 유의합니다.
			A = A.substring(1) + A.substring(0, 1);
			int length = runLengthEncoding(A).length();
			if(minLength > length)
				minLength = length;
		}

		// 출력
		System.out.print(minLength);
	}
}