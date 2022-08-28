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
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            students[i] = new Student(name, korean, english, math);
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
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        // 국, 영, 수 순으로 내림차순 정렬
        if (this.korean == student.korean) {
            if (this.english == student.english) {
                return student.math - this.math;
            }
            return student.english - this.english;
        }
        return student.korean - this.korean;
    }

    public String getInfo() {
        return String.format("%s %d %d %d", this.name, this.korean, this.english, this.math);
    }
}

/**
 * 해설
 */

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
        // 국어 점수가 높으면 정렬 했을 때 앞에 와야 합니다.
        if (this.korean != student.korean)
            return student.korean - this.korean;
        // 영어 점수가 높으면 정렬 했을 때 앞에 와야 합니다.
        if (this.english != student.english)
            return student.english - this.english;
        // 수학 점수가 높으면 정렬 했을 때 앞에 와야 합니다.
        return student.math - this.math;
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

        /* 람다식을 이용한 정렬
        Arrays.sort(A, (o1, o2) -> {
            if (o1.ko != o2.ko)
                return -(o1.ko - o2.ko);

            if (o1.en != o2.en)
                return -(o1.en - o2.en);

            return -(o1.ma - o2.ma);
            });
         */

        // 결과를 출력합니다.
        for (int i = 0; i < n; i++) {
            System.out.print(students[i].name + " ");
            System.out.print(students[i].korean + " ");
            System.out.print(students[i].english + " ");
            System.out.println(students[i].math);
        }
    }
}