import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        // space를 제외한 문자를 StringBuilder에 추가
        for (char c : str1.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        for (char c : str2.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 공백을 포함한 문자열을 입력받습니다.
        String str = sc.nextLine();
        String str2 = sc.nextLine();

        // 문자열을 전부 순회하며 공백을 제외한 모든 문자를 출력합니다.
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) != ' ')
                System.out.print(str.charAt(i));

        for(int i = 0; i < str2.length(); i++)
            if(str2.charAt(i) != ' ')
                System.out.print(str2.charAt(i));
    }
}