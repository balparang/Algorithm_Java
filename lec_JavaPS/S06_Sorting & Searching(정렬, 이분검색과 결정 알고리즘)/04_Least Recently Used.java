import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

    public static int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1; // position(=index)

            // cache Hit 검사
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) { // Hit 발생
                    pos = i; // Hit이 발생한 인덱스 저장
                }
            }

            if (pos == -1) { // cache Miss 처리
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else { // cache Hit 처리
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }

            cache[0] = x;
        }

        return cache;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int data : solution(s, n, arr)) {
            System.out.print(data + " ");
        }
    }
}