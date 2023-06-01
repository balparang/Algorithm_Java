/*
	23.06.01
	- currPos, nextPos를 이용하여 next값을 curr에 대입하면서 한 칸씩 당겨온다.
	- 당김이 끝나면 curr을 next로 갱신
 */
import java.util.Scanner;

public class Main {

	static final int MAX_N = 100;
	static final int DIR_NUM = 4;

	static int n;
	static int r, c, m1, m2, m3, m4, dir;

	// 방향마다 이동해야할 횟수 {0, m1, m2, m3, m4}
	static int[] moveNum;

	static int[][] grid = new int[MAX_N][MAX_N];

	// rotate clock direction
	static void rotateClock() {

		int[] dx = {0, -1, -1, 1, 1};
		int[] dy = {0, 1, -1, -1, 1};

		int tmp = grid[r][c];
		int cx = r, cy = c; // currPos

		// 방향 1~4 순회하며 한 칸씩 로테이트
		for (int d = 1; d <= DIR_NUM; d++) {
			int numToMove = moveNum[d];

			for (int move = 0; move < numToMove; move++) {
				// copy Number
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				grid[cx][cy] = grid[nx][ny];

				// move currPos to next
				cx = nx;
				cy = ny;
			}
		}

		// use tmp near (r, c)
		grid[r - 1][c - 1] = tmp;
	}

	// rotate anti clock direction
	static void rotateAntiClock() {

		int[] dx = {0, 1, 1, -1, -1};
		int[] dy = {0, -1, 1, 1, -1};

		int tmp = grid[r][c];
		int cx = r, cy = c; // currPos

		// 방향 4~1 순회하며 한 칸씩 로테이트
		for (int d = DIR_NUM; d >= 1; d--) {
			int numToMove = moveNum[d];

			for (int move = 0; move < numToMove; move++) {
				// copy Number
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				grid[cx][cy] = grid[nx][ny];

				// move currPos to next
				cx = nx;
				cy = ny;
			}
		}

		// use tmp near (r, c)
		grid[r - 1][c + 1] = tmp;
	}

	// simulate
	static void simulate() {
		if (dir == 1) { // dir 1이면 시계 회전, 0이면 반시계 회전
			rotateClock();
			return;
		}
		rotateAntiClock();
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		r = sc.nextInt() - 1; // r행 c열 -> grid[r][c] 인덱스로 활용
		c = sc.nextInt() - 1;

		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		m4 = sc.nextInt();
		moveNum = new int[]{0, m1, m2, m3, m4};

		dir = sc.nextInt();

		// rotate
		simulate();

		// 출력
		print(grid);
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

/*
	해설
	- 움직이는 첫 방향을 DIR = 0 으로 설정하고 m1, m2를 그에 맞춰 배치
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static final int CW = 1;
	public static final int CCW = 0;
	public static final int DIR_NUM = 4;
	public static final int MAX_N = 100;

	public static int n;
	public static int[][] grid = new int[MAX_N][MAX_N];
	public static int[][] temp = new int[MAX_N][MAX_N];

	public static void shift(int x, int y, int k, int l, int moveDir) {
		ArrayList<Integer> dx = new ArrayList<>();
		ArrayList<Integer> dy = new ArrayList<>();
		ArrayList<Integer> moveNums = new ArrayList<>();

		if(moveDir == CCW) {
			dx = new ArrayList<>(Arrays.asList(-1, -1, 1, 1));
			dy = new ArrayList<>(Arrays.asList(1, -1, -1, 1));
			moveNums = new ArrayList<>(Arrays.asList(k, l, k, l));
		}
		else {
			dx = new ArrayList<>(Arrays.asList(-1, -1, 1, 1));
			dy = new ArrayList<>(Arrays.asList(-1, 1, 1, -1));
			moveNums = new ArrayList<>(Arrays.asList(l, k, l, k));
		}

		// Step1. temp 배열에 grid 값을 복사합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				temp[i][j] = grid[i][j];

		// Step2. 기울어진 직사각형의 경계를 쭉 따라가면서
		//        숫자를 한 칸씩 밀었을 때의 결과를
		//        temp에 저장합니다.
		for(int d = 0; d < DIR_NUM; d++)
			for(int q = 0; q < moveNums.get(d); q++) {
				int nx = x + dx.get(d), ny = y + dy.get(d);
				temp[nx][ny] = grid[x][y];
				x = nx; y = ny;
			}

		// Step3. temp값을 grid에 옮겨줍니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = temp[i][j];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int x, y, m1, m2, m3, m4, d;
		x = sc.nextInt();
		y = sc.nextInt();
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		m4 = sc.nextInt();
		d = sc.nextInt();

		shift(x - 1, y - 1, m1, m2, d);

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
	}
}