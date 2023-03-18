public class Main {

    public String solution(String str) {

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                continue;
            }
            chars[i] = Character.toLowerCase(chars[i]);
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();

        // 출력
        System.out.println(T.solution(inputLine));
    }
}

/**
 * 해설
 */
public class Main {

    public static void main(String[] args) {

        main.Main T = new main.Main();

        // 입력
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 출력
        System.out.println(T.solution2(str));
    }

    // #1. Character
    public String solution1(String str) {

        String answer = "";

        for (char x : str.toCharArray()) {

            if (Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x);
            } else {
                answer += Character.toLowerCase(x);
            }
        }

        return answer;
    }

    // #2. ASCII 풀이
    // A = 65, Z = 90
    // a = 97, z = 122
    public String solution2(String str) {

        String answer = "";

        for (char x : str.toCharArray()) {

            if (x >= 65 && x <= 90) { // 대문자
                answer += (char)(x + 32);
            } else { // 소문자
                answer += (char)(x - 32);
            }
        }

        return answer;
    }
}
