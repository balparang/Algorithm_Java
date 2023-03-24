/**
 * 23.03.24
 */
public class Main {

	/*
		1. DFS 로 visited[][] 에 방문기록 남기기
		2. 우측하단 인덱스에 방문기록 남았는지 확인
	*/
	static final int MAX_N = 100;
	static final int MAX_M = 100;
	static final int MAX_DIR_NUM = 1;
	static int n, m;
	static int[][] grid = new int[MAX_N][MAX_M]; // input grid. if grid[x][y] = 0 then snake exists
	static boolean[][] visited = new boolean[MAX_N][MAX_M];
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		// 그리드 정보 생성
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		// 시작점 방문 처리
		visited[0][0] = true;
		DFS(0, 0);

		// 출력
		System.out.println(getAnswer());
	}

	public static void DFS(int x, int y) {

		for (int i = 0; i <= MAX_DIR_NUM; i++) {

			int nx = x + dx[i];
			int ny = y + dy[i];

			if (canGo(nx, ny)) {
				visited[nx][ny] = true;
				DFS(nx, ny);
			}
		}
	}

	public static boolean canGo(int x, int y) {

		if (!inRange(x, y)) {
			return false;
		}

		// already visited or snake exists
		if (visited[x][y] || grid[x][y] == 0) {
			return false;
		}

		return true;
	}

	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < n) && (y >= 0 && y < m);
	}

	public static int getAnswer() {

		if (visited[n - 1][m - 1]) {
			return 1;
		}

		return 0;
	}
}

/**
 * 해설
 */
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 100;
	public static final int DIR_NUM = 2;

	public static int n, m;
	public static int[][] grid = new int[MAX_NUM][MAX_NUM];
	public static int[][] visited = new int[MAX_NUM][MAX_NUM];

	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	public static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
	public static boolean canGo(int x, int y) {
		if (!inRange(x, y))
			return false;
		if (visited[x][y] == 1 || grid[x][y] == 0)
			return false;
		return true;
	}

	public static void DFS(int x, int y) {
		int[] dx = new int[] {1, 0};
		int[] dy = new int[] {0, 1};

		// 아래쪽과 오른쪽 각각에 대하여 DFS 탐색을 합니다.
		for (int i = 0; i < DIR_NUM; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (canGo(newX, newY)) {
				visited[newX][newY] = 1;
				DFS(newX, newY);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();

		visited[0][0] = 1;
		DFS(0, 0);

		System.out.println(visited[n - 1][m - 1]);
	}
}