import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < arr.length; i++){
            String[] line = br.readLine().split(" ");

            for(int j=0; j < arr.length; j++){
                arr[i][j] = Integer.parseInt(line[i]);
            }
        }

    }
}


//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        n = Integer.parseInt(st.nextToken());
//                m = Integer.parseInt(st.nextToken());
