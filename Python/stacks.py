class Stack:
    def __init__(self):
        self.array = []
        self.top = -1

    def is_empty(self):
        return self.top == -1

    def is_full(self):
        return len(self.array) == 10

    def push(self, data):
        if not self.is_full():
            self.top += 1
            self.array.append(data)
            print(f"Pushed: {data}")
        else:
            print("Stack is full. Cannot push element.")

    def pop(self):
        if not self.is_empty():
            print(f"Popped: {self.array.pop()}")
            self.top -= 1
        else:
            print("Stack is empty. Cannot pop element.")

    def peek(self):
        if not self.is_empty():
            return self.array[self.top]
        else:
            print("Stack is empty. Cannot peek.")
            return -1


# Example usage
if __name__ == "__main__":
    my_stack = Stack()
    my_stack.push(1)
    my_stack.push(2)
    my_stack.push(3)
    print("Top of the stack:", my_stack.peek())
    my_stack.pop()
    my_stack.pop()
    my_stack.pop()
    my_stack.pop()
