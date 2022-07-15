import java.util.Scanner;

public class Main {
    public int solution(String str, char t) { //인스턴스 메서드
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t); // t라는 문자를 대문자화
        // System.out.println(str+" "+t);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) answer++; // 문자열을 인덱스로 접근하는 charAt
        }

        return answer;
    }

    public static void main(String[] args) {
        // 인스턴스 메서드를 static에서 인스턴스 메서드 호출하려면
        // 클래스 객체 생성해야함
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next(); // next()는 문자 또는 문자열을 공백 기준으로 한 단어 혹은 한 문자씩 입력 받음
        char c = kb.next().charAt(0); // 문자열에서 0번에 있는 문자를 가져옴
        System.out.print(T.solution(str, c));
    }
}
----
        >> ref2 foreach 향상된 for 문
        import java.util.Scanner;

public class Main {
    public int solution(String str, char t) { //인스턴스 메서드
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t); // t라는 문자를 대문자화
        // System.out.println(str+" "+t);
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == t) answer++; // 문자열을 인덱스로 접근하는 charAt
//        }
        // string을 기반으로 문자 배열을 생성하고 for each
        for (char x : str.toCharArray()) {
            if (x == t) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 인스턴스 메서드를 static에서 인스턴스 메서드 호출하려면
        // 클래스 객체 생성해야함
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next(); // next()는 문자 또는 문자열을 공백 기준으로 한 단어 혹은 한 문자씩 입력 받음
        char c = kb.next().charAt(0); // 문자열에서 0번에 있는 문자를 가져옴
        System.out.print(T.solution(str, c));
    }
}