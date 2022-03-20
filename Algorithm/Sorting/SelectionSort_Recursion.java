/*
참고 : https://www.youtube.com/watch?v=uCUu3fF5Dws&ab_channel=%EC%97%94%EC%A7%80%EB%8B%88%EC%96%B4%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD
 */
package Algorithm.Sorting;

public class SelectionSort_Recursion {
    private static void selectionSort(int[] arr) {
        selectionSort(arr, 0);
    }

    private static void selectionSort(int[] arr, int start) { // Overriding
        if (start < arr.length - 1) {
            int min_index = start;
            for (int i = start; i < arr.length; i++) {
                if (arr[i] < arr[min_index]) min_index = i;
            }
            swap(arr, start, min_index);
            selectionSort(arr, start + 1);
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
        int[] arr = {3, 4, 1, 8, 7, 2, 5};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
