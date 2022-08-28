import java.util.Arrays;
import java.util.Scanner;

class Coordinate {
    int x, y;
    int number; // 순서대로 부여되는 수

    public Coordinate(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

public class Main {
    static int n;
    static Coordinate[] coords;

    static void customSort() {
        Arrays.sort(coords, (o1, o2) -> {
            // 거리 계산
            int dist1 = Math.abs(o1.x) + Math.abs(o1.y);
            int dist2 = Math.abs(o2.x) + Math.abs(o2.y);

            // 거리가 같으면 번호 오름차순 정렬
            if (dist1 != dist2) {
                return dist1 - dist2;
            }
            return o1.number - o2.number;
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        coords = new Coordinate[n];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coords[i] = new Coordinate(x, y, i + 1);
        }

        // 원점으로부터의 거리가 작은 순으로 정렬,
        // 거리 같은 경우 번호 오름차순 정렬
        customSort();

        // 출력
        for (Coordinate c : coords) {
            System.out.println(c.number);
        }
    }
}

// 해설
import java.util.Scanner;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int dist;
    int index;

    public Point(int dist, int index){
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Point point) {
        // dist가 작으면 정렬 했을 때 앞에 와야 합니다.
        if(dist != point.dist)
            return dist - point.dist;
        // index가 작으면 정렬 했을 때 앞에 와야 합니다.
        return index - point.index;
    }
}

public class Main {
    public static final int MAXN = 1000;

    // 원점과의 거리를 계산하는 함수입니다.
    public static int getDistFromOrigin(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] point = new Point[MAXN];

        int x, y;
        for(int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            // 원점과의 거리와 index를 저장합니다.
            point[i] = new Point(getDistFromOrigin(x, y), i + 1);
        }

        Arrays.sort(point, 0, n);

        for(int i = 0; i < n; i++)
            System.out.println(point[i].index);

    }
}