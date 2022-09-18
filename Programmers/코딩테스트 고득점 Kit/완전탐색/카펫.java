// 가로, 세로 길이를 완전탐색
class Solution {
    static final int MAX_R = 2500; // 한 변 최대길이

    static int[] answer = new int[2];
    static int Brown, Yellow;

    public int[] solution(int brown, int yellow) {
        Brown = brown;
        Yellow = yellow;

        for (int w = 3; w < MAX_R; w++) {
            boolean isSatisfied = false;

            for (int h = 3; h < MAX_R; h++) {
                if (satisfied(w, h)) {
                    // 카펫의 가로 길이는 세로 길이보다 크거나 같다.
                    answer[0] = Math.max(w, h);
                    answer[1] = Math.min(w, h);
                    isSatisfied = true;
                    break;
                }
            }

            if (isSatisfied) {
                break;
            }
        }

        return answer;
    }

    static boolean satisfied(int w, int h) {
        int area = w * h;

        // 전체 타일 개수 일치하는지 확인
        if (area != Brown + Yellow) {
            return false;
        }

        // 테두리 타일 개수 일치하는지 확인 (테두리 길이 = brown)
        if (2 * (w + h) - 4 != Brown) {
            return false;
        }

        return true;
    }
}

// 다른 풀이 1 - 넓이를 기준으로 약수를 이용하여 계산
// 출처 : https://easybrother0103.tistory.com/110
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);

                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}