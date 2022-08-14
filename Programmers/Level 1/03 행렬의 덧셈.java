// Try 1 - fail : 주어진 입력이 정방행렬이 아닌데, 정방행렬인 것 처럼 풀이.
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int[][] answer = new int[n][n];

        // 행렬의 합 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}

// Try 2 - pass
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length;
        int width = arr1[0].length;
        int[][] answer = new int[height][width];

        // 행렬의 합 구하기
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}

// 다른 사람의 풀이 : arr1에 원소 덮어쓰기
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = arr1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] += arr2[i][j];
            }
        }
        return answer;
    }
}