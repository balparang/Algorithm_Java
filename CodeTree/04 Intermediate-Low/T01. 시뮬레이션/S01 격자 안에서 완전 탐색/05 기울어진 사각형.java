/**
 * 가로, 세로 길이를 1 to n-2 로 하여 완전탐색
 */

import java.util.Scanner;

public class Main {

	/*
		방향 1,2,3,4 -> 0,1,2,3 으로 사용
		1. 가로, 세로 최대 길이 구하기
			- 가로 방향: 0, 2
			- 세로 방향: 1, 3
		2. 가로가 1 to max길이 일때,
			세로가 1 to max길이 일 때,
				- 사각형을 그려서 sum 구하기: (가로, 세로) 가 정해진 상태
				- maxSum 갱신

		3. maxSum 출력
	 */

	static final int MAX_N = 20;
	static final int DIR_NUM = 4;
	static int[][] grid = new int[MAX_N][MAX_N];
	static int n;
	static int[] dx = {-1, -1, 1, 1};
	static int[] dy = {1, -1, -1, 1};

	static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	static int borderSum(int row, int col, int w, int h) {
		int cx = row, cy = col; // 시작점

		int sum = 0;

		// System.out.println("row, col = " + row + "," + col + "|" + " w, h = " + w + "," + h);

		for (int dir = 0; dir < DIR_NUM; dir++) {
			if (dir == 0 || dir == 2) { // 가로로 움직일 차례
				for (int i = 0; i < w; i++) {
					int nx = cx + dx[dir];
					int ny = cy + dy[dir];

					if (!inRange(nx, ny))
						return 0;

					cx = nx;
					cy = ny;
					sum += grid[cx][cy];
				}
			} else { // 세로로 움직일 차례
				for (int i = 0; i < h; i++) {
					int nx = cx + dx[dir];
					int ny = cy + dy[dir];

					if (!inRange(nx, ny))
						return 0;

					cx = nx;
					cy = ny;
					sum += grid[cx][cy];
				}
			}

			// System.out.println("cX, cY = " + cx + ", " + cy);
		}

		return sum;
	}

	static int simulate() {
		int maxSum = 0;

		int maxLen = n - 2;

		// 모든 격자를 시작점으로 하여 완전탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// 시작점 마다, 사각형을 그려서 sum 구하기
				// - 가로, 세로가 w, h일 때 sum
				for (int w = 1; w <= maxLen; w++) {
					for (int h = 1; h <= maxLen; h++) {
						int sum = borderSum(i, j, w, h);
						maxSum = Math.max(sum, maxSum);
					}
				}
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// maxSum 구하기
		int maxSum = simulate();

		// 출력
		System.out.println(maxSum);
	}
}

/**
 * 해설
 */

import java.util.Scanner;

public class Main {
	public static final int DIR_NUM = 4;
	public static final int MAX_N = 20;

	public static int n;
	public static int[][] grid = new int[MAX_N][MAX_N];

	public static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	public static int getScore(int x, int y, int k, int l) {
		int[] dx = new int[] {-1, -1, 1, 1};
		int[] dy = new int[] {1, -1, -1, 1};
		int[] moveNum = new int[] {k, l, k, l};

		int sumOfNums = 0;

		// 기울어진 직사각형의 경계를 쭉 따라가봅니다.
		for (int d = 0; d < DIR_NUM; d++)
			for (int q = 0; q < moveNum[d]; q++) {
				x += dx[d];
				y += dy[d];

				// 기울어진 직사각형이 경계를 벗어나는 경우라면
				// 불가능하다는 의미로 답이 갱신되지 않도록
				// 0을 반환합니다.
				if (!inRange(x, y))
					return 0;

				sumOfNums += grid[x][y];
			}

		return sumOfNums;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int ans = 0;

		// (i, j)를 시작으로 1, 2, 3, 4 방향
		// 순서대로 길이 [k, l, k, l] 만큼 이동하면 그려지는
		// 기울어진 직사각형을 잡아보는
		// 완전탐색을 진행해봅니다.
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 1; k < n; k++)
					for (int l = 1; l < n; l++)
						ans = Math.max(ans, getScore(i, j, k, l));

		System.out.print(ans);
	}
}
