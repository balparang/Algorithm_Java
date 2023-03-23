/**
 * 인접 행렬을 이용한 풀이
 */

import java.io.*;
import java.util.*;

public class Main {

    /*
    1. DFS 를 이용하여 visited[] 배열을 구한다.
    2. visited[] 에서 true의 개수를 세고 - 1 이 정답(1번 정점 자기 자신 제외)
    */

	public static int verticesNum = 0;
	public static int edgesNum = 0;

	public static int[][] graph;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		verticesNum = Integer.parseInt(st.nextToken()); // N
		edgesNum = Integer.parseInt(st.nextToken()); // M

		int[] startPoints = new int[edgesNum];
		int[] endPoints = new int[edgesNum];

		for (int i = 0; i < edgesNum; i++) {
			String edge = br.readLine();
			st = new StringTokenizer(edge, " ");
			startPoints[i] = Integer.parseInt(st.nextToken());
			endPoints[i] = Integer.parseInt(st.nextToken());
		}

		// 그래프 정보 생성
		graph = new int[verticesNum + 1][verticesNum + 1];
		visited = new boolean[verticesNum + 1];

		for (int i = 0; i < edgesNum; i++) {

			int start = startPoints[i];
			int end = endPoints[i];

			graph[start][end] = 1;
			graph[end][start] = 1;
		}

		// 시작 정점 방문 처리 & DFS 시작
		int rootVertex = 1;

		visited[rootVertex] = true;
		// System.out.print(rootVertex + " ");

		dfs(rootVertex);

		// 출력
		System.out.println(solution());
	}

	// DFS
	public static void dfs(int vertex) {

		for (int currV = 1; currV <= verticesNum; currV++) {

			// if connected &  not visited
			if (graph[vertex][currV] == 1 && visited[currV] == false) {

				// visit & dfs
				visited[currV] = true;
				// System.out.print(currV + " ");

				dfs(currV);
			}
		}
	}

	// 정답 구하기 :  visited[] 에서 true의 개수를 세고 - 1 이 정답(1번 정점 자기 자신 제외)
	public static int solution() {

		int answer = 0;
		for (int i = 1; i < visited.length; i++) {

			if (visited[i] == true) {
				answer++;
			}
		}

		return answer == 0 ? answer : answer - 1;
	}
}

/**
 * 해설 1 - 인접 행렬
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static final int MAX_NUM = 1000;
	public static int n, m;

	// index를 1번 부터 사용하기 위해 MAX_NUM+1만큼 할당합니다.
	public static int[][] graph = new int[MAX_NUM + 1][MAX_NUM + 1];
	public static boolean[] visited = new boolean[MAX_NUM + 1];
	public static int vertexCnt = 0;

	public static void DFS(int vertex) {
		// 해당 정점에서 이어져있는 모든 정점을 탐색해줍니다.
		for (int currV = 1; currV <= n; currV++) {
			// 아직 간선이 존재하고 방문한 적이 없는 정점에 대해서만 탐색을 진행합니다.
			if (graph[vertex][currV] == 1 && !visited[currV]) {
				visited[currV] = true;
				vertexCnt++; // 정점 1은 고려 안 해도 된다: 방문 정점은 루트 정점 이후부터 세기 때문
				DFS(currV);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		while (m-- > 0) {
			// 각 정점이 서로 이동이 가능한 양방향 그래프이기 때문에
			// 각 정점에 대한 간선을 각각 저장해줍니다.
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}

		visited[1] = true;
		DFS(1);

		System.out.println(vertexCnt);
	}
}

/**
 * 해설 2: 인접 리스트 구현
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 1000;
	public static int n, m;


	// index를 1번 부터 사용하기 위해 MAX_NUM+1만큼 할당합니다.
	public static ArrayList<Integer>[] graph = new ArrayList[MAX_NUM + 1];
	public static boolean[] visited = new boolean[MAX_NUM + 1];
	public static int vertexCnt = 0;

	public static void DFS(int vertex) {
		// 해당 정점에서 이어져있는 모든 정점을 탐색해줍니다.
		for(int i = 0; i < graph[vertex].size(); i++) {
			int currV = graph[vertex].get(i);
			if(!visited[currV]) {
				// 아직 방문한 적이 없는 정점에 대해서만 탐색을 진행합니다.
				visited[currV] = true;
				vertexCnt++;
				DFS(currV);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for(int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		while(m-- > 0) {
			// 각 정점이 서로 이동이 가능한 양방향 그래프이기 때문에
			// 각 정점에 대한 간선을 각각 저장해줍니다.
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		visited[1] = true;
		DFS(1);

		System.out.println(vertexCnt);
	}
}

/**
 * 23.03.23 연습
 */

public class Main {

	static final int MAX_N = 1000;

	static ArrayList<Integer>[] graph = new ArrayList[MAX_N + 1]; // 배열 생성

	static int N, M;
	static int vertexCnt = 0;
	static boolean[] visited = new boolean[MAX_N + 1];

	public static void main(String[] args) {

		// graph 초기화
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // vertices_num
		M = sc.nextInt(); // edges_num

		// 그래프 정보 생성
		while (M-- > 0) {

			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			// 양방향 그래프 매핑
			graph[v1].add(v2); // NPE 발생
			graph[v2].add(v1);
		}

		// 루트 노드 방문 처리
		int rootVertex = 1;
		visited[rootVertex] = true;
		DFS(rootVertex);

		// 출력
		System.out.println(vertexCnt++);
	}

	public static void DFS(int vertex) {

		for (int i = 0; i < graph[vertex].size(); i++) {

			int currV = graph[vertex].get(i);

			if (!visited[currV]) {

				visited[currV] = true;
				vertexCnt++; // 정답 카운팅++

				DFS(currV);
			}
		}
	}
}