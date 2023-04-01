/**
 * ㄱ자형 블럭과 일자형 블럭을 각각 적용해서 최대합 구하기
 */

import java.util.*;

public class Main {

	static final int MAX_N = 200;

	static int n, m;
	static int[][] grid = new int[MAX_N][MAX_N];

	// Type1 : 'ㄱ'자 블럭
	static int getMaxSumOfType1(int x, int y) {
		int maxSum = 0;

		// out of range
		if (x + 1 > n - 1 || y + 1 > m - 1) {
			return 0;
		}

		// 모서리를 하나씩 제거해본다.
		int squareSum = grid[x][y] + grid[x + 1][y] + grid[x][y + 1] + grid[x + 1][y + 1];
		int sum1 = squareSum - grid[x][y];
		int sum2 = squareSum - grid[x + 1][y];
		int sum3 = squareSum - grid[x][y + 1];
		int sum4 = squareSum - grid[x + 1][y + 1];

		maxSum = Math.max(maxSum, sum1);
		maxSum = Math.max(maxSum, sum2);
		maxSum = Math.max(maxSum, sum3);
		maxSum = Math.max(maxSum, sum4);

		return maxSum;
	}

	// Type2 : 일자형 블럭
	static int getMaxSumOfType2(int x, int y) {
		int maxSum = 0;

		int rowSum = 0;
		if (!(y + 2 > m - 1)) {
			rowSum = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
		}
		maxSum = Math.max(maxSum, rowSum);

		int colSum = 0;
		if (!(x + 2 > n - 1)) {
			colSum = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
		}
		maxSum = Math.max(maxSum, colSum);

		return maxSum;
	}

	static int getMaxSum() {
		int maxSum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) { // 기준점 [i][j]
				int sum1 = getMaxSumOfType1(i, j);
				int sum2 = getMaxSumOfType2(i, j);

				// System.out.println(i + ", " + j + " : " + sum1 + "/" + sum2);

				maxSum = Math.max(sum1, maxSum);
				maxSum = Math.max(sum2, maxSum);
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		// grid info
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		// answer
		int maxSum = getMaxSum();

		// output
		System.out.println(maxSum);
	}
}

/**
 * 해설
 */

import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 200;

	public static int n, m;
	public static int[][] grid = new int[MAX_NUM][MAX_NUM];

	// 가능한 모든 모양을 전부 적어줍니다.
	public static int[][][] shapes = new int[][][] // 2차원 배열이 여러개 -> 3차원 배열
		{
			{{1, 1, 0},
			{1, 0, 0},
			{0, 0, 0}},

			{{1, 1, 0},
			{0, 1, 0},
			{0, 0, 0}},

			{{1, 0, 0},
			{1, 1, 0},
			{0, 0, 0}},

			{{0, 1, 0},
			{1, 1, 0},
			{0, 0, 0}},

			{{1, 1, 1},
			{0, 0, 0},
			{0, 0, 0}},

			{{1, 0, 0},
			{1, 0, 0},
			{1, 0, 0}},
		};

	// 주어진 위치에 대하여 가능한 모든 모양을 탐색하며 최대 합을 반환합니다.
	public static int getMaxSum(int x, int y) {
		int maxSum = 0;

		for (int i = 0; i < 6; i++) {
			boolean isPossible = true;
			int sum = 0;
			for (int dx = 0; dx < 3; dx++)
				for (int dy = 0; dy < 3; dy++) {
					if (shapes[i][dx][dy] == 0)
						continue;
					if (x + dx >= n || y + dy >= m)
						isPossible = false;
					else
						sum += grid[x + dx][y + dy];
				}

			if (isPossible)
				maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		int ans = 0;

		// 격자의 각 위치에 대하여 탐색하여줍니다.
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				ans = Math.max(ans, getMaxSum(i, j));

		System.out.print(ans);
	}
}