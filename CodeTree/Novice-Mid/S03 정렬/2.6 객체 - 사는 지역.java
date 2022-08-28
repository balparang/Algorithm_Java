import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int n;
    static Person[] people;
    static String[] names;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        people = new Person[n];
        names = new String[n];

        // 인스턴스 생성
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String address = sc.next();
            String location = sc.next();

            people[i] = new Person(name, address, location);
            names[i] = name;
        }

        // 이름만 담는 배열을 역순 정렬
        Arrays.sort(names, Collections.reverseOrder());

        // 역순 정렬된 이름 배열의 첫 번째 원소와 매칭되는 인스턴스의 정보 출력
        for (int i = 0; i < n; i++) {
            if (people[i].name.equals(names[0])) {
                printInfo(people[i]);
                break;
            }
        }
    }

    private static void printInfo(Person person) {
        System.out.println("name " + person.name);
        System.out.println("addr " + person.address);
        System.out.println("city " + person.location);
    }
}

class Person {
    String name;
    String address; // 000-0000
    String location;

    public Person(String name, String address, String location) {
        this.name = name;
        this.address = address;
        this.location = location;
    }
}

// 해설
import java.util.Scanner;

// Person 정보를 나타내는 클래스 선언
class Person {
    String name;
    String streetAddress;
    String region;

    public Person(String name, String streetAddress, String region) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.region = region;
    }

    Person() {
    }
};

public class Main {
    public static final int MAXN = 10;

    public static Person[] people = new Person[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언 및 입력
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String address = sc.next();
            String region = sc.next();

            // 객체 생성 및 리스트에 추가
            people[i] = new Person(name, address, region);
        }

        // 사전순으로 이름이 가장 느린 사람 찾기
        int lastIdx = 0;
        for (int i = 1; i < n; i++) {
            // [lastIdx]의 name이 [i]의 name보다 사전순으로 느리면,
            // lastIdx를 i로 갱신
            if (people[i].name.compareTo(people[lastIdx].name) > 0)
                lastIdx = i;
        }

        // 결과를 출력합니다.
        System.out.println("name " + people[lastIdx].name);
        System.out.println("addr " + people[lastIdx].streetAddress);
        System.out.println("city " + people[lastIdx].region);
    }
}