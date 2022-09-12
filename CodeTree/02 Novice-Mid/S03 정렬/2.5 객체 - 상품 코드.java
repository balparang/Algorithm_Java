import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        String name = sc.next();
        int code = sc.nextInt();

        // 인스턴스 생성
        Product product1 = new Product("codetree", 50);
        Product product2 = new Product(name, code);

        // 출력
        System.out.println(product1.getProductInfo());
        System.out.println(product2.getProductInfo());
    }
}

class Product {
    String name;
    int code;

    public Product(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getProductInfo() {
        return String.format("product %d is %s", this.code, this.name);
    }
}

// 해설
import java.util.Scanner;

// Product 정보를 나타내는 클래스 선언
class Product {
    String id;
    int code;

    public Product(String id, int code) {
        this.id = id;
        this.code = code;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 첫 번째 Product 객체를 만들어 줍니다.
        Product product1 = new Product("codetree", 50);

        // 변수 선언 및 입력
        String id2 = sc.next();
        int code2 = sc.nextInt();

        // 두 번째 Product 객체를 만들어 줍니다.
        Product product2 = new Product(id2, code2);

        // 결과를 출력합니다.
        System.out.println("product " + product1.code + " is " + product1.id);
        System.out.println("product " + product2.code + " is " + product2.id);
    }
}