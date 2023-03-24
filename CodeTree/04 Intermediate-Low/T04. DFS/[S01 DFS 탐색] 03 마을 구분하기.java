/**
 * 23.03.24
 */

import java.util.*;

public class Main {

    /*
        1. 모든 격자칸에 방문 시도
        2. 방문되지 않은 곳이라면 방문 하고 DFS 시작 (DFS 스택 1)
        3. DFS 하면서 인원수 기록
        4. DFS 스택이 모두 종료 되면 인원수를 배열에 저장
        5. 1 ~ 4 반복
    */
    static final int MAX_N = 25;

    static int n; // n by n grid
    static int[][] grid = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static int[] peopleNums = new int[MAX_N * MAX_N]; // 격자 수 만큼 마을이 있다고 생각
    static int peopleNumsIdx = 0;
    static int peopleCnt;
    static int villageCnt;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {

        // 입력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 그리드 정보 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // findVillages()
        findVillages();

        // 출력
        System.out.println(villageCnt);

        // 오름차순 정렬
        int[] villages = Arrays.copyOfRange(peopleNums, 0, villageCnt);
        Arrays.sort(villages);

        for (int peopleNum : villages) {
            System.out.println(peopleNum);
        }
    }

    public static void findVillages() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // if wall continue;
                if (grid[i][j] == 0) continue;

                // if visited continue;
                if (visited[i][j]) continue;

                villageCnt++;
                peopleCnt = 1;
                visited[i][j] = true;

                DFS(i, j);

                peopleNums[peopleNumsIdx++] = peopleCnt;
            }
        }
    }

    public static void DFS(int x, int y) {

        // rotate using dx, dy
        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny)) {
                peopleCnt++;
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public static boolean canGo(int x, int y) {

        if (!inRange(x, y)) return false;

        // visted or wall exists
        if (visited[x][y] || grid[x][y] == 0) return false;

        return true;
    }

    public static boolean inRange(int x, int y){

        return (x >= 0 && x < n) && (y >= 0 && y < n);
    }
}

/**
 * 해설
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_NUM = 25;

    public static int n;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    public static ArrayList<Integer> peopleNums = new ArrayList<>();
    public static int peopleNum;

    // 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
    public static boolean canGo(int x, int y) {
        if(!inRange(x, y))
            return false;

        if(visited[x][y] || grid[x][y] == 0)
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

            if(canGo(newX, newY)){
                visited[newX][newY] = true;
                // 마을에 존재하는 사람을 한 명 추가해줍니다.
                peopleNum++;
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
        // 한 마을에 대한 DFS 탐색을 수행합니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(canGo(i, j)) {
                    // 해당 위치를 방문할 수 있는 경우 visited 배열을 갱신하고
                    // 새로운 마을을 탐색한다는 의미로 peopleNum을 1으로 갱신합니다.
                    visited[i][j] = true;
                    peopleNum = 1;

                    DFS(i, j);

                    // 한 마을에 대한 탐색이 끝난 경우 마을 내의 사람 수를 저장합니다.
                    peopleNums.add(peopleNum);
                }
            }
        }

        // 각 마을 내 사람의 수를 오름차순으로 정렬합니다.
        Collections.sort(peopleNums);

        System.out.println((int) peopleNums.size());
        for(int i = 0; i < (int) peopleNums.size(); i++)
            System.out.println(peopleNums.get(i));
    }
}