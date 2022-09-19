// Try 1 - fail: 문제 오독. 이길 수 있는 승리 가짓수가 아니라, 이길 수 있는 '팀의 개수'
/*  Test Case
    111
    555
    111
    정답 : 1 / 나의 출력: 5
 */

import java.util.Scanner;

public class Main {
    static final int SIZE = 3;
    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < SIZE; i++) {
            String strNum = sc.next();
            String[] numArr = strNum.split("");

            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(numArr[j]);
            }
        }

        // 모든 (A, B) 쌍에 대하여 점수 계산.  1 <= A, B <= 9
        int totalScore = 0;

        for (int A = 1; A <= 9; A++) {
            int score;

            for (int B = A + 1; B <= 9; B++) {
                score = calcScore(A, B);
                totalScore += score;
            }
        }

        // 출력
        System.out.println(totalScore);
    }


    private static int calcScore(int A, int B) {
        // (A, B) 의 점수 계산
        int score = 0;

        // case 1: 행에 대해 승리 (3가지)
        for (int row = 0; row < SIZE; row++) {
            int cntA = 0, cntB = 0;

            // 현재 row에서 승리했는지 확인
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == A) cntA++;
                if (board[row][col] == B) cntB++;
            }

            if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
                score++;
            }
        }

        // case 2: 열에 대해 승리 (3가지)
        for (int col = 0; col < SIZE; col++) {
            int cntA = 0, cntB = 0;

            // 현재 col에서 승리했는지 확인
            for (int row = 0; row < SIZE; row++) {
                if (board[row][col] == A) cntA++;
                if (board[row][col] == B) cntB++;
            }

            if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
                score++;
            }
        }

        // case 3: 대각선에 대해 승리 (2가지)
        // 좌상 우하 대각선
        int cntA = 0, cntB = 0;

        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] == A) cntA++;
            if (board[i][i] == B) cntB++;
        }

        if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
            score++;
        }

        // 우상 좌하 대각선
        cntA = 0;
        cntB = 0;

        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] == A) cntA++;
            if (board[i][SIZE - 1 - i] == B) cntB++;
        }

        if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
            score++;
        }

        return score;
    }
}

// Try 2 - pass
import java.util.Scanner;

public class Main {
    static final int SIZE = 3;
    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < SIZE; i++) {
            String strNum = sc.next();
            String[] numArr = strNum.split("");

            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(numArr[j]);
            }
        }

        // 모든 (A, B) 쌍에 대하여 점수 계산.  1 <= A, B <= 9
        int teamCnt = 0;

        for (int A = 1; A <= 9; A++) {
            for (int B = A + 1; B <= 9; B++) {
                if (isWinningTeam(A, B)) {
                    teamCnt++;
                }
            }
        }

        // 출력
        System.out.println(teamCnt);
    }

    private static boolean isWinningTeam(int A, int B) {
        // (A, B) 의 점수 계산
        int score = 0;

        // case 1: 행에 대해 승리 (3가지)
        for (int row = 0; row < SIZE; row++) {
            int cntA = 0, cntB = 0;

            // 현재 row에서 승리했는지 확인
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == A) cntA++;
                if (board[row][col] == B) cntB++;
            }

            if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
                return true;
            }
        }

        // case 2: 열에 대해 승리 (3가지)
        for (int col = 0; col < SIZE; col++) {
            int cntA = 0, cntB = 0;

            // 현재 col에서 승리했는지 확인
            for (int row = 0; row < SIZE; row++) {
                if (board[row][col] == A) cntA++;
                if (board[row][col] == B) cntB++;
            }

            if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
                return true;
            }
        }

        // case 3: 대각선에 대해 승리 (2가지)
        // 좌상 우하 대각선
        int cntA = 0, cntB = 0;

        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] == A) cntA++;
            if (board[i][i] == B) cntB++;
        }

        if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
            return true;
        }

        // 우상 좌하 대각선
        cntA = 0;
        cntB = 0;

        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] == A) cntA++;
            if (board[i][SIZE - 1 - i] == B) cntB++;
        }

        if (cntA != SIZE && cntB != SIZE && cntA + cntB == SIZE) {
            return true;
        }

        return false;
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static final int MAX_X = 9;
    public static final int MAX_A = 3;

    public static String[] inp = new String[MAX_A];
    public static int[][] board = new int[MAX_A][MAX_A];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        for (int i = 0; i < MAX_A; i++)
            inp[i] = sc.next();

        for (int i = 0; i < MAX_A; i++)
            for (int j = 0; j < MAX_A; j++)
                board[i][j] = inp[i].charAt(j) - '0';

        int ans = 0;

        // 모든 쌍에 대해 전부 시도해 봅니다.
        for (int i = 1; i <= MAX_X; i++)
            for (int j = i + 1; j <= MAX_X; j++) {
                // i, j 두 명이 팀이 됐을 때 이길 수 있는지를 확인합니다.
                // win : 두 명이 팀이 됐을 때 이길 수 있다면 true
                boolean win = false;

                // numI , numJ : 각 줄에 i, j가 나오는 개수
                int numI = 0, numJ = 0;

                // 가로로 빙고가 만들어질 때
                for (int k = 0; k < MAX_A; k++) {
                    numI = 0;
                    numJ = 0;
                    for (int l = 0; l < MAX_A; l++) {
                        if (board[k][l] == i)
                            numI++;
                        if (board[k][l] == j)
                            numJ++;
                    }

                    // 3개의 칸에 i, j가 총 3번 나오며
                    // 둘 다 최소 1번 이상 나오면 승리
                    if (numI + numJ == 3 && numI >= 1 && numJ >= 1)
                        win = true;
                }

                // 세로로 빙고가 만들어질 때
                for (int k = 0; k < MAX_A; k++) {
                    numI = 0;
                    numJ = 0;
                    for (int l = 0; l < MAX_A; l++) {
                        if (board[l][k] == i)
                            numI++;
                        if (board[l][k] == j)
                            numJ++;
                    }

                    // 3개의 칸에 i, j가 총 3번 나오며
                    // 둘 다 최소 1번 이상 나오면 승리
                    if (numI + numJ == 3 && numI >= 1 && numJ >= 1)
                        win = true;
                }

                // 왼쪽 위에서 오른쪽 아래를 잇는 대각선으로 빙고가 만들어질 때
                numI = 0;
                numJ = 0;
                for (int k = 0; k < MAX_A; k++) {
                    if (board[k][k] == i)
                        numI++;
                    if (board[k][k] == j)
                        numJ++;
                }

                // 3개의 칸에 i, j가 총 3번 나오며
                // 둘 다 최소 1번 이상 나오면 승리
                if (numI + numJ == 3 && numI >= 1 && numJ >= 1)
                    win = true;

                // 오른쪽 위에서 왼쪽 아래를 잇는 대각선으로 빙고가 만들어질 때
                numI = 0;
                numJ = 0;
                for (int k = 0; k < MAX_A; k++) {
                    if (board[k][MAX_A - k - 1] == i)
                        numI++;
                    if (board[k][MAX_A - k - 1] == j)
                        numJ++;
                }

                // 3개의 칸에 i, j가 총 3번 나오며
                // 둘 다 최소 1번 이상 나오면 승리
                if (numI + numJ == 3 && numI >= 1 && numJ >= 1)
                    win = true;


                if (win)
                    ans++;
            }

        System.out.print(ans);
    }
}