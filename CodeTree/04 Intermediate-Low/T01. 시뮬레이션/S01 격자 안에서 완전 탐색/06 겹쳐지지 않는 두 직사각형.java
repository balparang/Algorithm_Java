/*
	해설 참고 풀이

	두 직사각형을 완전탐색으로 잡아보고, 두 직사각형이 겹치지 않을 때 maxSum 갱신
 */
 */
 */
 */
import java.util.Scanner;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

public class Main {

	/*
		1. 첫 번째 직사각형 잡고,
		2. 두 번째 직사각형을 잡아본다.
		3. 두 직사각형이 겹치지 않는다면 sum 계산 & maxSum 업데이트

		두 직사각형이 겹치는지 여부는 Board에 색칠하여 한 칸이라도 2이상이면 겹치는 것으로 판단.
	 */

	static final int INT_MIN = Integer.MIN_VALUE;
	static final int MAX_N = 5;

	static int n, m; // n by m 사이즈의 grid
	static int[][] grid = new int[MAX_N][MAX_N];
	static int[][] board = new int[MAX_N][MAX_N];

	// clear board
	static void clearBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = 0;
			}
		}
	}

	// draw board
	static void draw(int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				board[i][j]++;
			}
		}
	}

	// isOverlap: 두 직사각형이 겹쳐 있는지 확인
	static boolean isOverlap(int x1, int y1, int x2, int y2, int i, int j, int k, int l) {
		clearBoard();

		draw(x1, y1, x2, y2);
		draw(i, j, k, l);

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (board[row][col] >= 2) return true;
			}
		}

		return false;
	}

	// rectSum
	static int rectSum(int x1, int y1, int x2, int y2) {
		int sum = 0;

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				sum += grid[i][j];
			}
		}

		return sum;
	}

	// 두 번째 직사각형 잡아서, 겹치지 않으면 sum 업데이트
	// 첫 번째 직사각형이 (x1, y1)~(x2, y2) 일때 두 번째 직사각형 (i, j)~(k, l)
	static int findMaxSum(int x1, int y1, int x2, int y2) {
		int maxSum = INT_MIN;

		// 모든 직사각형을 잡고,
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = i; k < n; k++) {
					for (int l = j; l < m; l++) {

						// 겹치지 않을 때 maxSum 업데이트
						if (!isOverlap(x1, y1, x2, y2, i, j, k, l)) {
							int rectSum = rectSum(x1, y1, x2, y2) + rectSum(i, j, k, l);
							maxSum = Math.max(rectSum, maxSum);
						}
					}
				}
			}
		}

		return maxSum;
	}

	// 첫 번째 직사각형 잡아보기
	// (i, j) 와 (k, l)을 양 꼭짓점(대각선)으로 하여 사각형 잡기
	static int findMaxSum() {
		int maxSum = INT_MIN;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = i; k < n; k++) {
					for (int l = j; l < m; l++) {

						// 두 번째 직사각형 잡고 sum 업데이트
						int rectSum = findMaxSum(i, j, k, l);

						// updateMaxSum
						maxSum = Math.max(rectSum, maxSum);
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
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// simulate
		int maxSum = findMaxSum();

		// 출력
		System.out.println(maxSum);
	}
}

/*
 	해설

 	[Intuition]
 	두 직사각형을 전부 잡아서 겹치지 않는 경우 중 최대 합을 구합니다.
 	두 직사각형이 겹쳐지는지에 대한 여부는 새로운 배열을 이용하면 비교적 쉽게 계산할 수 있습니다.
 */

/*
	[Algorithm]
	가능한 모든 2개의 직사각형 쌍을 잡아보면서, 겹치지 않을 경우에만 두 직사각형 내 숫자들의 합을 구하여 최대 값을 갱신합니다.
	이때 두 직사각형이 겹쳐지는지에 대한 여부는, 격자에 각 직사각형 영역마다 1씩 증가시켜 숫자가 2 이상인 칸이 있는지를 확인하면 쉽게 구현이 가능합니다.
 */
 */
 */

import java.util.Scanner;

public class Main {
	public static final int INT_MIN = Integer.MIN_VALUE;
	public static final int MAX_NUM = 5;

	public static int n, m;
	public static int[][] grid = new int[MAX_NUM][MAX_NUM];
	public static int[][] board = new int[MAX_NUM][MAX_NUM];

	public static void clearBoard() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				board[i][j] = 0;
	}

	public static void draw(int x1, int y1, int x2, int y2) {
		for(int i = x1; i <= x2; i++)
			for(int j = y1; j <= y2; j++)
				board[i][j]++;
	}

	public static boolean checkBoard() {
		// 동일한 칸을 2개의 직사각형이 모두 포함한다면
		// 겹치게 됩니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(board[i][j] >= 2)
					return true;
		return false;
	}

	// (x1, y1), (x2, y2) 그리고
	// (x3, y3), (x4, y4) 로 이루어져있는
	// 두 직사각형이 겹치는지 확인하는 함수
	public static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		clearBoard();
		draw(x1, y1, x2, y2);
		draw(x3, y3, x4, y4);
		return checkBoard();
	}

	public static int rectSum(int x1, int y1, int x2, int y2) {
		int sumOfNums = 0;
		for(int i = x1; i <= x2; i++)
			for(int j = y1; j <= y2; j++)
				sumOfNums += grid[i][j];

		return sumOfNums;
	}

	// 첫 번째 직사각형이 (x1, y1), (x2, y2)를 양쪽 꼭지점으로 할 때
	// 두 번째 직사각형을 겹치지 않게 잘 잡아
	// 최대 합을 반환하는 함수
	public static int findMaxSum(int x1, int y1, int x2, int y2) {
		int maxSum = INT_MIN;

		// (i, j), (k, l)을 양쪽 꼭지점으로 하는
		// 두 번째 직사각형을 정하여
		// 겹치지 않았을 때 중
		// 최댓값을 찾아 반환합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				for(int k = i; k < n; k++)
					for(int l = j; l < m; l++) {
						if(!overlapped(x1, y1, x2, y2, i, j, k, l))
							maxSum = Math.max(maxSum,
								rectSum(x1, y1, x2, y2) +
									rectSum(i, j, k, l));
					}

		return maxSum;
	}

	// 두 직사각형을 잘 잡았을 때의 최대 합을 반환하는 함수
	public static int findMaxSum() {
		int maxSum = INT_MIN;

		// (i, j), (k, l)을 양쪽 꼭지점으로 하는
		// 첫 번째 직사각형을 정하여
		// 그 중 최댓값을 찾아 반환합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				for(int k = i; k < n; k++)
					for(int l = j; l < m; l++)
						maxSum = Math.max(maxSum,
							findMaxSum(i, j, k, l));
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		int ans = findMaxSum();
		System.out.print(ans);
	}
}