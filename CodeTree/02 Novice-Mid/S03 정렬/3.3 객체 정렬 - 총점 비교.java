import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        Student[] students = new Student[n];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            students[i] = new Student(name, a, b, c);
        }

        // 정렬
        Arrays.sort(students);

        // 출력
        for (Student student : students) {
            System.out.println(student.getInfo());
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int a, b, c;

    public Student(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getInfo() {
        return String.format("%s %d %d %d", this.name, this.a, this.b, this.c);
    }

    @Override
    public int compareTo(Student o) {
        // 점수 총합 기준 오름차순
        return (this.a + this.b + this.c) - (o.a + o.b + o.c);
    }
}

// 해설
import java.util.Scanner;
import java.util.Arrays;

// 학생들의 정보를 나타내는 클래스 선언
class Student implements Comparable<Student> {
    String name;
    int korean, english, math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        // 세 점수의 합이 오름차순이 되도록 정렬합니다.
        return (this.korean + this.english + this.math) -
                (student.korean + student.english + student.math);
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            // Student 객체를 생성해 리스트에 추가합니다.
            students[i] = new Student(name, korean, english, math);
        }

        // custom comparator를 활용한 정렬
        Arrays.sort(students);

        // 결과를 출력합니다.
        for (int i = 0; i < n; i++) {
            System.out.print(students[i].name + " ");
            System.out.print(students[i].korean + " ");
            System.out.print(students[i].english + " ");
            System.out.println(students[i].math);
        }
    }
}