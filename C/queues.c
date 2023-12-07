#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10

struct Queue {
    int array[MAX_SIZE];
    int front, rear, size;
};

void initQueue(struct Queue* queue) {
    queue->front = queue->rear = -1;
    queue->size = 0;
}

int isFull(struct Queue* queue) {
    return queue->size == MAX_SIZE;
}

int isEmpty(struct Queue* queue) {
    return queue->size == 0;
}

void enqueue(struct Queue* queue, int data) {
    if (!isFull(queue)) {
        if (isEmpty(queue)) {
            queue->front = queue->rear = 0;
        } else {
            queue->rear = (queue->rear + 1) % MAX_SIZE;
        }
        queue->array[queue->rear] = data;
        printf("Enqueued: %d\n", data);
        queue->size++;
    } else {
        printf("Queue is full. Cannot enqueue element.\n");
    }
}

void dequeue(struct Queue* queue) {
    if (!isEmpty(queue)) {
        int dequeuedElement = queue->array[queue->front];
        if (queue->front == queue->rear) {
            queue->front = queue->rear = -1;
        } else {
            queue->front = (queue->front + 1) % MAX_SIZE;
        }
        printf("Dequeued: %d\n", dequeuedElement);
        queue->size--;
    } else {
        printf("Queue is empty. Cannot dequeue element.\n");
    }
}

int peek(struct Queue* queue) {
    if (!isEmpty(queue)) {
        return queue->array[queue->front];
    } else {
        printf("Queue is empty. Cannot peek.\n");
        return -1; // Assuming -1 indicates an error or an invalid value
    }
}

int main() {
    struct Queue myQueue;
    initQueue(&myQueue);

    // Enqueue elements into the queue
    enqueue(&myQueue, 1);
    enqueue(&myQueue, 2);
    enqueue(&myQueue, 3);

    // Peek at the front element of the queue
    printf("Front of the queue: %d\n", peek(&myQueue));

    // Dequeue elements from the queue
    dequeue(&myQueue);
    dequeue(&myQueue);
    dequeue(&myQueue);

    // Attempt to dequeue from an empty queue
    dequeue(&myQueue);

    return 0;
}
