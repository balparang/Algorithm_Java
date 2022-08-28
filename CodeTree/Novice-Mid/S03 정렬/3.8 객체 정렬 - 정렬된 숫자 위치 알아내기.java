import java.util.Arrays;
import java.util.Scanner;

class Number {
    int number;
    int idx;

    public Number(int number, int idx) {
        this.number = number;
        this.idx = idx;
    }
}

public class Main {
    static int n;
    static Number[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        numbers = new Number[n];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            numbers[i] = new Number(number, i + 1);
        }

        // 숫자별로 오름차순 정렬
        Arrays.sort(numbers, (o1, o2) -> {
            return o1.number - o2.number;
        });

        // 원소가 어느 위치로 이동했는지 구하기
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[numbers[i].idx] = i + 1;
        }

        // 출력
        for (int i = 1; i < n + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// 해설
import java.util.Scanner;
import java.util.Arrays;

// 클래스 선언:
class Number implements Comparable<Number> {
    int number;
    int index;

    public Number(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public int compareTo(Number b) {
        // number가 작으면 정렬 했을 때 앞에 와야 합니다.
        if (number != b.number)
            return number - b.number;
        // index가 작으면 정렬 했을 때 앞에 와야 합니다.
        return index - b.index;
    }
};

public class Main {
    public static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언:
        int n, numCache;
        int[] answer = new int[MAX_NUM];

        Number[] numbers = new Number[MAX_NUM];

        // 입력:
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numCache = sc.nextInt();
            numbers[i] = new Number(numCache, i);
        }

        // Custom Comparator를 활용한 정렬:
        Arrays.sort(numbers, 0, n);

        // 정렬된 숫자들의 원래 인덱스를 활용한 정답 배열 저장:
        for (int i = 0; i < n; i++)
            answer[numbers[i].index] = i + 1; // 인덱스 보정

        // 출력:
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}