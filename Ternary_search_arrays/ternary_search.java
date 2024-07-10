package Ternary_search_arrays;

public class ternary_search {
    public static int[] sorting(int[] arr) {
        // Linear Sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int ternarysearch(int[] arr, int target, int low, int upper) {
        if (low > upper) {
            return -1; // Target not found
        }

        int mid1 = low + (upper - low) / 3;
        int mid2 = upper - (upper - low) / 3;

        if (arr[mid1] == target) {
            return mid1;
        }
        if (arr[mid2] == target) {
            return mid2;
        }

        if (target < arr[mid1]) {
            return ternarysearch(arr, target, low, mid1 - 1);
        } else if (target > arr[mid2]) {
            return ternarysearch(arr, target, mid2 + 1, upper);
        } else {
            return ternarysearch(arr, target, mid1 + 1, mid2 - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 0, 1, 8, 9, 7, 5};
        int target = 0;
        int sorted[] = sorting(arr);
        int low = 0;
        int upper = arr.length - 1;
        int result1 = ternarysearch(sorted, target, low, upper);

        for (int elem : sorted) {
            System.out.print(elem + "\t");
        }
        System.out.println();

        if (result1 != -1) {
            System.out.println("The position of the element is " + result1);
        } else {
            System.out.println("The element doesn't exist in the array");
        }
    }
}
