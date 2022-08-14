// Try 1 : String.substring(int beginIndex)
class Solution {
    public String solution(String phone_number) {
        String lastNumber = phone_number.substring(phone_number.length() - 4); // 번호 마지막 4자리

        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(phone_number.length() - 4)); // 앞자리
        sb.append(lastNumber); // 마지막 4자리 추가

        return sb.toString();
    }
}

// 다른 사람의 풀이 1 : String.toCharArray()
class Solution {
    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for (int i = 0; i < ch.length - 4; i++) {
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}

// 다른 사람의 풀이 2 : 정규식 이용
class Solution {
    public String solution(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
}
