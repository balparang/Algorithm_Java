class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 소문자인 경우
            if (Character.isLowerCase(chars[i])) {
                chars[i] = (char) (chars[i] + n);
                // 'z'보다 큰 경우
                if (chars[i] > 'z') {
                    chars[i] = (char) (chars[i] - 'z' + 'a' - 1);
                }
            }

            // 대문자인 경우
            if (Character.isUpperCase(chars[i])) {
                chars[i] = (char) (chars[i] + n);
                // 'Z'보다 큰 경우
                if (chars[i] > 'Z') {
                    chars[i] = (char) (chars[i] - 'Z' + 'A' - 1);
                }
            }
        }

        return String.valueOf(chars);
    }
}

// 다른 사람의 풀이
class Caesar {
    String caesar(String s, int n) {
        String result = "";
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Caesar c = new Caesar();
        System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
    }
}