import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    int h, w;
    int number;

    public Student(int h, int w, int number) {
        this.h = h;
        this.w = w;
        this.number = number;
    }

    @Override
    public int compareTo(Student student) {
        // 키 순 내림차순
        if (this.h != student.h) {
            return student.h - this.h;
        }
        // 키가 같으면, 몸무게 내림차순
        if (this.w != student.w) {
            return student.w - this.w;
        }
        // 몸무게마저 같으면 번호 오름차순
        return this.number - student.number;
    }

    public String getInfo() {
        return String.format("%d %d %d", h, w, number);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        Student[] students = new Student[n];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            students[i] = new Student(h, w, i + 1);
        }

        // 키, 몸무게 내림차순 정렬, 번호 오름차순 정렬
        Arrays.sort(students);

        // 출력
        for (Student student : students) {
            System.out.println(student.getInfo());
        }
    }
}

// 해설

import java.util.Scanner;
import java.util.Arrays;

// 학생들의 정보를 나타내는 클래스 선언
class Student implements Comparable<Student> {
    int height, weight, number;

    public Student(int height, int weight, int number){
        this.height = height;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public int compareTo(Student student) {
        // 키가 크면 정렬 했을 때 앞에 와야 합니다.
        if(this.height != student.height)
            return student.height - this.height;
        // 몸무게가 크면 정렬 했을 때 앞에 와야합니다.
        if(this.weight != student.weight)
            return student.weight - this.weight;
        // 번호가 작으면 앞에 와야 합니다.
        return this.number - student.number;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();

            // Student 객체를 생성해 리스트에 추가합니다.
            students[i] = new Student(height, weight, i + 1);
        }

        // custom comparator를 활용한 정렬
        Arrays.sort(students);

        // 결과를 출력합니다.
        for (int i = 0; i < n; i++){
            System.out.print(students[i].height + " ");
            System.out.print(students[i].weight + " ");
            System.out.println(students[i].number);
        }
    }
}