import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 선언
        Agent[] agents = new Agent[5];

        // 배열 입력
        int minScoreIdx = 0;

        for (int i = 0; i < 5; i++) {
            String code = sc.next();
            int score = sc.nextInt();

            agents[i] = new Agent(code, score);

            if (score < agents[minScoreIdx].score) {
                minScoreIdx = i;
            }
        }

        // 점수가 제일 낮은 요원의 코드네임과 점수 출력
        System.out.println(agents[minScoreIdx].code + " " + agents[minScoreIdx].score);
    }
}

class Agent {
    String code;
    int score;

    public Agent(String code, int score) {
        this.code = code;
        this.score = score;
    }
}

