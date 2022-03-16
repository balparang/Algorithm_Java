package Algorithm.Sorting;

public class BubbleSort_Self {
    private static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }

    private static void bubbleSort(int[] arr, int end) {
        if (end > 0) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) { // 뒤에 것이 더 작으면 앞으로 보냄
                    swap(arr, i, i + 1);
                }
            }
            bubbleSort(arr, end - 1);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 1};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}

/*
실행결과
3, 5, 4, 2, 1,
1, 2, 3, 4, 5,
 */