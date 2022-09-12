import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.next();
        String point = sc.next();
        int time = sc.nextInt();

        C007 c007 = new C007(code, point, time);

        System.out.println("secret code : " + c007.secretCode);
        System.out.println("meeting point : " + c007.meetingPoint);
        System.out.println("time : " + c007.time);
    }
}

class C007 {
    String secretCode;
    String meetingPoint;
    int time;

    public C007(String secretCode, String meetingPoint, int time) {
        this.secretCode = secretCode;
        this.meetingPoint = meetingPoint;
        this.time = time;
    }
}