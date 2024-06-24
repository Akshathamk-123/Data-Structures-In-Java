package linked_list.circularly_singly_linked_list.inbuilt_library_implementation;
import java.util.LinkedList;

public class csll_implementation {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Insertions
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Print list
        System.out.println("Circular Linked List (simulated):");
        printCircularList(list, 10); // Print 10 elements in circular manner

        // Deletion
        list.removeFirstOccurrence(3);
        System.out.println("After Deletion of 3:");
        printCircularList(list, 10);

        // Search
        System.out.println("Is 2 present? " + list.contains(2));
        System.out.println("Is 6 present? " + list.contains(6));

        // Update
        list.set(list.indexOf(2), 20);
        System.out.println("After updating 2 to 20:");
        printCircularList(list, 10);
    }

    // Helper method to print elements in circular manner
    public static void printCircularList(LinkedList<Integer> list, int count) {
        if (list.isEmpty()) return;

        int size = list.size();
        for (int i = 0; i < count; i++) {
            System.out.print(list.get(i % size) + " -> ");
        }
        System.out.println("(head)");
    }
}

