public class Queue {
    private int[] array;
    private int front, rear, size, capacity;

    // Default constructor with a default maximum capacity
    public Queue() {
        this(10); // Default capacity is set to 10
    }

    // Constructor with a specified maximum capacity
    public Queue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    // Method to enqueue an element into the queue
    public void enqueue(int data) {
        if (!isFull()) {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            array[rear] = data;
            size++;
            System.out.println("Enqueued: " + data);
        } else {
            System.out.println("Queue is full. Cannot enqueue element.");
        }
    }

    // Method to dequeue an element from the queue
    public void dequeue() {
        if (!isEmpty()) {
            int dequeuedElement = array[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            System.out.println("Dequeued: " + dequeuedElement);
        } else {
            System.out.println("Queue is empty. Cannot dequeue element.");
        }
    }

    // Method to peek at the front element of the queue
    public int peek() {
        if (!isEmpty()) {
            return array[front];
        } else {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Assuming -1 indicates an error or an invalid value
        }
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to provide a string representation of the queue
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty.";
        }
        StringBuilder result = new StringBuilder("Queue: | ");
        for (int i = 0; i < size; i++) {
            result.append(array[(front + i) % capacity]).append(" | ");
        }
        return result.toString();
    }
}
