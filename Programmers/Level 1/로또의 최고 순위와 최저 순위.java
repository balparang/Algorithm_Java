class Solution {
    static final int MAX_R = 6;

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt0 = 0; // win_nums의 0의 개수
        int cntSame = 0; // 번호가 확실히 맞는 개수

        // 맞은 개수 세기
        for (int i = 0; i < MAX_R; i++) {
            for (int j = 0; j < MAX_R; j++) {
                if (win_nums[i] == lottos[j]) {
                    cntSame++;
                }
            }

            if (lottos[i] == 0) {
                cnt0++;
            }
        }

        System.out.printf("cnt0: %d, cntSame: %d\n", cnt0, cntSame);

        int maxRank = rank(cntSame + cnt0);
        int minRank = rank(cntSame);
        answer[0] = maxRank;
        answer[1] = minRank;

        return answer;
    }

    // 맞은 번호 개수에 따라 등수 리턴
    static int rank(int same) {
        if (same == 6) {
            return 1;
        } else if (same >= 2 && same <= 5) {
            return 7 - same;
        } else {
            return 6;
        }
    }
}