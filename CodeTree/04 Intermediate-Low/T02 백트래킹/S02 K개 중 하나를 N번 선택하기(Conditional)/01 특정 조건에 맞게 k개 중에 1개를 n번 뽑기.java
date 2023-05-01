import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	/*
		숫자를 선택할 때 자리수가 3이상이면서, 한 칸 전이과 두 칸 전 숫자가 같은 경우 pass
	 */

	static int k, n; // 1이상 k이하 숫자, 자리수 n
	static List<Integer> list = new ArrayList<>();

	static void choose(int pos) {
		if (pos == n + 1) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= k; i++) {
			// 연속한 3개의 숫자가 같은경우
			if (pos >= 3 &&
				list.get(list.size() - 1) == i &&
				list.get(list.size() - 2) == i) {
				continue;
			}
			list.add(i);
			choose(pos + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();

		// 출력
		choose(1);
	}
}


/**
 * 해설
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static int k, n;
	public static ArrayList<Integer> selectedNums = new ArrayList<>();

	// 선택된 원소들을 출력해줍니다.
	public static void printPermutation() {
		for(int i = 0; i < selectedNums.size(); i++)
			System.out.print(selectedNums.get(i) + " ");
		System.out.println();
	}

	public static void findPermutations(int cnt) {
		// n개를 모두 뽑은 경우 답을 출력해줍니다.
		if(cnt == n) {
			printPermutation();
			return;
		}

		for(int i = 1; i <= k; i++) {
			if(cnt >= 2 &&
				i == selectedNums.get(selectedNums.size() - 1) &&
				i == selectedNums.get(selectedNums.size() - 2))
				continue;

			selectedNums.add(i);
			findPermutations(cnt + 1);
			selectedNums.remove(selectedNums.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();
		n = sc.nextInt();

		findPermutations(0);
	}
}