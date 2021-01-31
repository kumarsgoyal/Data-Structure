#include <iostream>
using namespace std;

/*
	n this post, methods to insert a new node in linked list are discussed. A node can be added in three ways 
	1) At the front of the linked list 
	2) After a given node. 
	3) At the end of the linked list.
*/

class Node
{
public:
    int data;
    Node *next;
};

void push(struct Node **head, int data)
{
    // allocate node
    Node *new_node = new Node();
    //  put in the data
    new_node->data = data;
    // Make next of new node as head
    new_node->next = *head;
    //  move the head to point to the new node
    *head = new_node;
}

void append(struct Node **head, int data)
{
    // allocate node
    Node *new_node = new Node();
    // // put in the data
    new_node->data = data;
    // // This is new last or tail or linked list point to NULL
    new_node->next = NULL;

    if (*head == NULL)
    {
        *head = new_node;
        return;
    }

    // // temprarory node
    Node *temp = *head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = new_node;
}

void insert(struct Node **head, int pos, int data)
{
    // allocate Node
    Node *new_node = new Node();
    // put in the data
    new_node->data = data;
    // if linked list is empty
    if (*head == NULL)
    {
        new_node->next = NULL;
        *head = new_node;
        return;
    }

    Node *temp = *head;
    Node *prev = NULL;

    while (temp != NULL && pos > 0)
    {
        pos--;
        prev = temp;
        temp = temp->next;
    }

    prev->next = new_node;
    new_node->next = temp;
}

// print Linked List
void print(Node **head)
{
    Node *temp = *head;

    while (temp != NULL)
    {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << "NULL\n";
}

int main()
{
    Node *head = NULL;

    // append data in last of linked list
    append(&head, 6);
    // push data in begning of list
    push(&head, 4);
    append(&head, 10);
    push(&head, 2);
    // insert after specific postion 1 based indexing
    insert(&head, 4, 20);
    insert(&head, 1, 21);
    insert(&head, 10, 30);

    print(&head);
    return 0;
}
