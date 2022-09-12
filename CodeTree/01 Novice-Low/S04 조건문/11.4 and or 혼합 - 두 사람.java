import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aAge = sc.nextInt();
        char aSex = sc.next().charAt(0);
        int bAge = sc.nextInt();
        char bSex = sc.next().charAt(0);

        if ((aAge >= 19 && aSex == 'M') || (bAge >= 19 && bSex == 'M')) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int a_age, b_age;
        char a_gen, b_gen;

        // 입력
        a_age = sc.nextInt();
        a_gen = sc.next().charAt(0);
        b_age = sc.nextInt();
        b_gen = sc.next().charAt(0);

        // 출력
        if((a_age >= 19 && a_gen == 'M') || (b_age >= 19 && b_gen == 'M'))
            System.out.println("1");
        else
            System.out.println("0");
    }
}