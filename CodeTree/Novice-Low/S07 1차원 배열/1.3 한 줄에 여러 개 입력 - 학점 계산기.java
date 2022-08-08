import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }

        double sum = 0, avg = 0;

        // 평균 계산
        for (double score : arr) {
            sum += score;
        }
        avg = sum / n;

        // 등급 계산
        String grade = null;
        if (avg >= 4.0) {
            grade = "Perfect";
        } else if (avg >= 3.0) {
            grade = "Good";
        } else {
            grade = "Poor";
        }

        // 출력
        System.out.printf("%.1f\n", avg);
        System.out.println(grade);
    }
}

// 해설
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //과목의 개수 n을 입력받습니다.
        int n = sc.nextInt();

        // 변수 선언
        double[] arr = new double[5];
        double sum = 0;

        // 배열에 실수를 입력받아 저장합니다.
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        // 배열에 있는 실수들의 합을 구합니다.
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        //평균 구하기
        double avg = sum / n;

        // 출력
        System.out.printf("%.1f\n", avg);

        if (avg >= 4.0) {
            System.out.println("Perfect");
        } else if (avg >= 3.0) {
            System.out.println("Good");
        } else {
            System.out.println("Poor");
        }
    }
}