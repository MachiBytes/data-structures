public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(5); // Set a maximum capacity of 5

        // Enqueue elements into the queue
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        // Peek at the front element of the queue
        System.out.println("Front of the queue: " + myQueue.peek());

        // Dequeue elements from the queue
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();

        // Attempt to dequeue from an empty queue
        myQueue.dequeue();

        // Attempt to enqueue into a full queue
        for (int i = 0; i < 7; i++) {
            myQueue.enqueue(i);
        }

        // Display the final state of the queue using toString
        System.out.println(myQueue);
    }
}
