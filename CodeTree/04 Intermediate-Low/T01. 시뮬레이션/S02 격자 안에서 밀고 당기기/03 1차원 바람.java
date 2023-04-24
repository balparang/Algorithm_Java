import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WindInfo {
	int row;
	char dir;

	public WindInfo(int row, char dir) {
		this.row = row;
		this.dir = dir;
	}
}

public class Main {

	/*
	 	1. 시작행 push
	 	2. up 방향 push 시도
	 		- 기준행, 기준행 - 1 에 같은 숫자 존재하면 바람 방향 바꿔서 push
		3. down 방향 push 시도
			- 기준행, 기준행 + 1에 같은 숫자 존재하면 바람 방향 바꿔서 push
	 */

	static final int MAX_N = 100;
	static final char L = 'L'; // 바람이 왼쪽에서 불어온다. 오른쪽으로 push
	static final char R = 'R'; // 바람이 오른쪽에서 불어온다. 왼쪽으로 push

	static int N, M, Q; // N by M grid, Q번의 바람
	static List<WindInfo> windInfos = new ArrayList<>();

	static int[][] grid = new int[MAX_N][MAX_N];

	static void push(int row, char dir) {
		// if (row < 0 || row >= N) return false; // if index out of range
		if (dir == L) {
			int temp = grid[row][M - 1];

			for (int i = M - 1; i >= 1; i--) {
				grid[row][i] = grid[row][i - 1];
			}

			grid[row][0] = temp;
		} else { // dir = R
			int temp = grid[row][0];

			for (int i = 0; i <= M - 2; i++) {
				grid[row][i] = grid[row][i + 1];
			}

			grid[row][M - 1] = temp;
		}
	}

	static boolean sameNumberExists(int row1, int row2) {
		// 일치하는 숫자가 하나라도 있으면 true
		for (int col = 0; col < M; col++) {
			if (grid[row1][col] == grid[row2][col]) {
				return true;
			}
		}
		return false;
	}

	static char changeDir(char windDir) {
		return windDir == L ? R : L;
	}

	static void waveUp(int startRow, char prevDir) {
		char windDir = prevDir;

		for (int row = startRow; row >= 1; row--) {
			if (sameNumberExists(row, row - 1)) {
				windDir = changeDir(windDir);
				push(row - 1, windDir);
				continue;
			}
			return;
		}
	}

	static void waveDown(int startRow, char prevDir) {
		char windDir = prevDir;

		for (int row = startRow; row <= N - 2; row++) {
			if (sameNumberExists(row, row + 1)) {
				windDir = changeDir(windDir);
				push(row + 1, windDir);
				continue;
			}
			return;
		}
	}

	static void simulate(int startRow, char dir) {
		push(startRow, dir);
		waveUp(startRow, dir);
		waveDown(startRow, dir);
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Q = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < Q; i++) { // 바람 정보
			int startRow = sc.nextInt() - 1;
			char dir = sc.next().charAt(0);

			windInfos.add(new WindInfo(startRow, dir));
		}

		// 바람 개수 만큼 simulate
		for (WindInfo info : windInfos) {
			simulate(info.row, info.dir);
		}

		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}

import java.util.Scanner;

public class Main {
	public static final int SHIFT_LEFT = 1;
	public static final int SHIFT_RIGHT = 0;
	public static final int MAX_M = 100;
	public static final int MAX_N = 100;

	// 전역 변수 선언:
	public static int n, m, q;

	public static int[][] a = new int[MAX_N + 1][MAX_M + 1];

	// row 줄의 원소들을 dir 방향에 따라 한 칸 밀어줍니다.
	// dir이 0인 경우 오른쪽으로
	// dir이 1인 경우 왼쪽으로 밀어야 합니다.
	public static void shift(int row, int dir) {
		// 오른쪽으로 밀어야 하는 경우
		if(dir == SHIFT_RIGHT) {
			int temp = a[row][m];
			for(int col = m; col >= 2; col--)
				a[row][col] = a[row][col - 1];
			a[row][1] = temp;
		}
		// 왼쪽으로 밀어야 하는 경우
		else {
			int temp = a[row][1];
			for(int col = 1; col <= m - 1; col++)
				a[row][col] = a[row][col + 1];
			a[row][m] = temp;
		}
	}

	// row1, row2 행에 대해 같은 열에 같은 숫자를 갖는 경우가
	// 있는지를 찾아줍니다.
	public static boolean hasSameNumber(int row1, int row2) {
		for(int col = 1; col <= m; col++)
			if(a[row1][col] == a[row2][col])
				return true;

		return false;
	}

	// 주어진 방향으로부터 반대 방향의 값을 반환합니다.
	public static int flip(int dir) {
		return (dir == SHIFT_LEFT) ? SHIFT_RIGHT : SHIFT_LEFT;
	}

	// 조건에 맞춰 움직여봅니다.
	// dir이 SHIFT_RIGHT 인 경우 오른쪽으로
	// dir이 SHIFT_LEFT 인 경우 왼쪽으로 밀어야 합니다.
	public static void simulate(int startRow, int startDir) {
		// Step1
		// 바람이 처음으로 불어 온 행의 숫자들을 해당 방향으로 밀어줍니다.
		shift(startRow, startDir);

		// 그 이후부터는 반전된 방향에 영향을 받으므로, 방향을 미리 반전 시켜줍니다.
		startDir = flip(startDir);

		// Step2
		// 위 방향으로 전파를 계속 시도해봅니다.
		for(int row = startRow, dir = startDir; row >= 2; row--) {
			// 인접한 행끼리 같은 숫자를 가지고 있다면
			// 위의 행을 한 칸 shift하고
			// 방향을 반대로 바꿔 계속 전파를 진행합니다.
			if(hasSameNumber(row, row - 1)) {
				shift(row - 1, dir);
				dir = flip(dir);
			}
			// 같은 숫자가 없다면 전파를 멈춥니다.
			else
				break;
		}

		// Step3
		// 아래 방향으로 전파를 계속 시도해봅니다.
		for(int row = startRow, dir = startDir; row <= n - 1; row++) {
			// 인접한 행끼리 같은 숫자를 가지고 있다면
			// 아래 행을 한 칸 shift하고
			// 방향을 반대로 바꿔 계속 전파를 진행합니다.
			if(hasSameNumber(row, row + 1)) {
				shift(row + 1, dir);
				dir = flip(dir);
			}
			// 같은 숫자가 없다면 전파를 멈춥니다.
			else
				break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();

		for(int row = 1; row <= n; row++)
			for(int col = 1; col <= m; col++)
				a[row][col] = sc.nextInt();

		while(q-- > 0) {
			int r;
			char d;
			r = sc.nextInt();
			d = sc.next().charAt(0);

			// 조건에 맞춰 움직여봅니다.
			simulate(r, d == 'L' ? SHIFT_RIGHT : SHIFT_LEFT);
		}

		// 출력:
		for(int row = 1; row <= n; row++) {
			for(int col = 1; col <= m; col++)
				System.out.print(a[row][col] + " ");
			System.out.println();
		}
	}
}

