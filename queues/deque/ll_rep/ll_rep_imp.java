package queues.deque.ll_rep;

class Node {
    int data;
    Node next, prev;

    public Node(int data) {
        this.data = data;
        this.next = this.prev = null;
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
    public boolean isEmpty() {
        return front == null;
    }
    public void insertFront(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }
    public void insertRear(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        size--;
        return item;
    }
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int item = rear.data;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        size--;
        return item;
    }
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return front.data;
    }
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return rear.data;
    }
    public static void main(String[] args) {
        ll_rep_imp deque = new ll_rep_imp();
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

