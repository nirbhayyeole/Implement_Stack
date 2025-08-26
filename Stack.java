package implement_stack;

/**
 * A simple implementation of Stack using a single array.
 * Provides standard stack operations: push, pop, peek, size, isEmpty.
 */
public class Stack {

    private int[] arr;      // Array to store stack elements
    private int top;        // Index of top element
    private int capacity;   // Maximum size of stack

    /**
     * Constructor to initialize stack.
     * 
     * @param size capacity of the stack
     */
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     * Push element to top of stack.
     * 
     * @param val element to push
     */
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Stack is Full! Cannot add element: " + val);
        }
        arr[++top] = val;
    }

    /**
     * Returns top element without removing it.
     * 
     * @return top element
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return arr[top];
    }

    /**
     * Removes and returns the top element.
     * 
     * @return popped element
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow! No elements to pop.");
        }
        return arr[top--];
    }

    /**
     * Checks if stack is empty.
     * 
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns current size of stack.
     * 
     * @return number of elements
     */
    public int size() {
        return top + 1;
    }

    /**
     * Checks if stack is full.
     * 
     * @return true if full, false otherwise
     */
    private boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Demo usage
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println("Stack size: " + stack.size());
        
        stack.push(1);
        stack.push(0);
        stack.push(3);

        System.out.println("Stack: " + stack);
        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        System.out.println("Stack size: " + stack.size());
    }
}
