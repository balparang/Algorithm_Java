package Algorithm.Sorting;

public class SelectionSort_NestedLoop {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n; i++) {
            // 굳이 min변수를 사용 안하고 min_index로도 충분함
            int min_index = i; // 가장 작은 원소의 인덱스 
            for (int j = i + 1; j < n; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            // 스와프
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}