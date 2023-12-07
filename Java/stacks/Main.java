public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(5); // Set a maximum capacity of 5

        // Push elements onto the stack
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        // Peek at the element on top of the stack
        System.out.println("Top of the stack: " + myStack.peek());

        // Pop elements from the stack
        myStack.pop();
        myStack.pop();
        myStack.pop();

        // Attempt to pop from an empty stack
        myStack.pop();

        // Attempt to push onto a full stack
        for (int i = 0; i < 7; i++) {
            myStack.push(i);
        }

        // Display the final state of the stack using toString
        System.out.println(myStack);
    }
}
