// Try 1 - fail:
// [문제 잘못 해석] 문장 전체를 기준으로 홀짝을 구분하는 것이 아니라 단어 단위로 홀짝을 판단해야함
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();

        int idx = 0; // 짝, 홀 판단
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                idx++;
                continue;
            }

            if (idx % 2 == 0) { // 짝수 번째
                if (!isUpperCase(arr[i])) { // 소문자인 경우 대문자로 변환
                    arr[i] = (char) (arr[i] - 'a' + 'A');
                }
            } else { // 홀수 번째
                // 대문자인 경우 소문자로 변환
                if (isUpperCase(arr[i])) {
                    arr[i] = (char) (arr[i] - 'A' + 'a');
                }
            }
            idx++;
        }

        return String.valueOf(arr);
    }

    boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}

// Try 2 - pass
// 단어 단위로 홀짝을 판단할 수 있게 수정
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();

        int idx = 0; // 짝, 홀 판단

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                idx = 0;
                continue;
            }

            if (idx % 2 == 0) { // 짝수 번째
                if (!isUpperCase(arr[i])) { // 소문자인 경우 대문자로 변환
                    arr[i] = (char) (arr[i] - 'a' + 'A');
                }
            } else { // 홀수 번째
                // 대문자인 경우 소문자로 변환
                if (isUpperCase(arr[i])) {
                    arr[i] = (char) (arr[i] - 'A' + 'a');
                }
            }
            idx++;
        }

        return String.valueOf(arr);
    }

    boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}

// 다른 사람의 풀이
class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                idx = 0;
            else
                chars[i] = (idx++ % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
        }

        return String.valueOf(chars);
    }
}