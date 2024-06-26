package queues.deque.lib_imp;
import java.util.Deque;
import java.util.LinkedList;
public class library_implementation {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        // Insert elements at the rear
        deque.addLast(10);
        deque.addLast(20);
        System.out.println("Deque: " + deque); // Deque: [10, 20]
        // Insert elements at the front
        deque.addFirst(5);
        System.out.println("Deque: " + deque); // Deque: [5, 10, 20]
        // Delete elements from the rear
        deque.removeLast();
        System.out.println("Deque after deleting from rear: " + deque); // Deque after deleting from rear: [5, 10]
        // Delete elements from the front
        deque.removeFirst();
        System.out.println("Deque after deleting from front: " + deque); // Deque after deleting from front: [10]
        // Get the front element
        System.out.println("Front item: " + deque.peekFirst()); // Front item: 10
        // Get the rear element
        System.out.println("Rear item: " + deque.peekLast()); // Rear item: 10
    }
}
