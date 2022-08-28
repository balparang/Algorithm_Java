import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 새로운 유저 정보 입력
        String name = sc.next();
        int level = sc.nextInt();

        // 유저 인스턴스 생성
        User user1 = new User();
        User user2 = new User(name, level);

        // 출력
        System.out.println(user1.getUserInfo());
        System.out.println(user2.getUserInfo());
    }
}

class User {
    String name;
    int level;

    public User() {
        this("codetree", 10);
    }

    public User(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getUserInfo() {
        return String.format("user %s lv %d", this.name, this.level);
    }
}