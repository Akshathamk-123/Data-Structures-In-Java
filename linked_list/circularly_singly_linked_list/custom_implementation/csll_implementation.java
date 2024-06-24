package linked_list.circularly_singly_linked_list.custom_implementation;


public class csll_implementation {
    Node head;

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // Delete a node
    public void deleteNode(int key) {
        if (head == null) return;

        if (head.data == key && head.next == head) {
            head = null;
            return;
        }

        Node current = head, prev = null;
        while (current.next != head && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current.data == key) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
        }
    }

    // Search for an element
    public boolean search(int key) {
        if (head == null) return false;

        Node current = head;
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

        Node current = head;
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

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        csll_implementation list = new csll_implementation();

        // Insertions
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        // Print list
        System.out.println("Circular Linked List:");
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

