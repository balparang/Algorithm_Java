import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        double h = sc.nextDouble() / 100; // cm -> m 단위 변환
        int w = sc.nextInt();

        // 체질량지수 계산 몸무게(kg) / 키(m) ^ 2
        int bmi = (int) (w / (h * h));

        // 출력
        System.out.println(bmi);
        if (bmi >= 25)
            System.out.println("Obesity");
    }
}