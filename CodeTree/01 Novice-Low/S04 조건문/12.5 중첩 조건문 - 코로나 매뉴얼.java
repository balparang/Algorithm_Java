import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        char cold1 = sc.next().charAt(0);
        int temp1 = sc.nextInt();

        char cold2 = sc.next().charAt(0);
        int temp2 = sc.nextInt();

        char cold3 = sc.next().charAt(0);
        int temp3 = sc.nextInt();

        // A 검사소로 가는 사람 수 세기
        int count = 0; // A검사소로 가는 사람 수
        if (cold1 == 'Y' && temp1 >= 37) {
            count++;
        }
        if (cold2 == 'Y' && temp2 >= 37) {
            count++;
        }
        if (cold3 == 'Y' && temp3 >= 37) {
            count++;
        }

        // 출력
        if (count >= 2) {
            System.out.println("E");
        } else {
            System.out.println("N");
        }
    }
}

// 선생님 답안
mport java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        char c1, c2, c3;
        int t1, t2, t3;

        // 입력
        c1 = sc.next().charAt(0);
        t1 = sc.nextInt();
        c2 = sc.next().charAt(0);
        t2 = sc.nextInt();
        c3 = sc.next().charAt(0);
        t3 = sc.nextInt();

        // 출력
        // A가 2명 이상인지 판단하기
        if(c1 == 'Y' && t1 >= 37) {
            // 첫 번째 사람이 A라면, 남은 두 사람 중 한 사람이라도 A면 됩니다.
            if((c2 == 'Y' && t2 >= 37) || (c3 == 'Y' && t3 >= 37))
                System.out.println("E");
            else
                System.out.println("N");
        }
        else {
            // 첫 번째 사람이 A가 아니라면, 남은 두 사람 모두 A여야만 합니다.
            if((c2 == 'Y' && t2 >= 37) && (c3 == 'Y' && t3 >= 37))
                System.out.println("E");
            else
                System.out.println("N");
        }
    }
}