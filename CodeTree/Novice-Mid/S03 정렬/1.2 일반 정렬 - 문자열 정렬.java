import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();

        // 오름차순 정렬
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String ascendingStr = String.valueOf(chars);

        // 출력
        System.out.println(ascendingStr);
    }
}

// 해설
import java.util.Scanner;
        import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String str = sc.next();

        // 문자 사전순 정렬
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        System.out.println(sortedStr);
    }
}