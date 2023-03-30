/**
 * 23.03.30
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	/*
		0. move 시작
		1. 시작점 마다 갈 수 있는 후보지 탐색 (BFS)
			- 탐색하면서 우선순위에 따라 후보지 갱신
		2. 후보지가 있으면 그곳으로 현재 위치 갱신
			- 없으면 움직임 횟수가 남아있더라도 시뮬레이션 종료
		3. 현재 위치 출력
	 */

	static final int MAX_N = 100;
	static final int DIR_NUM = 4;

	static int n, k;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
	static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
	static Queue<Pair> bfsQ = new LinkedList<>();
	static Pair currPos = new Pair(-1, -1);
	static int currPosNum = 0;
	static Pair candi = new Pair(-1, -1);
	static int candiNum = 0;

	static void initVisited() {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				visited[i][j] = false;
	}

	static boolean inRange(int x, int y) {
		return (x >= 1 && x <= n) && (y >= 1 && y <= n);
	}

	static boolean canGo(int x, int y) {
		// inRange && not visited &&  nextVNum is lower than startNum
		return inRange(x, y) && !visited[x][y] && grid[x][y] < grid[currPos.x][currPos.y];
	}

	static void push(int x, int y) {
		visited[x][y] = true;
		bfsQ.add(new Pair(x, y));
	}

	static void tryUpdateCandi(int x, int y) {
		// bigger than candiNum
		if (grid[x][y] < candiNum)
			return;

		if (grid[x][y] > candiNum) {
			updateCandi(x, y, grid[x][y]);
			return;
		}

		// candiNum = targetNum
		// 행이 더 크다면 업데이트 불가
		if (x > candi.x)
			return;

		if (x < candi.x) { // 행이 더 작으면 업데이트 가능
			updateCandi(x, y, grid[x][y]);
			return;
		}

		// 같은 행이라면 열이 더 작아야 업데이트 가능
		if (y < candi.y) {
			updateCandi(x, y, grid[x][y]);
		}
	}

	static void updateCandi(int x, int y, int gridNum) {
		candi.set(x, y);
		candiNum = gridNum;
	}

	static void BFS() {
		while (!bfsQ.isEmpty()) {
			Pair currV = bfsQ.poll();

			for (int i = 0; i < DIR_NUM; i++) {
				int nx = currV.x + dx[i];
				int ny = currV.y + dy[i];

				if (canGo(nx, ny)) {
					tryUpdateCandi(nx, ny);
					push(nx, ny);
				}
			}
		}
	}

	static boolean tryMove() {
		// init candidate
		updateCandi(-1, -1, 0);

		BFS();

		// no where to go
		if (candi.x == -1 && candi.y == -1)
			return false;

		// can go, move currV
		currPos.x = candi.x;
		currPos.y = candi.y;
		return true;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// start row, col
		currPos.x = sc.nextInt();
		currPos.y = sc.nextInt();

		while (k-- > 0) {
			initVisited();
			push(currPos.x, currPos.y);

			boolean isMoved = tryMove();

			if (!isMoved)
				break;
		}

		// 출력
		System.out.println(currPos.x + " " + currPos.y);
	}
}

/**
 * 해설
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static final Pair NOT_EXISTS = new Pair(-1, -1);
	public static final int DIR_NUM = 4;
	public static final int MAX_N = 100;

	public static int n, k;

	public static int[][] grid = new int[MAX_N][MAX_N];

	// 현재 위치
	public static Pair currCell;

	public static Queue<Pair> bfsQ = new LinkedList<>();
	public static boolean[][] visited = new boolean[MAX_N][MAX_N];

	public static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	public static boolean canGo(int x, int y, int targetNum) {
		return inRange(x, y) && !visited[x][y] &&
			grid[x][y] < targetNum;
	}

	// visited 배열을 초기화 해줍니다.
	public static void initializeVisited() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				visited[i][j] = false;
	}

	public static void BFS() {
		int[] dx = new int[] {0, 1, 0, -1};
		int[] dy = new int[] {1, 0, -1, 0};

		int cX = currCell.x;
		int cY = currCell.y;
		visited[cX][cY] = true;
		bfsQ.add(currCell);

		int targetNum = grid[cX][cY];

		// BFS 탐색을 수행합니다.
		while (!bfsQ.isEmpty()) {
			Pair currPos = bfsQ.poll();
			int currX = currPos.x;
			int currY = currPos.y;

			for (int i = 0; i < DIR_NUM; i++) {
				int newX = currX + dx[i];
				int newY = currY + dy[i];

				if (canGo(newX, newY, targetNum)) {
					bfsQ.add(new Pair(newX, newY));
					visited[newX][newY] = true;
				}
			}
		}
	}

	// best 위치를 새로운 위치로 바꿔줘야 하는지를 판단합니다.
	public static boolean needUpdate(Pair bestPos, Pair newPos) {
		// 첫 도달 가능한 위치라면
		// update가 필요합니다.
		if (bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y)
			return true;

		int bestX = bestPos.x;
		int bestY = bestPos.y;

		int newX = newPos.x;
		int newY = newPos.y;

		// 숫자, -행, -열 순으로 더 큰 곳이 골라져야 합니다.
		if (grid[newX][newY] != grid[bestX][bestY])
			return grid[newX][newY] > grid[bestX][bestY];
		if (-newX != -bestX)
			return -newX > -bestX;
		return -newY > -bestY;
	}

	// 가장 우선순위가 높은 위치를 찾아
	// 위치를 이동합니다.
	public static boolean move() {
		// BFS 탐색을 위한 초기화 작업을 수행합니다.
		initializeVisited();

		// Step1. BFS를 진행하여 갈 수 있는 모든 위치를 탐색합니다.
		BFS();

		// Step2.
		// 도달 할 수 있는 위치들 중
		// 가장 우선순위가 높은 위치를 구합니다.
		Pair bestPos = NOT_EXISTS;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				// 도달이 불가능하거나 현재 위치는 건너뜁니다.
				if (!visited[i][j] ||
					i == currCell.x && j == currCell.y)
					continue;

				Pair newPos = new Pair(i, j);
				if (needUpdate(bestPos, newPos))
					bestPos = newPos;
			}

		// Step3. 위치를 이동합니다.

		// 만약 움직일 위치가 없다면 종료합니다.
		if (bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y)
			return false;
			// 움직일 위치가 있다면 이동합니다.
		else {
			currCell = bestPos;
			return true;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		// 초기 위치를 설정합니다.
		int r = sc.nextInt();
		int c = sc.nextInt();
		currCell = new Pair(r - 1, c - 1);

		// k번에 걸쳐 움직이는 것을 반복합니다.
		while (k-- > 0) {
			boolean isMoved = move();

			// 움직이지 못했다면 바로 종료합니다.
			if (!isMoved)
				break;
		}

		int finalX = currCell.x;
		int finalY = currCell.y;

		System.out.print((finalX + 1) + " " + (finalY + 1));
	}
}