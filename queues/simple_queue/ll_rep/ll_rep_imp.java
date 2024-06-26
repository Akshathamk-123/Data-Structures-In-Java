package queues.simple_queue.ll_rep;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class ll_rep_imp {
    private Node front, rear;
    @SuppressWarnings("unused")
    private int size;

    public ll_rep_imp() {
        this.front = this.rear = null;
        this.size = 0;
    }
    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    // Add an item to the queue
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            size++;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        size++;
    }
    // Remove an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }
    // Get the front item of the queue
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    // Get the rear item of the queue
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return rear.data;
    }
    public static void main(String[] args) {
        ll_rep_imp queue = new ll_rep_imp();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Dequeued item: " + queue.dequeue()); // Dequeued item: 10
        System.out.println("Front item: " + queue.front()); // Front item: 20
        System.out.println("Rear item: " + queue.rear()); // Rear item: 40
    }
}
