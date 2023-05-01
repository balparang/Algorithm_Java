/**
 * 23.03.26
 * BFS 탐색, 메모리 초과
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	/*
		1. 시작점마다 BFS로 탐색하면서 answer 에 기록
			- visited 초기화 (visited는 공유하지 않음)
		2. answer sheet 에 0이 아닌 개수 카운팅
	 */

	static final int MAX_N = 100;
	static final int DIR_NUM = 4;
	static int n, k;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static List<Pair> starts = new ArrayList<>();
	static int[][] grid = new int[MAX_N][MAX_N];
	static boolean[][] visited = new boolean[MAX_N][MAX_N];
	static boolean[][] answer = new boolean[MAX_N][MAX_N];

	static Queue<Pair> q = new LinkedList<>();

	// init visited
	static void initVisited() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}

	// push
	static void push(int x, int y) {
		visited[x][y] = true;
		answer[x][y] = true;
		q.add(new Pair(x, y));
	}

	// inRange
	static boolean inRange(int x, int y) {
		return (x >= 0 && x < n) && (y >= 0 && y < n);
	}

	// canGo: is inRange & not visited & no wall
	static boolean canGo(int x, int y) {
		return inRange(x, y) && !visited[x][y] && grid[x][y] != 1;
	}

	// BFS
	static void BFS() {
		while (!q.isEmpty()) {
			// set currV
			Pair currV = q.poll();

			// for children of currV
			for (int i = 0; i < DIR_NUM; i++) {
				int nx = currV.x + dx[i];
				int ny = currV.y + dy[i];

				if (canGo(nx, ny)) {
					push(nx, ny);
				}
			}
		}
	}

	// searchByStart
	static void searchByStart() {
		for (Pair start : starts) {
			// init
			initVisited();

			// search
			push(start.x, start.y);
			BFS();
		}
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			starts.add(new Pair(r - 1, c - 1)); // 1행 1열 -> grid[0][0]
		}

		// run
		searchByStart();

		// 출력
		int visitableNums = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (answer[i][j]) {
					visitableNums++;
				}
			}
		}

		System.out.println(visitableNums);
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
	public static final int DIR_NUM = 4;
	public static final int MAX_N = 100;

	// 전역 변수 선언:
	public static int n, k;
	public static int[][] grid = new int[MAX_N][MAX_N];

	// bfs에 필요한 변수들 입니다.
	public static Queue<Pair> bfsQ = new LinkedList<>();
	public static boolean[][] visited = new boolean[MAX_N][MAX_N];

	public static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	public static boolean canGo(int x, int y) {
		return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
	}

	public static void BFS() {
		// queue에 남은 것이 없을때까지 반복합니다.
		while (!bfsQ.isEmpty()) {
			// queue에서 가장 먼저 들어온 원소를 뺍니다.
			Pair currPos = bfsQ.poll();
			int x = currPos.x, y = currPos.y;

			int[] dx = new int[] {1, -1, 0, 0};
			int[] dy = new int[] {0, 0, 1, -1};

			// queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
			for (int dir = 0; dir < DIR_NUM; dir++) {
				int nx = x + dx[dir], ny = y + dy[dir];

				// 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
				// 새로 queue에 넣어주고 방문 여부를 표시해줍니다.
				if (canGo(nx, ny)) {
					bfsQ.add(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력:
		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		// 시작점을 모두 bfs queue에 넣습니다.
		while (k-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			bfsQ.add(new Pair(x - 1, y - 1));
			visited[x - 1][y - 1] = true;
		}

		// bfs를 진행합니다.
		BFS();

		int ans = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (visited[i][j])
					ans++;

		System.out.print(ans);
	}
}