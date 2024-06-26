package queues.circular_queue.array_rep;
class array_rep_imp {
    private int[] queue;
    private int front, rear, size, capacity;
    public array_rep_imp(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = size = 0;
        rear = capacity - 1;
    }
    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }
    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    // Add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }
    // Remove an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    // Get the front item of the queue
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
    // Get the rear item of the queue
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[rear];
    }
    public static void main(String[] args) {
        array_rep_imp queue = new array_rep_imp(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Dequeued item: " + queue.dequeue()); // Dequeued item: 10
        System.out.println("Front item: " + queue.front()); // Front item: 20
        System.out.println("Rear item: " + queue.rear()); // Rear item: 40
    }
}
