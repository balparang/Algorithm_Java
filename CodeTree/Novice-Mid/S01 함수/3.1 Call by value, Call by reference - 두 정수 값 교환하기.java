import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IntWrapper n = new IntWrapper(sc.nextInt());
        IntWrapper m = new IntWrapper(sc.nextInt());
        swap(n, m);

        System.out.println(n.num + " " + m.num);
    }

    static void swap(IntWrapper a, IntWrapper b) {
        int temp = a.num;
        a.num = b.num;
        b.num = temp;
    }
}

class IntWrapper {
    int num;

    public IntWrapper(int num) {
        this.num = num;
    }
}

// 해설
import java.util.Scanner;

class IntWrapper {
    int value;

    public IntWrapper(int value) {
        this.value = value;
    }
}

public class Main {
    public static void swap(IntWrapper n, IntWrapper m) {
        int temp = n.value;
        n.value = m.value;
        m.value = temp;
    }

    public static void main(String[] args) {
        // 변수 선언 및 입력:
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // java의 경우 int값을 그대로 넘겨 swap을 기대하기는 어렵기에,
        // IntWrapper라는 객체를 만들어 넘기는 방식으로 해결합니다.
        IntWrapper nWrapper = new IntWrapper(n);
        IntWrapper mWrapper = new IntWrapper(m);

        swap(nWrapper, mWrapper);

        // 교환 이후 값을 다시 넣어줍니다.
        n = nWrapper.value;
        m = mWrapper.value;

        System.out.println(n + " " + m);
    }
}