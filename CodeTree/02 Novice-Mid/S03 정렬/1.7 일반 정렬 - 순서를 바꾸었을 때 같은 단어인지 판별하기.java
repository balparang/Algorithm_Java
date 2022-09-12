import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String str1, str2;
    static char[] chars1, chars2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        str1 = sc.next();
        str2 = sc.next();
        chars1 = str1.toCharArray();
        chars2 = str2.toCharArray();

        // 정렬
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        // 출력
        if (isSame()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // 두 배열이 같은 배열인지 판단
    private static boolean isSame() {
        if (chars1.length != chars2.length) {
            return false;
        }
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }

        return true;
    }
}

// 해설 1 - Sorting(Main)
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        // 각 문자열을 정렬합니다.
        char[] chars1 = str1.toCharkrArray();
        Arrays.sort(chars1);
        String sortedStr1 = new String(chars1);

        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars2);
        String sortedStr2 = new String(chars2);

        if(sortedStr1.equals(sortedStr2))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}

// 해설 2 - Counting: 아스키 넘버를 배열로 사용
import java.util.Scanner;

public class Main {
    public static final int ASCII_NUM = 128;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int[] count = new int[ASCII_NUM];

        // count 배열을 0으로 초기화 해줍니다.
        for(int i = 0; i < ASCII_NUM; i++)
            count[i] = 0;

        // 첫 번째 문자열을 순회하며 각 문자의 개수를 세줍니다.
        for(int i = 0; i < str1.length(); i++)
            count[str1.charAt(i)]++;

        // 두 번째 문자열을 순회하며 각 문자의 개수를 세줍니다.
        for(int i = 0; i < str2.length(); i++)
            count[str2.charAt(i)]--;

        // count 배열을 순회하면서 모든 문자의 개수가 동일한지를 확인합니다.
        for(int i = 0; i < ASCII_NUM; i++)
            if(count[i] != 0) {
                System.out.print("No");
                System.exit(0);
            }

        System.out.print("Yes");
    }
}