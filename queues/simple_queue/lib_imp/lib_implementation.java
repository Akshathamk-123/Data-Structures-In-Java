package queues.simple_queue.lib_imp;
import java.util.LinkedList;
import java.util.Queue;

public class lib_implementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue operation
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        // Print queue
        System.out.println("Queue: " + queue); // Queue: [10, 20, 30, 40]

        // Dequeue operation
        System.out.println("Dequeued item: " + queue.poll()); // Dequeued item: 10

        // Front operation
        System.out.println("Front item: " + queue.peek()); // Front item: 20

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Is queue empty? false

        // Size of the queue
        System.out.println("Size of queue: " + queue.size()); // Size of queue: 3
    }
}

