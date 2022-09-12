public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (j % 2 != 0 && j != 19) {
                    System.out.printf("%d * %d = %d / ", i, j, i * j);
                } else { // j % 2 == 0 or j = 19
                    System.out.printf("%d * %d = %d\n", i, j, i * j);
                }
            }
        }
    }
}