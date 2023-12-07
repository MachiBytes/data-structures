#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* create_node(int data) {
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}

void append(struct Node** head, int data) {
    struct Node* new_node = create_node(data);
    if (*head == NULL) {
        *head = new_node;
    } else {
        struct Node* current = *head;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = new_node;
    }
}

int contains(struct Node* head, int data) {
    while (head != NULL) {
        if (head->data == data) {
            return 1; // True
        }
        head = head->next;
    }
    return 0; // False
}

int size(struct Node* head) {
    int count = 0;
    while (head != NULL) {
        count++;
        head = head->next;
    }
    return count;
}

int is_empty(struct Node* head) {
    return head == NULL;
}

int get(struct Node* head, int position) {
    for (int i = 0; i < position && head != NULL; i++) {
        head = head->next;
    }
    if (head != NULL) {
        return head->data;
    } else {
        // Handle an out-of-bounds position
        return -1; // Assuming -1 indicates an error or an invalid value
    }
}

void remove_node(struct Node** head, int position) {
    if (*head == NULL) {
        return; // Nothing to remove
    }

    struct Node* temp = *head;
    if (position == 0) {
        *head = temp->next;
        free(temp);
        return;
    }

    for (int i = 0; temp != NULL && i < position - 1; i++) {
        temp = temp->next;
    }

    if (temp == NULL || temp->next == NULL) {
        return; // Position is out of bounds
    }

    struct Node* next_node = temp->next->next;
    free(temp->next);
    temp->next = next_node;
}

void print_list(struct Node* head) {
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

int main() {
    struct Node* my_list = NULL;

    // Append nodes to the list
    append(&my_list, 1);
    append(&my_list, 2);
    append(&my_list, 3);

    // Print the list
    printf("Linked List: ");
    print_list(my_list);

    // Check if the list contains 3
    printf("List contains 3: %s\n", contains(my_list, 3) ? "True" : "False");

    // Get the size of the list
    printf("Size of the list: %d\n", size(my_list));

    // Check if the list is empty
    printf("Is the list empty: %s\n", is_empty(my_list) ? "True" : "False");

    // Get data at position 1
    printf("Data at position 1: %d\n", get(my_list, 1));

    // Remove node at position 1
    remove_node(&my_list, 1);
    printf("List after removing node at position 1: ");
    print_list(my_list);

    // Free allocated memory
    while (my_list != NULL) {
        struct Node* temp = my_list;
        my_list = my_list->next;
        free(temp);
    }

    return 0;
}
