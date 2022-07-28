import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sex = sc.nextInt(); // 0: male, 1: female
        int age = sc.nextInt(); // age < 19 : BOY or GIRL

        if (sex == 0) { // male
            System.out.println(age >= 19 ? "MAN" : "BOY");
        } else { // female
            System.out.println(age >= 19 ? "WOMAN" : "GIRL");
        }
    }
}

// 선생님 답안
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int gender, age;

        // 입력
        gender = sc.nextInt();
        age = sc.nextInt();

        // gender가 0인지 1인지 판단하기
        if(gender == 0) {
            // gender가 0일 때, age가 19이상이면 MAN이, 19보다 작다면 BOY가 됩니다.
            if(age >= 19)
                System.out.println("MAN");
            else
                System.out.println("BOY");
        }
        else {
            // gender가 1일 때, age가 19이상이면 WOMAN이, 19보다 작다면 GIRL이 됩니다.
            if(age >= 19)
                System.out.println("WOMAN");
            else
                System.out.println("GIRL");
        }
    }
}