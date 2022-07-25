public class Main {
    public static void main(String[] args) {
        double ft = 30.48; // 1피트
        double mi = 160934; // 1마일

        double a = 9.2;
        double b = 1.3;

        System.out.printf("%.1fft = %.1fcm\n", a, a * ft);
        System.out.printf("%.1fmi = %.1fcm\n", b, b * mi);
    }
}