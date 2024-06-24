package stack.array_implementation;
public class stack_array_implementation{
    private static final int MAX_SIZE = 1000;
    private int[] stackArray;
    private int top; // Index of the top element, -1 when stack is empty

    public stack_array_implementation() {
        stackArray = new int[MAX_SIZE];
        top = -1;
    }

    // Push operation to add an element to the stack
    public void push(int value) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = value;
    }

    // Pop operation to remove and return the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; // Return a sentinel value or throw an exception
        }
        return stackArray[top--];
    }

    // Peek operation to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a sentinel value or throw an exception
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }

    // Print the elements of the stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stack_array_implementation stack = new stack_array_implementation();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // Stack: 10 20 30

        System.out.println("Popped element: " + stack.pop()); // Popped element: 30
        System.out.println("Top element: " + stack.peek()); // Top element: 20

        stack.printStack(); // Stack: 10 20
    }
}
