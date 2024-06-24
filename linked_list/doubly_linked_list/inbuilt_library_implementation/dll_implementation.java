package linked_list.doubly_linked_list.inbuilt_library_implementation;



import java.util.LinkedList;

public class dll_implementation {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Insertions
        list.addFirst(1);  // Insert at beginning
        list.addLast(2);   // Insert at end
        list.addLast(3);
        list.addLast(4);
        list.addFirst(0);  // Insert at beginning

        // Print list
        System.out.println("Doubly Linked List: " + list);

        // Deletion
        list.removeFirstOccurrence(3);  // Delete a specific element
        System.out.println("After Deletion of 3: " + list);

        // Search
        System.out.println("Is 2 present? " + list.contains(2));
        System.out.println("Is 5 present? " + list.contains(5));

        // Update
        list.set(2, 20);  // Update element at index 2
        System.out.println("After updating element at index 2 to 20: " + list);

        // Traversal
        System.out.print("Iterating over Doubly Linked List: ");
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

