public class Main {
    public static void main(String[] args) {
        // 변수 선언
        int weight = 13;
        double gravityRatio = 0.165;

        // 실수값은 소수점 아래 여섯째자리까지 출력
        System.out.printf("%d * %.6f = %.6f", weight, gravityRatio, weight * gravityRatio);
    }
}