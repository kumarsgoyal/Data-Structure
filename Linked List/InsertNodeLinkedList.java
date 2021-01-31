import java.util.*;

/*
	n this post, methods to insert a new node in linked list are discussed. A node can be added in three ways 
	1) At the front of the linked list 
	2) After a given node. 
	3) At the end of the linked list.
*/

class InsertNodeLinkedList {
	
	// head of linkedlist
	Node head;

	InsertNodeLinkedList() {
		head = null;
	}

	// Node class 
	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	// add element in front of list
	public void addElementFront(int num) {
		if(head == null) {
			head = new Node(num);
		}
		else {
			Node next = head;
			head = new Node(num);
			head.next = next;
		}
	}

	// add element in end of list
	public void addElementEnd(int num) {
		Node temp = head;
		if(head == null) {
			head = new Node(num);
		}
		else{
			while(temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Node(num);
		}
	}

	public void insert(int pos, int data) {
		// allocate and assign data
		Node new_node = new Node(data);
    	// if linked list is empty
    	if (head == null) {	
        	new_node.next = null;
        	head = new_node;
        	return;
    	}

    	Node temp = head;
    	Node prev = null;

    	while (temp != null && pos > 0)
    	{	
        	pos--;
        	prev = temp;
        	temp = temp.next;
    	}

    	prev.next = new_node;
    	new_node.next = temp;
}


	// print linked list
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("NULL\n");
	}

	public static void main(String[] args) {
		InsertNodeLinkedList ll = new InsertNodeLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);
		ll.addElementEnd(1);
        ll.addElementFront(2);
        ll.addElementEnd(3);
        ll.addElementFront(4);
		// 1 base indexing and insert after that postion
		ll.insert(3, 10);
		ll.insert(1, 20);
		ll.insert(10, 30);

		ll.printList();
	}
}