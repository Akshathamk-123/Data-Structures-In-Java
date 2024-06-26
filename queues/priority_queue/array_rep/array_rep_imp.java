package queues.priority_queue.array_rep;
import java.util.Arrays;
class array_rep_imp {
    private int[] queue;
    private int size;
    private int capacity;
    public array_rep_imp(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void insert(int item) {
        if (isFull()) {
            System.out.println("Priority Queue is full");
            return;
        }
        queue[size++] = item;
    }
    public int remove() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (queue[i] > queue[maxIndex]) {
                maxIndex = i;
            }
        }
        int maxValue = queue[maxIndex];
        queue[maxIndex] = queue[--size];
        return maxValue;
    }
    public void printQueue() {
        System.out.println("Priority Queue: " + Arrays.toString(Arrays.copyOf(queue, size)));
    }
    public static void main(String[] args) {
        array_rep_imp pq = new array_rep_imp(5);
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(20);
        pq.insert(40);
        pq.printQueue(); // Priority Queue: [30, 50, 10, 20, 40]
        System.out.println("Removed item: " + pq.remove()); // Removed item: 50
        pq.printQueue(); // Priority Queue: [30, 40, 10, 20]
    }
}
