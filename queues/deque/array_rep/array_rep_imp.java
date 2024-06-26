package queues.deque.array_rep;
class array_rep_imp {
    private int[] deque;
    private int front, rear, size, capacity;
    public array_rep_imp(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void insertFront(int item) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front = front - 1;
        }
        deque[front] = item;
        size++;
    }
    public void insertRear(int item) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        deque[rear] = item;
        size++;
    }
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int item = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        size--;
        return item;
    }
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int item = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear = rear - 1;
        }
        size--;
        return item;
    }
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return deque[front];
    }
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return deque[rear];
    }
    public static void main(String[] args) {
        array_rep_imp deque = new array_rep_imp(5);
        deque.insertRear(5);
        deque.insertRear(10);
        System.out.println("Rear item: " + deque.getRear()); // Rear item: 10
        deque.deleteRear();
        System.out.println("Rear item: " + deque.getRear()); // Rear item: 5
        deque.insertFront(15);
        System.out.println("Front item: " + deque.getFront()); // Front item: 15
        deque.deleteFront();
        System.out.println("Front item: " + deque.getFront()); // Front item: 5
    }
}
