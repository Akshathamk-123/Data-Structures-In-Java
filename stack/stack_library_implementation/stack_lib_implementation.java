package stack.stack_library_implementation;

import java.util.Stack;

public class stack_lib_implementation {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Print stack
        System.out.println("Stack: " + stack); // Stack: [10, 20, 30]

        // Pop operation
        System.out.println("Popped element: " + stack.pop()); // Popped element: 30

        // Peek operation
        System.out.println("Top element: " + stack.peek()); // Top element: 20

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Is stack empty? false

        // Size of the stack
        System.out.println("Size of stack: " + stack.size()); // Size of stack: 2
    }
}
