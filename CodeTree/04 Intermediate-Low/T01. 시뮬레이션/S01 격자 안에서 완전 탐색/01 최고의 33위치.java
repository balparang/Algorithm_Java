import java.util.Scanner;

public class Main {

	static final int MAX_N = 20;

	static int n;
	static int[][] grid = new int[MAX_N][MAX_N];

	public static boolean inRange(int endX, int endY) {
		return endX < n && endY < n;
	}

	public static int getCoins(int startX, int endX, int startY, int endY) {
		int coinSum = 0;

		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if (grid[i][j] == 1)
					coinSum++;
			}
		}

		return coinSum;
	}

	public static int simulate() {
		// 완전탐색으로 전체 순회하면서 3*3 격자의 코인 개수 구하기. 매 탐색마다 최대 코인 수 갱신
		int maxCoins = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (inRange(i + 2, j + 2)) {
					int currCoins = getCoins(i, i + 2, j, j + 2);
					maxCoins = Math.max(currCoins, maxCoins);
				}
			}
		}

		return maxCoins;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// grid info
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		int maxCoins = simulate();

		// 출력
		System.out.println(maxCoins);
	}
}

/**
 * 해설
 */

import java.util.Scanner;

public class Main {
	public static final int MAX_N = 20;

	public static int n;
	public static int[][] grid = new int[MAX_N][MAX_N];

	// (rowS, colS) ~ (rowE, colE) 사이의 금의 개수를 계산합니다.
	public static int getNumOfGold(int rowS, int colS, int rowE, int colE) {
		int numOfGold = 0;

		for(int row = rowS; row <= rowE; row++) {
			for(int col = colS; col <= colE; col++) {
				numOfGold += grid[row][col];
			}
		}

		return numOfGold;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int maxGold = 0;

		// 입력
		n = sc.nextInt();
		for(int row = 0; row < n; row++)
			for(int col = 0; col < n; col++)
				grid[row][col] = sc.nextInt();

		// (row, col)이 3 * 3 격자의 좌측 모서리인 경우를 전부 탐색합니다.
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				// 3 * 3 격자가 n * n 격자를 벗어나는 경우는 계산하지 않습니다.
				if(row + 2 >= n || col + 2 >= n)
					continue;

				// 금의 개수를 계산합니다.
				int numOfGold = getNumOfGold(row, col, row + 2, col + 2);

				// 최대 금의 개수를 저장합니다.
				maxGold = Math.max(maxGold, numOfGold);
			}
		}

		System.out.println(maxGold);
	}
}