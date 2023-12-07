public class Node {
    private int data;
    private Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Getter for data
    public int getData() {
        return data;
    }

    // Setter for data
    public void setData(int data) {
        this.data = data;
    }

    // Getter for next
    public Node getNext() {
        return next;
    }

    // Setter for next
    public void setNext(Node next) {
        this.next = next;
    }
}
