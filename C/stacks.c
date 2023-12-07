#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10

struct Stack {
    int array[MAX_SIZE];
    int top;
};

void initStack(struct Stack* stack) {
    stack->top = -1;
}

int isFull(struct Stack* stack) {
    return stack->top == MAX_SIZE - 1;
}

int isEmpty(struct Stack* stack) {
    return stack->top == -1;
}

void push(struct Stack* stack, int data) {
    if (!isFull(stack)) {
        stack->array[++stack->top] = data;
        printf("Pushed: %d\n", data);
    } else {
        printf("Stack is full. Cannot push element.\n");
    }
}

void pop(struct Stack* stack) {
    if (!isEmpty(stack)) {
        printf("Popped: %d\n", stack->array[stack->top--]);
    } else {
        printf("Stack is empty. Cannot pop element.\n");
    }
}

int peek(struct Stack* stack) {
    if (!isEmpty(stack)) {
        return stack->array[stack->top];
    } else {
        printf("Stack is empty. Cannot peek.\n");
        return -1; // Assuming -1 indicates an error or an invalid value
    }
}

int main() {
    struct Stack myStack;
    initStack(&myStack);

    // Push elements onto the stack
    push(&myStack, 1);
    push(&myStack, 2);
    push(&myStack, 3);

    // Peek at the element on top of the stack
    printf("Top of the stack: %d\n", peek(&myStack));

    // Pop elements from the stack
    pop(&myStack);
    pop(&myStack);
    pop(&myStack);

    // Attempt to pop from an empty stack
    pop(&myStack);

    return 0;
}
