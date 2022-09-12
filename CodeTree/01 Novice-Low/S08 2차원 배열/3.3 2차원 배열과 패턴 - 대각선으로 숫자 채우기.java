import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        // case 1 : 1행을 시작점으로 하는 대각선
        int count = 1;
        for (int startCol = 0; startCol < m; startCol++) {
            int currCol = startCol;
            int currRow = 0;

            // 대각선 방향으로 숫자 채우기
            while (currRow < n && currCol >= 0) {
                arr[currRow][currCol] = count;

                // 변수 업데이트
                currRow++;
                currCol--;
                count++;
            }
        }

        // case 2 : m - 1 열을 시작점으로 하는 대각선
        for (int startRow = 1; startRow < n; startRow++) {
            int currRow = startRow;
            int currCol = m - 1;

            // 대각선 방향으로 숫자 채우기
            while (currRow < n && currCol >= 0) {
                arr[currRow][currCol] = count;

                // 변수 업데이트
                currRow++;
                currCol--;
                count++;
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 해설 1 : 시뮬레이션
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 입력받습니다.
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int count = 1;

        // 2차원 배열을 구현합니다.
        int[][] arr = new int[100][100];

        // Step 1:
        for (int startCol = 0; startCol < m; startCol++) {
            int currRow = 0;
            int currCol = startCol;

            while (currCol >= 0 && currRow < n) {
                arr[currRow][currCol] = count;

                // 변수 업데이트 :
                currRow++;
                currCol--;
                count++;
            }
        }

        // Step 2:
        for (int startRow = 1; startRow < n; startRow++) {
            int currRow = startRow;
            int currCol = m - 1;

            while (currCol >= 0 && currRow < n) {
                arr[currRow][currCol] = count;

                // 변수 업데이트 :
                currRow++;
                currCol--;
                count++;
            }
        }

        // 출력:
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}

// 해설 2 : 시뮬레이션 별해
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 입력받습니다.
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int count = 1;

        // 2차원 배열을 구현합니다.
        int[][] arr = new int[100][100];

        // Step 1:
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++)
                // Step 2:
                if (arr[row][col] == 0) {
                    int currCol = col;
                    int currRow = row;

                    while (currCol >= 0 && currRow < n) {
                        arr[currRow][currCol] = count;

                        // 변수 업데이트 :
                        currRow++;
                        currCol--;
                        count++;
                    }
                }
        }

        // 출력:
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}