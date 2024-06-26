package queues.priority_queue.lib_imp;
import java.util.PriorityQueue;
public class library_implementation {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max-Heap Priority Queue
        pq.add(30);
        pq.add(50);
        pq.add(10);
        pq.add(20);
        pq.add(40);
        System.out.println("Priority Queue: " + pq); // Priority Queue: [50, 40, 10, 20, 30]
        System.out.println("Removed item: " + pq.poll()); // Removed item: 50
        System.out.println("Priority Queue: " + pq); // Priority Queue: [40, 30, 10, 20]
    }
}
