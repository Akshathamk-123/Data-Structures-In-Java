package linked_list.circularly_doubly_linked_list.custom_implementation;

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
