package queues.circular_queue.lib_imp;
import java.util.Queue;
import java.util.LinkedList;
public class library_implementation {
    private Queue<Integer> queue;
    private int capacity;
    public library_implementation(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }
    // Check if the queue is full
    public boolean isFull() {
        return queue.size() == capacity;
    }
    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    // Add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue.add(item);
    }
    // Remove an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue.poll();
    }
    // Get the front item of the queue
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue.peek();
    }
    // Get the rear item of the queue
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return ((LinkedList<Integer>) queue).peekLast();
    }
    public static void main(String[] args) {
        library_implementation queue = new library_implementation(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Dequeued item: " + queue.dequeue()); // Dequeued item: 10
        System.out.println("Front item: " + queue.front()); // Front item: 20
        System.out.println("Rear item: " + queue.rear()); // Rear item: 40
    }
}
