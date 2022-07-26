import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0; // 인형 뽑고 0으로 변경

                    if(!stack.isEmpty() && stack.peek() == tmp) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }

                    break; // 한 시행에 하나의 인형만 뽑는다.
                }
            }
        }


        return answer;
    }
}