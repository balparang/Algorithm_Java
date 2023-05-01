/**
 * 풀이
 */

import java.util.*;

public class Main {

    /*
        - 인접한 숫자가 있으면 블럭으로 본다.
        - 터지게 되는 블럭수, 최대 블럭 크기

        모든 시작 노드에 대해 DFS 시도
        시작 노드가 visit 상태가 아니면 블록 개수 증가
            시작 노드를 기준으로 DFS 시작
            DFS 로 인접한 숫자 카운팅(블록 사이즈 증가)
            최대 블록 사이즈 갱신
    */

	static final int MAX_N = 100;
	static final int DIR_NUM = 4;

	static int[][] grid = new int[MAX_N][MAX_N];
	static boolean[][] visited = new boolean[MAX_N][MAX_N];
	static int[] dx = {0, 1, 0 , -1};
	static int[] dy = {1, 0, -1, 0};

	static int n;
	static int blockSize, maxBlockSize;
	static int boomNum;

	// inRange
	static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	// canGo
	static boolean canGo(int x, int y, int currNum) {
		// inRange & notVisited & hasSameNumber
		return inRange(x, y) && !visited[x][y] && grid[x][y] == currNum;
	}

	// DFS
	static void DFS(int x, int y) {

		// for children of node
		for (int i = 0; i < DIR_NUM; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (canGo(nx, ny, grid[x][y])) {
				blockSize++;
				visited[nx][ny] = true;
				DFS(nx, ny);
			}
		}
	}

	// simulate
	static void simulate() {
		// 모든 시작 노드에 대해 DFS 시도
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (visited[i][j]) continue;

				// not visited
				blockSize = 1;
				visited[i][j] = true;

				DFS(i, j);

				if (blockSize >= 4)
					boomNum++;

				maxBlockSize = Math.max(maxBlockSize, blockSize);
			}
		}
	}

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		// simulate
		simulate();

		// output
		System.out.println(boomNum + " " + maxBlockSize);
	}
}

/**
 * 해설
 */

import java.util.Scanner;

public class Main {
	public static final int DIR_NUM = 4;
	public static final int MAX_NUM = 100;

	public static int n;
	public static int[][] grid = new int[MAX_NUM][MAX_NUM];
	public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

	public static int maxBlock;
	public static int bombCnt;

	public static int currBlockNum;

	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
	public static boolean canGo(int x, int y, int color) {
		if(!inRange(x, y))
			return false;

		if(visited[x][y] || grid[x][y] != color)
			return false;

		return true;
	}

	public static void DFS(int x, int y) {
		//0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
		int[] dx = new int[]{0, 1, 0, -1};
		int[] dy = new int[]{1, 0, -1, 0};

		// 네 방향에 각각에 대하여 DFS 탐색을 합니다.
		for(int dir = 0; dir < DIR_NUM; dir++) {
			int newX = x + dx[dir];
			int newY = y + dy[dir];

			if(canGo(newX, newY, grid[x][y])){
				visited[newX][newY] = true;
				// 블럭이 하나 추가됩니다.
				currBlockNum++;
				DFS(newX, newY);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		// 격자의 각 위치에서 탐색을 시작할 수 있는 경우
		// 한 블럭에 대한 DFS 탐색을 수행합니다.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && grid[i][j] > 0) {
					// 해당 블럭을 방문할 수 있는 경우 visited 배열을 갱신하고
					// 새로운 블럭을 탐색한다는 의미로 currBlockNum을 1으로 갱신합니다.
					visited[i][j] = true;
					currBlockNum = 1;

					DFS(i, j);

					// 한 블럭 묶음에 대한 탐색이 끝난 경우 답을 갱신합니다.
					if(currBlockNum >= 4)
						bombCnt++;

					maxBlock = Math.max(maxBlock, currBlockNum);
				}
			}
		}

		System.out.print(bombCnt + " " + maxBlock);
	}
}