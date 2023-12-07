public class Stack {
    private int[] array;
    private int top, capacity;

    // Default constructor with a default maximum capacity
    public Stack() {
        this(10); // Default capacity is set to 10
    }

    // Constructor with a specified maximum capacity
    public Stack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    // Method to push an element onto the stack
    public void push(int data) {
        if (!isFull()) {
            array[++top] = data;
            System.out.println("Pushed: " + data);
        } else {
            System.out.println("Stack is full. Cannot push element.");
        }
    }

    // Method to pop an element from the stack
    public void pop() {
        if (!isEmpty()) {
            System.out.println("Popped: " + array[top--]);
        } else {
            System.out.println("Stack is empty. Cannot pop element.");
        }
    }

    // Method to peek at the element on top of the stack
    public int peek() {
        if (!isEmpty()) {
            return array[top];
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Assuming -1 indicates an error or an invalid value
        }
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to provide a string representation of the stack
    public String toString() {
        StringBuilder result = new StringBuilder("Stack: [");
        for (int i = 0; i <= top; i++) {
            result.append(array[i]);
            if (i < top) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
