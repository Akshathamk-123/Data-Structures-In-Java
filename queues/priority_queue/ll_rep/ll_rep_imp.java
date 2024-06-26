package queues.priority_queue.ll_rep;
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class ll_rep_imp {
    private Node front;
    public ll_rep_imp() {
        this.front = null;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void insert(int item) {
        Node newNode = new Node(item);
        if (isEmpty() || front.data <= item) {
            newNode.next = front;
            front = newNode;
        } else {
            Node current = front;
            while (current.next != null && current.next.data > item) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public int remove() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        int maxValue = front.data;
        front = front.next;
        return maxValue;
    }
    public void printQueue() {
        System.out.print("Priority Queue: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ll_rep_imp pq = new ll_rep_imp();
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(20);
        pq.insert(40);
        pq.printQueue(); // Priority Queue: 50 40 30 20 10
        System.out.println("Removed item: " + pq.remove()); // Removed item: 50
        pq.printQueue(); // Priority Queue: 40 30 20 10
    }
}
