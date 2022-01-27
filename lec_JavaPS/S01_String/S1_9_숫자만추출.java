import java.util.Scanner;

// 자릿수 올리기, ASCII CODE
public class Main {
    public int solution(String str) {
        int answer = 0;

        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) { // '0' ~ '9'
                answer = answer * 10 + (x - 48);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
-------------------

import java.util.Scanner;
// Integer.parseint
public class Main {
    public int solution(String str) {
        String answer = "";

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
