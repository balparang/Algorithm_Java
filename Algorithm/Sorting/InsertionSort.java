package Algorithm.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) { // j <- [i] 부터 [1]까지 감소
                if (arr[j] < arr[j - 1]) { // 한 칸씩 왼쪽으로 이동
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                else break; // 자기보다 작은 데이터를 만나면 멈춤
            }
        }

        for (int data : arr) {
            System.out.print(data + " ");
        }
    }
}
