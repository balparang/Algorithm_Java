import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    static int answer = 0;

    public static int solution(int[][] board, int[] moves) {
        int n = board.length;
        int[] indexes = new int[n];
        Arrays.fill(indexes, 0);

        for (int x : moves) {
            if (indexes[x - 1] >= n) {
                continue;
            } else {
                int tmp;
                while ((tmp = board[indexes[x - 1]][x - 1]) == 0) {
                    indexes[x-1]++;
                    if(indexes[x-1] >= n) break;
                }

                if (tmp != 0) handleStack(tmp);
                indexes[x-1]++;
            }
        }

        return answer;
    }

    private static void handleStack(int tmp) {
        if (stack.isEmpty()) {
            stack.push(tmp);
            return; // 초깃값이 없으니까 계속 리턴만 하게 됨
        }

        if (stack.peek() == tmp) {
            stack.pop();
            answer += 2;
        } else {
            stack.push(tmp);
        }
    }


    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }
}