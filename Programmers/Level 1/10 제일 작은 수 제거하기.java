class Solution {
    public int[] solution(int[] arr) {
        // 길이가 1인 배열은 {-1} 리턴
        if (arr.length == 1) {
            int[] emptyArr = new int[]{-1};
            return emptyArr;
        }

        // 가장 작은 수 인덱스 찾기
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }

        // 가장 작은 수를 제외한 새 배열 생성
        int[] newArr = new int[arr.length - 1];
        int newIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == minIdx) {
                continue;
            }
            newArr[newIdx] = arr[i];
            newIdx++;
        }

        return newArr;
    }
}