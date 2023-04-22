/**
 * 배열 한 개를 이용하여 풀이
 */

import java.util.Scanner;

public class Main {
	/**
	 * 1. 일차원 배열로 2n 개의 숫자 입력
	 * 2. 횟수 t 만큼, 오른쪽으로 한 칸씩 밀기
	 * 3. 숫자 n 개와 n 개를 개행해서 출력
	 */

	static final int MAX_N = 200;

	static int n, t;
	static int[] nums = new int[2 * MAX_N];

	static void pushRight() {
		int temp = nums[2 * n - 1];

		for (int i = 2 * n - 1; i >= 1; i--) {
			nums[i] = nums[i - 1];
		}

		nums[0] = temp;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();

		for (int i = 0; i < 2 * n; i++) {
			nums[i] = sc.nextInt();
		}

		// t회 만큼 오른쪽으로 한 칸씩 밀기
		for (int i = 0; i < t; i++) {
			pushRight();
		}

		// 출력
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}

		System.out.println();

		for (int i = n; i < 2 * n; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}

/**
 * 해설 - 배열을 위, 아래로 나누어 풀이
 */

import java.util.Scanner;

public class Main {
	public static final int MAX_N = 200;

	public static int n, t;

	public static int[] u = new int[MAX_N + 1];
	public static int[] d = new int[MAX_N + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력:
		n = sc.nextInt();
		t = sc.nextInt();

		for(int i = 0; i < n; i++)
			u[i] = sc.nextInt();

		for(int i = 0; i < n; i++)
			d[i] = sc.nextInt();

		while(t-- > 0) {
			// Step 1
			// 위에서 가장 오른쪽에 있는 숫자를 따로 temp값에 저장해놓습니다.
			int temp = u[n - 1];

			// Step 2
			// 위에 있는 숫자들을 완성합니다.
			// 오른쪽에서부터 채워넣어야 하며,
			// 맨 왼쪽 숫자는 아래에서 가져와야함에 유의합니다.
			for(int i = n - 1; i >= 1; i--)
				u[i] = u[i - 1];
			u[0] = d[n - 1];

			// Step 3
			// 아래에 있는 숫자들을 완성합니다.
			// 마찬가지로 오른쪽에서부터 채워넣어야 하며,
			// 맨 왼쪽 숫자는 위에서 미리 저장해놨던 temp값을 가져와야함에 유의합니다.
			for(int i = n - 1; i >= 1; i--)
				d[i] = d[i - 1];
			d[0] = temp;
		}

		// 출력:
		for(int i = 0; i < n; i++)
			System.out.print(u[i] + " ");
		System.out.println();

		for(int i = 0; i < n; i++)
			System.out.print(d[i] + " ");
		System.out.println();
	}
}

/**
 * 23.04.22 - 배열 2개를 이용한 풀이
 */

import java.util.Scanner;

public class Main {

	/*
		up, down 배열로 구성
		1. up의 마지막 원소 를 temp 에 저장
		2. up 원소 한 칸씩 뒤로 밀기
		3. down 마지막 원소를 up의 첫 번째에 삽입
		4. down 원소 한 칸씩 뒤로 밀기
		5. down 첫 번째 원소에 temp 삽입
	 */

	static final int MAX_N = 200;
	static int n, t; // n: 숫자 개수, t: t초 후의 시간

	// ⭐️ MAX_N이 아니라 MAX_N + 1로 설정해주어야한다!!!
	// - 원소 한 칸씩 뒤로 밀 때 OutOfIndex 위험
	static int[] up = new int[MAX_N + 1];
	static int[] down = new int[MAX_N + 1];

	static void simulate() {
		// t초 동안 시뮬레이션 진행
		for (int i = 0; i < t; i++) {
			int lastIdx = n - 1;

			// 1. up의 마지막 원소를 temp 에 저장
			int temp = up[lastIdx];

			// 2. up 원소 한 칸씩 뒤로 밀기
			for (int j = lastIdx; j >= 1; j--) {
				up[j] = up[j - 1];
			}

			// 3. down 마지막 원소를 up의 첫 번째에 삽입
			up[0] = down[lastIdx];

			// 4. down 원소 한 칸씩 뒤로 밀기
			for (int j = lastIdx; j >= 1; j--) {
				down[j] = down[j - 1];
			}

			// 5. down 첫 번째 원소에 temp 삽입
			down[0] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		n = sc.nextInt();
		t = sc.nextInt();

		for (int i = 0; i < n; i++) {
			up[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			down[i] = sc.nextInt();
		}

		// 시뮬
		simulate();

		// 출력
		for (int i = 0; i <= n - 1; i++) {
			System.out.print(up[i] + " ");
		}
		System.out.println();
		for (int i = 0; i <= n - 1; i++) {
			System.out.print(down[i] + " ");
		}
	}
}
