package Insertion_sort_array;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;

        // Outer loop for each position in the array
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j;
            
            // Inner loop to find the correct position for the key
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                // Shift elements to the right to make space for the key
                arr[j + 1] = arr[j];
            }
            
            // Insert the key into its correct position
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 0, 1, 8, 9, 7, 5};
        int sortedArray[] = insertionSort(arr);
        for (int element : sortedArray) {
            System.out.print(element + "\t");
        }
    }
}
