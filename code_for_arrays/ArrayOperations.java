package code_for_arrays;


public class ArrayOperations {

    // Traversal
    public static void traverseArray(int[] array) {
        // Time Complexity: O(n)
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Insertion
    public static int[] insertElement(int[] array, int index, int value) {
        // Time Complexity: Best: O(1), Worst: O(n), Average: O(n)
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        int[] newArray = new int[array.length + 1];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = array[j++];
            }
        }
        return newArray;
    }

    // Deletion
    public static int[] deleteElement(int[] array, int index) {
        // Time Complexity: Best: O(1), Worst: O(n), Average: O(n)
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[j++] = array[i];
        }
        return newArray;
    }

    // Search by index
    public static int searchElementByIndex(int[] array, int index) {
        // Time Complexity: O(1)
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    // Search by value
    public static int searchElementByValue(int[] array, int value) {
        // Time Complexity: O(n)
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // Element not found
    }

    // Update
    public static void updateElement(int[] array, int index, int value) {
        // Time Complexity: O(1)
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        array[index] = value;
    }

    // Main method to demonstrate the operations
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Traversal - O(n)
        System.out.println("Original Array:");
        traverseArray(array);

        // Insertion - O(n) in the worst case
        array = insertElement(array, 2, 10);
        System.out.println("After Insertion:");
        traverseArray(array);

        // Deletion - O(n) in the worst case
        array = deleteElement(array, 3);
        System.out.println("After Deletion:");
        traverseArray(array);

        // Search by index - O(1)
        int element = searchElementByIndex(array, 2);
        System.out.println("Element at index 2: " + element);

        // Search by value - O(n)
        int index = searchElementByValue(array, 10);
        System.out.println("Index of element 10: " + index);

        // Update - O(1)
        updateElement(array, 2, 20);
        System.out.println("After Update:");
        traverseArray(array);
    }
}
