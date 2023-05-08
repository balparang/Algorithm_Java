/*
	모든 경우의 순열 생성. n이 4일 경우 1111~4444 생성
	순열을 생성하고, 해당 숫자가 아름다운 수 이면 cnt++
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> nums = new ArrayList<>();
	static int prettyCnt;
	static int n;

	// pos번째 숫자를 고르는 함수
	static void choose(int pos) {
		if (pos == n + 1) {
			if (isPretty(nums)) {
				prettyCnt++;
			}
			return;
		}

		for (int num = 1; num <= 4; num++) {
			nums.add(num);
			choose(pos + 1);
			nums.remove(nums.size() - 1);
		}
	}

	static boolean isPretty(List<Integer> nums) {

		// 한 자리 숫자인 경우
		if (nums.size() == 1)
			return nums.get(0) == 1;

		int[] arr = nums.stream().mapToInt(num -> num).toArray();
		int cnt = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				cnt++;
				continue;
			}

			if (cnt % arr[i - 1] != 0) {
				return false;
			}

			cnt = 1;
		}

		if (cnt % arr[arr.length - 1] != 0) {
			return false;
		}

		System.out.println(nums);
		return true;
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		choose(1);

		// 출력
		System.out.println(prettyCnt);
	}
}

/**
 * 해설: 특정 숫자의 배수를 확인할 때 반복문에서 그만큼 건너뛰는 방식
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static int n;
	public static int ans;
	public static ArrayList<Integer> seq = new ArrayList<>();

	public static boolean isBeautiful() {
		// 연달아 같은 숫자가 나오는 시작 위치를 잡습니다.
		for(int i = 0; i < n; i += seq.get(i)) {
			// 만약 연속하여 해당 숫자만큼 나올 수 없다면
			// 아름다운 수가 아닙니다.
			if(i + seq.get(i) - 1 >= n)
				return false;
			// 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인합니다.
			// 하나라도 다른 숫자가 있다면
			// 아름다운 수가 아닙니다.
			for(int j = i; j < i + seq.get(i); j++)
				if(seq.get(j) != seq.get(i))
					return false;
		}
		return true;
	}

	public static void countBeautifulSeq(int cnt) {
		if(cnt == n) {
			if(isBeautiful())
				ans++;
			return;
		}

		for(int i = 1; i <= 4; i++) {
			seq.add(i);
			countBeautifulSeq(cnt + 1);
			seq.remove(seq.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		countBeautifulSeq(0);

		System.out.print(ans);
	}
}