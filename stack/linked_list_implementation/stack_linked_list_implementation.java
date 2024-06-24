package stack.linked_list_implementation;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class stack_linked_list_implementation {
    private Node top; // Top of the stack

    public stack_linked_list_implementation() {
        this.top = null;
    }

    // Push operation to add an element to the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation to remove and return the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; // Return a sentinel value or throw an exception
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Peek operation to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a sentinel value or throw an exception
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Print the elements of the stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        stack_linked_list_implementation stack = new stack_linked_list_implementation();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // Stack: 30 20 10

        System.out.println("Popped element: " + stack.pop()); // Popped element: 30
        System.out.println("Top element: " + stack.peek()); // Top element: 20

        stack.printStack(); // Stack: 20 10
    }
}

