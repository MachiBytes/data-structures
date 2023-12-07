public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        // Add nodes to the end of the list
        myList.add(1);
        myList.add(2);
        myList.add(3);

        // Print the initial list
        System.out.println("Initial List: " + myList);

        // Add a node at position 1
        myList.add(1, 99);
        System.out.println("List after adding 99 at position 1: " + myList);

        // Check if the list contains 3
        System.out.println("List contains 3: " + myList.contains(3));

        // Get the size of the list
        System.out.println("Size of the list: " + myList.size());

        // Check if the list is empty
        System.out.println("Is the list empty: " + myList.isEmpty());

        // Get data at position 2
        System.out.println("Data at position 2: " + myList.get(2));

        // Remove node at position 2
        myList.remove(2);
        System.out.println("List after removing node at position 2: " + myList);
    }
}