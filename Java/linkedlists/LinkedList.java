public class LinkedList {
    private Node head;
    private int count;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    // Getter for head
    public Node getHead() {
        return head;
    }

    // Setter for head
    public void setHead(Node head) {
        this.head = head;
    }

    // Getter for count
    public int getCount() {
        return count;
    }

    // Method to provide a string representation of the linked list
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                result.append(" -> ");
            } else {
                result.append(" -> NULL");
            }
            current = current.getNext();
        }
        return result.toString();
    }

    // Method to add a node to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        count++;
    }

    // Method to add a node at the specified position
    public void add(int position, int data) {
        if (position < 0 || position > count) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        count++;
    }

    // Method to check if the list contains a given element
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.getData() == data) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Method to get the size of the list
    public int size() {
        return count;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Method to get the data at a specific position
    public int get(int position) {
        if (position < 0 || position >= count) {
            System.out.println("Invalid position");
            return -1; // Assuming -1 indicates an error or an invalid position
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Method to remove a node at the specified position
    public void remove(int position) {
        if (position < 0 || position >= count) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            head = head.getNext();
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        count--;
    }
}
