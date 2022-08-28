import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String code = sc.next();
        String color = sc.next();
        int second = sc.nextInt();

        // 인스턴스 생성
        Bomb bomb = new Bomb(code, color, second);

        // 출력
        System.out.println("code : " + bomb.code);
        System.out.println("color : " + bomb.color);
        System.out.println("second : " + bomb.second);

    }
}

class Bomb {
    String code;
    String color;
    int second;

    public Bomb(String code, String color, int second) {
        this.code = code;
        this.color = color;
        this.second = second;
    }
}