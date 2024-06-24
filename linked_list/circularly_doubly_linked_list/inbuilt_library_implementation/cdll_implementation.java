package linked_list.circularly_doubly_linked_list.inbuilt_library_implementation;

import java.util.LinkedList;
import java.util.ListIterator;

public class cdll_implementation {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Insertions
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print list
        System.out.println("Circular Doubly Linked List (simulated):");
        printCircularDoublyList(list, 10); // Print 10 elements in circular manner

        // Deletion
        list.removeFirstOccurrence(3);
        System.out.println("After Deletion of 3:");
        printCircularDoublyList(list, 10);

        // Search
        System.out.println("Is 2 present? " + list.contains(2));
        System.out.println("Is 6 present? " + list.contains(6));

        // Update
        list.set(list.indexOf(2), 20);
        System.out.println("After updating 2 to 20:");
        printCircularDoublyList(list, 10);
    }

    // Helper method to print elements in circular manner
    public static void printCircularDoublyList(LinkedList<Integer> list, int count) {
        if (list.isEmpty()) return;

        @SuppressWarnings("unused")
        int size = list.size();
        ListIterator<Integer> iterator = list.listIterator();
        for (int i = 0; i < count; i++) {
            if (!iterator.hasNext()) {
                iterator = list.listIterator();
            }
            System.out.print(iterator.next() + " <-> ");
        }
        System.out.println("(head)");
    }
}
