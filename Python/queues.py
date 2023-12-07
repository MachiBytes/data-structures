class Queue:
    def __init__(self):
        self.array = []
        self.front = self.rear = -1

    def is_empty(self):
        return self.front == self.rear == -1

    def is_full(self):
        return len(self.array) == 10

    def enqueue(self, data):
        if not self.is_full():
            if self.is_empty():
                self.front = self.rear = 0
            else:
                self.rear = (self.rear + 1) % 10
            self.array.append(data)
            print(f"Enqueued: {data}")
        else:
            print("Queue is full. Cannot enqueue element.")

    def dequeue(self):
        if not self.is_empty():
            dequeued_element = self.array[self.front]
            if self.front == self.rear:
                self.front = self.rear = -1
            else:
                self.front = (self.front + 1) % 10
            print(f"Dequeued: {dequeued_element}")
        else:
            print("Queue is empty. Cannot dequeue element.")

    def peek(self):
        if not self.is_empty():
            return self.array[self.front]
        else:
            print("Queue is empty. Cannot peek.")
            return -1


# Example usage
if __name__ == "__main__":
    my_queue = Queue()
    my_queue.enqueue(1)
    my_queue.enqueue(2)
    my_queue.enqueue(3)
    print("Front of the queue:", my_queue.peek())
    my_queue.dequeue()
    my_queue.dequeue()
    my_queue.dequeue()
    my_queue.dequeue()
