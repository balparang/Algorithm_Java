import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable<Person> {
    String name;
    int h;
    double w;

    public Person(String name, int h, double w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }

    public String getInfo() {
        return String.format("%s %d %.1f", name, h, w);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수
        int n = 5;
        Person[] people = new Person[5];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int h = sc.nextInt();
            double w = sc.nextDouble();

            people[i] = new Person(name, h, w);
        }

        // 이름순 오름차순 정렬
        Arrays.sort(people);

        // 출력
        System.out.println("name");
        print(people);
        System.out.println();

        // 키 내림차순 정렬
        Arrays.sort(people, (a, b) -> b.h - a.h);

        // 출력
        System.out.println("height");
        print(people);
    }

    static void print(Person[] people) {
        for (Person person : people) {
            System.out.println(person.getInfo());
        }
    }
}

// 해설 - custom comparator
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

// 학생들의 정보를 나타내는 클래스 선언
class Student {
    String name;
    int height;
    double weight;

    public Student(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력:
        int n = 5;
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            double weight = sc.nextDouble();

            // Student 객체를 생성해 리스트에 추가합니다.
            students[i] = new Student(name, height, weight);
        }

        // custom comparator를 활용한 정렬
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) { // 이름 기준 오름차순 정렬합니다.
                return a.name.compareTo(b.name);
            }
        });

        // 이름순으로 정렬한 결과를 출력합니다.
        System.out.println("name");
        for (int i = 0; i < n; i++) {
            System.out.print(students[i].name + " ");
            System.out.print(students[i].height + " ");
            System.out.printf("%.1f\n", students[i].weight);
        }

        System.out.println();

        // custom comparator를 활용한 정렬
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) { // 키 기준 내림차순 정렬합니다.
                return b.height - a.height;
            }
        });

        // 키순으로 정렬한 결과를 출력합니다.
        System.out.println("height");
        for (int i = 0; i < n; i++) {
            System.out.print(students[i].name + " ");
            System.out.print(students[i].height + " ");
            System.out.printf("%.1f\n", students[i].weight);
        }
    }
}