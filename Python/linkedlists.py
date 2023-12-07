class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            while current.next is not None:
                current = current.next
            current.next = new_node

    def contains(self, data):
        current = self.head
        while current is not None:
            if current.data == data:
                return True
            current = current.next
        return False

    def size(self):
        count = 0
        current = self.head
        while current is not None:
            count += 1
            current = current.next
        return count

    def is_empty(self):
        return self.head is None

    def get(self, position):
        current = self.head
        for i in range(position):
            if current is None:
                return -1  # Assuming -1 indicates an error or an invalid value
            current = current.next
        if current is not None:
            return current.data
        else:
            return -1  # Assuming -1 indicates an error or an invalid value

    def remove(self, position):
        if self.head is None:
            return  # Nothing to remove

        current = self.head
        if position == 0:
            self.head = current.next
            del current
            return

        for i in range(position - 1):
            if current is None or current.next is None:
                return  # Position is out of bounds
            current = current.next

        next_node = current.next.next if current.next is not None else None
        del current.next
        current.next = next_node

    def __str__(self):
        result = []
        current = self.head
        while current is not None:
            result.append(str(current.data))
            current = current.next
            if current is not None:
                result.append(" -> ")
        result.append(" -> NULL")
        return "".join(result)


# Example usage
if __name__ == "__main__":
    my_list = LinkedList()

    # Append nodes to the list
    my_list.append(1)
    my_list.append(2)
    my_list.append(3)

    # Print the list
    print("Linked List:", my_list)

    # Check if the list contains 3
    print("List contains 3:", my_list.contains(3))

    # Get the size of the list
    print("Size of the list:", my_list.size())

    # Check if the list is empty
    print("Is the list empty:", my_list.is_empty())

    # Get data at position 1
    print("Data at position 1:", my_list.get(1))

    # Remove node at position 1
    my_list.remove(1)
    print("List after removing node at position 1:", my_list)
