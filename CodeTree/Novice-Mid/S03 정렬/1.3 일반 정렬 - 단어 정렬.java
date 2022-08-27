import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int len = sc.nextInt();
        String[] strArr = new String[len];
        for (int i = 0; i < len; i++) {
            strArr[i] = sc.next();
        }

        // 오름차순 정렬
        Arrays.sort(strArr);

        // 출력
        for (String str : strArr) {
            System.out.println(str);
        }
    }
}

// 해설
import java.util.Scanner;
        import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        String[] wordList = new String[n];
        for (int i = 0; i < n; i++)
            wordList[i] = sc.next();

        // 문자열 사전순 정렬
        Arrays.sort(wordList);

        for (int i = 0; i < n; i++)
            System.out.println(wordList[i]);
    }
}