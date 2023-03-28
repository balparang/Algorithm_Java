import java.util.ArrayList;
import java.util.Scanner;

/**
 * 23.03.28
 * 불필요한 dir 비교
 */
class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	/*
		1. 움직이기 시도
		2. 이동할 후보지 선정(우선순위: 상하좌우)
			- inRange,
			- 현재 위치보다 숫자가 높고,
			- 상하좌우 방향 순서가 더 빠르고
		3. 이동할 후보지가 없다면(=움직이지 않았다면),  종료
	 */

	static final int MAX_N = 100;
	static final int DIR_NUM = 4;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
	static int n, r, c;
	static Pair currPos;

	static ArrayList<Integer> history = new ArrayList<>();

	public static boolean inRange(int x, int y) {
		return (x >= 1 && x <= n) && (y >= 1 && y <= n);
	}

	public static void move() {
		while (true) {
			int maxNum = 0;
			Pair maxPos = new Pair(-1, -1);
			int maxPosDir = DIR_NUM;

			int currNum = grid[currPos.x][currPos.y];

			// 이동할 후보지 찾기
			for (int dir = 0; dir < DIR_NUM; dir++) {
				int nx = currPos.x + dx[dir];
				int ny = currPos.y + dy[dir];
				int nextNum = grid[nx][ny];

				// 상하좌우가 이미 dx[], dy[] 로 표현되어있어 바로 이동하면 된다.
				if (inRange(nx, ny) && nextNum > currNum && dir < maxPosDir) {
					maxNum = nextNum;
					maxPos = new Pair(nx, ny);
					maxPosDir = dir;
				}
			}

			// 이동할 후보지가 없다면 종료
			if (maxNum == 0) {
				return;
			}

			// 후보지로 이동 & 이동 위치 기록
			currPos = maxPos;
			history.add(grid[currPos.x][currPos.y]);
		}
	}

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		currPos = new Pair(r, c);

		// grid
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		history.add(grid[currPos.x][currPos.y]);
		move();

		// output
		for (int x : history) {
			System.out.print(x + " ");
		}
	}
}

/**
 * 해설
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static final int DIR_NUM = 4;
	public static final int MAX_N = 100;

	public static int n;
	public static int currX, currY; // 현재 위치를 의미합니다.
	public static int[][] a = new int[MAX_N + 1][MAX_N + 1];

	// 방문하게 되는 숫자들을 담을 곳입니다.
	public static ArrayList<Integer> visitedNums = new ArrayList<>();

	// 범위가 격자 안에 들어가는지 확인합니다.
	public static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= n;
	}

	// 범위가 격자 안이고, 해당 위치의 값이 더 큰지 확인합니다.
	public static boolean canGo(int x, int y, int currNum) {
		return inRange(x, y) && a[x][y] > currNum;
	}

	// 조건에 맞춰 움직여봅니다.
	// 움직였다면 true를 반환하고
	// 만약 움직일 수 있는 곳이 없었다면 false를 반환합니다.
	public static boolean simulate() {
		int[] dx = new int[]{-1, 1,  0, 0};
		int[] dy = new int[]{ 0, 0, -1, 1};

		// 각각의 방향에 대해 나아갈 수 있는 곳이 있는지 확인합니다.
		for(int i = 0; i < 4; i++) {
			int nextX = currX + dx[i];
			int nextY = currY + dy[i];

			// 갈 수 있는 곳이라면
			// 이동하고 true를 반환합니다.
			if(canGo(nextX, nextY, a[currX][currY])) {
				currX = nextX;
				currY = nextY;
				return true;
			}
		}

		// 움직일 수 있는 곳이 없었다는 의미로
		// false 값을 반환합니다.
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력:
		n = sc.nextInt();
		currX = sc.nextInt();
		currY = sc.nextInt();

		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				a[i][j] = sc.nextInt();

		// 초기 위치에 적혀있는 값을 답에 넣어줍니다.
		visitedNums.add(a[currX][currY]);

		while(true) {
			// 조건에 맞춰 움직여봅니다.
			boolean greaterNumberExist = simulate();

			// 인접한 곳에 더 큰 숫자가 없다면 종료합니다.
			if(!greaterNumberExist)
				break;

			// 움직이고 난 후의 위치를 답에 넣어줍니다.
			visitedNums.add(a[currX][currY]);
		}

		// 출력:
		for(int i = 0; i < visitedNums.size(); i++)
			System.out.print(visitedNums.get(i) + " ");
	}
}