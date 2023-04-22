/**
 * 23.04.22: 배열 3개를 한 줄로 이어 붙여서 열차 놀이처럼 생각
 * A[] - B[] - C[]
 */

import java.util.Scanner;

public class Main {

	/*
		A, B, C 세 배열로 구성
		t초 동안,
		1. temp <- CLast
		2. C[] 원소 한 칸씩 뒤로 밀기,
			C[0] <- BLast
		3. B[] 원소 한 칸씩 뒤로 밀기,
			B[0] <- ALast
		4. A[] 원소 한 칸씩 뒤로 밀기,
			A[0] <- temp
	 */

	static final int MAX_N = 200;
	static int[] A = new int[MAX_N + 1]; // 좌상변
	static int[] B = new int[MAX_N + 1]; // 우상변
	static int[] C = new int[MAX_N + 1]; // 아래변

	static int n, t; // n: 배열의 숫자 개수, t: t초 후 결과

	static void simulate() {
		// t 초 동안 시뮬레이션 반복
		for (int i = 0; i < t; i++) {

			int lastIdx = n - 1;

			// 1. temp <- CLast
			int temp = C[lastIdx];

			// 2. C[] 원소 한 칸씩 뒤로 밀기, C[0] <- BLast
			pushElems(C, lastIdx);
			C[0] = B[lastIdx];

			// 3. B[] 원소 한 칸씩 뒤로 밀기, B[0] <- ALast
			pushElems(B, lastIdx);
			B[0] = A[lastIdx];

			// 4. A[] 원소 한 칸씩 뒤로 밀기, A[0] <- temp
			pushElems(A, lastIdx);
			A[0] = temp;
		}
	}

	static void pushElems(int[] arr, int lastIdx) {
		for (int j = lastIdx; j >= 1; j--) {
			arr[j] = arr[j - 1];
		}
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();

		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			C[i] = sc.nextInt();
		}

		// 시뮬레이션
		simulate();

		// 출력
		printElems(A);
		System.out.println();
		printElems(B);
		System.out.println();
		printElems(C);
	}

	static void printElems(int[] arr) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}

/**
 * 해설: 배열을 쭉 이어서 보는 것이 아니라 하나마다 완성시켜나가는 방식
 */

import java.util.Scanner;

public class Main {
	public static final int MAX_N = 200;

	// 전역 변수 선언:
	public static int n, t;

	public static int[] l = new int[MAX_N + 1];
	public static int[] r = new int[MAX_N + 1];
	public static int[] d = new int[MAX_N + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력:
		n = sc.nextInt();
		t = sc.nextInt();

		for(int i = 0; i < n; i++)
			l[i] = sc.nextInt();

		for(int i = 0; i < n; i++)
			r[i] = sc.nextInt();

		for(int i = 0; i < n; i++)
			d[i] = sc.nextInt();

		while(t-- > 0) {
			// Step 1
			// 왼쪽에서 가장 오른쪽에 있는 숫자를 따로 temp값에 저장해놓습니다.
			int temp = l[n - 1];

			// Step 2
			// 왼쪽에 있는 숫자들을 완성합니다.
			// 벨트를 기준으로 오른쪽에서부터 채워넣어야 하며,
			// 맨 왼쪽 숫자는 아래에서 가져와야함에 유의합니다.
			for(int i = n - 1; i >= 1; i--)
				l[i] = l[i - 1];
			l[0] = d[n - 1];

			// Step 3
			// 오른쪽에 있는 숫자들을 완성합니다.
			// 벨트를 기준으로 마찬가지로 오른쪽에서부터 채워넣어야 하며,
			// 맨 왼쪽 숫자는 이전 단계에서 미리 저장해놨던 temp값을 가져와야함에 유의합니다.
			int temp2 = r[n - 1];
			for(int i = n - 1; i >= 1; i--)
				r[i] = r[i - 1];
			r[0] = temp;

			// Step 4
			// 아래에 있는 숫자들을 완성합니다.
			// 마찬가지로 벨트를 기준으로 오른쪽에서부터 채워넣어야 하며,
			// 맨 왼쪽 숫자는 이전 단계에서 미리 저장해놨던 temp값을 가져와야함에 유의합니다.
			for(int i = n - 1; i >= 1; i--)
				d[i] = d[i - 1];
			d[0] = temp2;
		}

		// 출력:
		for(int i = 0; i < n; i++)
			System.out.print(l[i] + " ");
		System.out.println();

		for(int i = 0; i < n; i++)
			System.out.print(r[i] + " ");
		System.out.println();

		for(int i = 0; i < n; i++)
			System.out.print(d[i] + " ");
	}
}