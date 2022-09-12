import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aMath = sc.nextInt();
        int aEng = sc.nextInt();
        int bMath = sc.nextInt();
        int bEng = sc.nextInt();

        if (aMath != bMath) { // 수학 점수 다른 경우 수학 점수 높은 쪽
            System.out.println(aMath > bMath ? "A" : "B");
        } else { // 수학 점수 같은 경우 영어 점수가 더 높은 쪽
            System.out.println(aEng > bEng ? "A" : "B");
        }
    }
}

/* 선생님 답안 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a_math, a_eng;
        int b_math, b_eng;

        // 입력
        a_math = sc.nextInt();
        a_eng = sc.nextInt();
        b_math = sc.nextInt();
        b_eng = sc.nextInt();

        // 출력
        if(a_math > b_math || (a_math == b_math && a_eng > b_eng))
            System.out.println("A");
        else
            System.out.println("B");
    }
}