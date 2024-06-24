package linked_list.circularly_doubly_linked_list.custom_implementation;


public class cdll_implementation {
    DoublyNode head;

    // Insert at end
    public void insertAtEnd(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            DoublyNode tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Delete a node
    public void deleteNode(int key) {
        if (head == null) return;

        DoublyNode current = head;

        do {
            if (current.data == key) {
                if (current.next == head && current.prev == head) {
                    head = null;
                    return;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                if (current == head) {
                    head = current.next;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Search for an element
    public boolean search(int key) {
        if (head == null) return false;

        DoublyNode current = head;
        do {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }

    // Update an element
    public void update(int oldData, int newData) {
        if (head == null) return;

        DoublyNode current = head;
        do {
            if (current.data == oldData) {
                current.data = newData;
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Print the list
    public void printList() {
        if (head == null) return;

        DoublyNode current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        cdll_implementation list = new cdll_implementation();

        // Insertions
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        // Print list
        System.out.println("Circular Doubly Linked List:");
        list.printList();

        // Deletion
        list.deleteNode(3);
        System.out.println("After Deletion of 3:");
        list.printList();

        // Search
        System.out.println("Is 2 present? " + list.search(2));
        System.out.println("Is 6 present? " + list.search(6));

        // Update
        list.update(2, 20);
        System.out.println("After updating 2 to 20:");
        list.printList();
    }
}

