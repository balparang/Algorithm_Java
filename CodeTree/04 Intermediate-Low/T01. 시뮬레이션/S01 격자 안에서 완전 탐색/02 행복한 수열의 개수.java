import java.util.Scanner;

public class Main {

	/**
	 * 행/열 각각 순회하면서 행복순열 구하기
	 */

	static final int MAX_N = 100;
	static int n, m;
	static int[][] grid = new int[MAX_N][MAX_N];

	static boolean isHappyRow(int row) {
		int maxSeries = 1;
		int series = 1;

		for (int col = 1; col < n; col++) {
			if (grid[row][col - 1] == grid[row][col]) {
				series++;
				maxSeries = Math.max(series, maxSeries);
				continue;
			}
			series = 1;
		}

		return maxSeries >= m; // 최대 연속 개수가 기준을 넘는지 여부
	}

	static boolean isHappyCol(int col) {
		int maxSeries = 1;
		int series = 1;

		for (int row = 1; row < n; row++) {
			if (grid[row - 1][col] == grid[row][col]) {
				series++;
				maxSeries = Math.max(series, maxSeries);
				continue;
			}
			series = 1;
		}

		return maxSeries >= m; // 최대 연속 개수가 기준을 넘는지 여부
	}

	static public int getHappy() {
		int happy = 0;

		// 행에서 행복수열 찾기
		for (int row = 0; row < n; row++) {
			if (isHappyRow(row)) {
				happy++;
			}
		}

		// 열에서 행복수열 찾기
		for (int col = 0; col < n; col++) {
			if (isHappyCol(col)) {
				happy++;
			}
		}

		return happy;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		// 그리드
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// 행복순열 개수 구하기
		int answer = getHappy();

		// 출력
		System.out.println(answer);
	}
}

/**
 * 해설 - 행과 열의 행복순열 구하는 로직을 하나로 활용
 */

import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;

	public static int n, m;
	public static int[][] grid = new int[MAX_N][MAX_N];

	public static int[] seq = new int[MAX_N];

	public static boolean isHappySequence() {
		// 주어진 seq가 행복한 수열인지 판단하는 함수입니다.
		int consecutiveCount = 1, maxCcnt = 1;
		for (int i = 1; i < n; i++) {
			if (seq[i - 1] == seq[i])
				consecutiveCount++;
			else
				consecutiveCount = 1;

			maxCcnt = Math.max(maxCcnt, consecutiveCount);
		}

		// 최대로 연속한 회수가 m이상이면 true를 반환합니다.
		return maxCcnt >= m;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int numHappy = 0;

		// 먼저 가로로 행복한 수열의 수를 셉니다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				seq[j] = grid[i][j];

			if (isHappySequence())
				numHappy++;
		}

		// 세로로 행복한 수열의 수를 셉니다.
		for (int j = 0; j < n; j++) {
			// 세로로 숫자들을 모아 새로운 수열을 만듭니다.
			for (int i = 0; i < n; i++)
				seq[i] = grid[i][j];

			if (isHappySequence())
				numHappy++;
		}

		System.out.print(numHappy);
	}
}
