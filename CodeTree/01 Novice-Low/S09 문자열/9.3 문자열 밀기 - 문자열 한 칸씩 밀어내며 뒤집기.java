import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String str = sc.next();
        int queryCnt = sc.nextInt();

        // 쿼리 진행

        for (int i = 0; i < queryCnt; i++) {
            if (str.length() == 1) {
                System.out.println(str);
                continue;
            }

            int queryType = sc.nextInt();

            switch (queryType) {
                case 1:
                    str = query1(str);
                    break;
                case 2:
                    str = query2(str);
                    break;
                case 3:
                    str = query3(str);
                    break;
            }

            System.out.println(str);
        }
    }

    public static String query1(String str) {
        return str.substring(1) + str.substring(0, 1);
    }

    public static String query2(String str) {
        int len = str.length();
        return str.substring(len - 1, len) + str.substring(0, len - 1);
    }

    public static String query3(String str) {
        int len = str.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        if (len % 2 == 0) {
            sb1.append(str.substring(0, len / 2));
            sb2.append(str.substring(len / 2));
            sb1.reverse();
            sb2.reverse();
            sb2.append(sb1);
        } else {
            char center = str.charAt(len / 2);
            sb1.append(str.substring(0, len / 2));
            sb2.append(str.substring(len / 2 + 1));
            sb1.reverse();
            sb2.reverse();
            sb2.append(center);
            sb2.append(sb1);
        }

        return sb2.toString();
    }
}

// Try 2
import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int qCount = sc.nextInt();
        int len = str.length();

        for (int i = 0; i < qCount; i++) {
            int qType = sc.nextInt();

            if (len == 1) {
                System.out.println(str);
                continue;
            }

            char[] charArr = str.toCharArray();

            if (qType == 1) {
                query1(charArr);
            } else if (qType == 2) {
                query2(charArr);
            } else {
                query3(charArr);
            }

            str = new String(charArr);
            System.out.println(str);
        }
    }

    public static void query1(char[] arr) {
        char firstCh = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = firstCh;
    }

    public static void query2(char[] arr) {
        char lastCh = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastCh;
    }

    public static void query3(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }
}

// 해설 1: in-place - shift를 하거나 swap을 할 때 필요한 임시 변수를 활용하여 요청을 처리
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String inputStr = sc.next();
        int qNum = sc.nextInt();

        int strSize = inputStr.length();

        int qType;
        for (int i = 0; i < qNum; i++) {
            qType = sc.nextInt();
            if (qType == 1) {
                // step1: 가장 앞의 문자를 저장한 뒤,
                // step2: 문자열을 앞부터 순회하며 문자를 한 칸씩 앞으로 당기고
                // step3: 문자열의 제일 뒤에 가장 앞에 있던 문자를 넣어줍니다.
                char[] arr = inputStr.toCharArray();

                char front = arr[0];              // step1
                for (int j = 1; j < strSize; j++) // step2
                    arr[j - 1] = arr[j];
                arr[strSize - 1] = front;        // step3

                inputStr = new String(arr);
                System.out.println(inputStr);
            } else if (qType == 2) {
                // step1: 가장 뒤의 문자를 저장한 뒤,
                // step2: 문자열의 뒤부터 순회하며 문자를 한 칸씩 뒤로 밀어주고
                // step3: 문자열의 제일 앞에 가장 뒤에 있던 문자를 넣어줍니다.
                char[] arr = inputStr.toCharArray();

                char back = arr[strSize - 1];          // step1
                for (int j = strSize - 1; j >= 1; j--)  // step2
                    arr[j] = arr[j - 1];
                arr[0] = back;                            // step3

                inputStr = new String(arr);
                System.out.println(inputStr);
            } else if (qType == 3) {
                // 문자열의 앞부터 순회하며 좌우 대칭 위치에 있는 문자와 swap해줍니다.
                // 단, 문자열의 절반만 순회해줍니다.
                char[] arr = inputStr.toCharArray();

                char temp;
                for (int j = 0; j < strSize / 2; j++) {
                    temp = arr[j];
                    arr[j] = arr[strSize - j - 1];
                    arr[strSize - j - 1] = temp;
                }

                inputStr = new String(arr);
                System.out.println(inputStr);
            }
        }
    }
}

// 해설 2: 내장 함수 사용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String inputStr = sc.next();
        int qNum = sc.nextInt();

        int strSize = inputStr.length();

        int qType;
        for (int i = 0; i < qNum; i++) {
            qType = sc.nextInt();
            if (qType == 1) {
                // 문자열을 왼쪽으로 한 칸 쉬프트하고 문자열을 출력합니다.
                inputStr = inputStr.substring(1) + inputStr.substring(0, 1);
                System.out.println(inputStr);
            } else if (qType == 2) {
                // 문자열을 오른쪽으로 한 칸 쉬프트하고 문자열을 출력합니다.
                inputStr = inputStr.substring(strSize - 1) + inputStr.substring(0, strSize - 1);
                System.out.println(inputStr);
            } else if (qType == 3) {
                // 문자열을 좌우로 뒤집고 문자열을 출력합니다.
                StringBuffer sb = new StringBuffer(inputStr);
                inputStr = sb.reverse().toString();
                System.out.println(inputStr);
            }
        }
    }
}
