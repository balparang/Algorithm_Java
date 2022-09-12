import java.util.Arrays;
import java.util.Scanner;

class Person {
    String name;
    int h, w;

    public Person(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }
}

public class Main {
    static int n;
    static Person[] people;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        people = new Person[n];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int w = sc.nextInt();
            int h = sc.nextInt();

            people[i] = new Person(name, w, h);
        }

        // 키 기준 오름차순, 몸무게 기준 내림차순 정렬
        Arrays.sort(people, (o1, o2) -> {
            if (o1.h != o2.h) {
                return o1.h - o2.h;
            }
            return o2.w - o1.w;
        });

        // 출력
        for (Person p : people) {
            System.out.printf("%s %d %d\n", p.name, p.h, p.w);
        }
    }
}

// 해설
import java.util.Scanner;
        import java.util.Arrays;

// 학생들의 정보를 나타내는 클래스 선언
class Student implements Comparable<Student> {
    String name;
    int height;
    int weight;

    public Student(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student student) {
        // 키가 작으면 정렬 했을 때 앞에 와야 합니다.
        if (height != student.height)
            return height - student.height;
        // 몸무게가 크면 정렬 했을 때 앞에 와야 합니다.
        return student.weight - weight;
    }
};

public class Main {
    public static final int MAXN = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[MAXN];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            // Student 객체를 생성해 리스트에 추가합니다.
            students[i] = new Student(name, height, weight);
        }

        // custom comparator를 활용한 정렬
        Arrays.sort(students, 0, n);

        // 결과를 출력합니다.
        for (int i = 0; i < n; i++) {
            System.out.print(students[i].name + " ");
            System.out.print(students[i].height + " ");
            System.out.println(students[i].weight);
        }
    }
}