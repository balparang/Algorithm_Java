/*
	1. 모든 직사각형 잡아보면서,
	2. 잡은 직사각형 내부에 음수가 없으면 size 계산 & maxSize 갱신
*/
import java.util.*;

public class Main {

    /*
        1. 모든 직사각형 잡아보면서,
        2. 잡은 직사각형 내부에 음수가 없으면 size 계산 & maxSize 갱신
    */

	static final int MAX_N = 20;

	static int n, m; // n by m grid
	static int[][] grid = new int[MAX_N][MAX_N];

	static int calcSize(int x1, int y1, int x2, int y2) {
		return (x2 - x1 + 1) * (y2 - y1 + 1);
	}

	// negativeNumExists
	static boolean zeroOrNegNumExists(int x1, int y1, int x2, int y2) {

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				// 0 또는 음수 존재시 true 리턴
				if (grid[i][j] <= 0) {
					return true;
				}
			}
		}

		return false;
	}

	// find positive Rect
	static int findMaxSize() {
		int maxSize = -1;

		// (i, j)~(k, l) 을 양 꼭짓점으로 하는 Rect
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = i; k < n; k++) {
					for (int l = j; l < m; l++) {
						// rect 가 양수로만 이루어진 경우 maxSize 갱신
						if (!zeroOrNegNumExists(i, j, k, l)) {
							int size = calcSize(i, j, k, l);
							maxSize = Math.max(size, maxSize);
						}
					}
				}
			}
		}

		return maxSize;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		// simulate
		int maxSize = findMaxSize();

		// 출력
		System.out.println(maxSize);
	}
}

/*
	해설 1: 완전탐색

	직사각형을 그 직사각형의 가장 왼쪽 위의 칸의 index와 가장 오른쪽 아래 칸의 index로 나타내면 쉽게 나타낼 수 있습니다.
 	모든 가능한 직사각형을 순회하며 각각의 직사각형이 양수 직사각형인지 판별하고 크기를 계산하여 최대 크기를 찾습니다.

 	---

 	모든 좌표((0,0)부터 (n-1, m-1)까지)를 순회하며 직사각형의 좌상단점을 정합니다.
 	그 점을 (i, j)라고 했을 때, 다시 (i,j)부터 (n-1, m-1)까지를 우하단점으로 정하고,
 	그렇게 정의하여 만들어진 직사각형이 양수 직사각형인지 판단하고 최대 크기를 갱신합니다.
 */
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 20;

	public static int n, m;
	public static int[][] grid = new int[MAX_NUM][MAX_NUM];

	// (x1, y1), (x2, y2)를 두 꼭지점으로 하는
	// 직사각형에 있는 값이 전부 양수인지 판단합니다.
	public static boolean positiveRect(int x1, int y1, int x2, int y2) {
		for(int i = x1; i <= x2; i++)
			for(int j = y1; j <= y2; j++)
				if(grid[i][j] <= 0)
					return false;

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		int ans = -1;

		// 직사각형의 양쪽 두 꼭지점 (i, j), (k, l)
		// 를 정하여
		// 해당 직사각형안에 있는 값이 전부 양수일 때만
		// 크기를 갱신합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				for(int k = i; k < n; k++)
					for(int l = j; l < m; l++)
						if(positiveRect(i, j, k, l))
							ans = Math.max(ans,
								(k - i + 1) * (l - j + 1));

		System.out.print(ans);
	}
}

/*
	해설 2: 전처리 + 완전 탐색

	다음 정의에 맞는 배열 값을 전처리 과정을 통해 O(NM)에 계산합니다.

	정의: "down-max[i][j] = (i, j)을 시작으로 밑으로 쭉 내려가며,
         만들 수 있는 가로가 1인 직사각형 중 최대 직사각형의 크기"

    이 값을 이용하면 완전탐색의 시간복잡도를 O(NM^2))으로 줄일 수 있습니다.
 */
import java.util.Scanner;

public class Main {
	public static final int INT_MIN = Integer.MIN_VALUE;
	public static final int INT_MAX = Integer.MAX_VALUE;
	public static final int MAX_NUM = 20;

	public static int n, m;
	public static int[][] grid = new int[MAX_NUM][MAX_NUM];
	// downMax[i][j] : (i, j)을 시작으로 밑으로 쭉 내려가며
	//                 만들 수 있는 가로가 1인 직사각형 중 최대 직사각형의 크기
	public static int[][] downMax = new int[MAX_NUM][MAX_NUM];

	// downMax 값을 계산합니다.
	public static void preProcessing() {
		// 마지막 행에 대해 계산합니다.
		for(int j = 0; j < m; j++)
			if(grid[n - 1][j] > 0)
				downMax[n - 1][j] = 1;

		for(int i = n - 2; i >= 0; i--) {
			for(int j = 0; j < m; j++) {
				// (i, j)에 적혀있는 수가 양수라면
				// 이전 최대 직사각형의 크기에 1을 더한 만큼 가능합니다.
				if(grid[i][j] > 0)
					downMax[i][j] = downMax[i + 1][j] + 1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		// downMax 값을 계산합니다.
		preProcessing();

		int ans = INT_MIN;

		// 직사각형의 좌측 상단 꼭지점 (i, j)를 정한 뒤
		// 우측 하단 지점의 열 l를 결정해보며
		// 그때까지 최대로 가능한 k을 계산합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				// (downMax[i][j], downMax[i][j + 1], .... , downMax[i][l]) 중에
				// 최솟값이 결국 가능한 양수 직사각형의 최대 높이가 됩니다.
				int bestHeight = INT_MAX;
				for(int l = j; l < m; l++) {
					bestHeight = Math.min(bestHeight, downMax[i][l]);

					// 넓이를 계산하여 갱신합니다.
					int k = i + bestHeight - 1;
					ans = Math.max(ans, (k - i + 1) * (l - j + 1));
				}
			}

		if(ans <= 0)
			ans = -1;

		System.out.print(ans);
	}
}