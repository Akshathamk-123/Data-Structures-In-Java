package linked_list.doubly_linked_list.custom_implementation;

public class dll_implementation {
    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // Delete a node
    public void deleteNode(int key) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) return;

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    // Search for an element
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Update an element
    public void update(int oldData, int newData) {
        Node current = head;
        while (current != null) {
            if (current.data == oldData) {
                current.data = newData;
                return;
            }
            current = current.next;
        }
    }

    // Print the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        dll_implementation list = new dll_implementation();

        // Insertions
        list.insertAtBeginning(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtBeginning(0);

        // Print list
        System.out.println("Doubly Linked List:");
        list.printList();

        // Deletion
        list.deleteNode(3);
        System.out.println("After Deletion of 3:");
        list.printList();

        // Search
        System.out.println("Is 2 present? " + list.search(2));
        System.out.println("Is 5 present? " + list.search(5));

        // Update
        list.update(2, 20);
        System.out.println("After updating 2 to 20:");
        list.printList();
    }
}

