"""
	n this post, methods to insert a new node in linked list are discussed. A node can be added in three ways 
	1) At the front of the linked list 
	2) After a given node. 
	3) At the end of the linked list.
"""

# Node class


class Node:
    # function to intialise the node object or constructor
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    # function to intialise the linkedlist object
    def __init__(self):
        self.head = None

    # push in front of linked list
    def push(self, new_data):
        # allocate and assign new Node
        new_node = Node(new_data)
        # make next of the new Node as head
        new_node.next = self.head
        # move the head to point to new Node
        self.head = new_node

    # append in last of linked list
    def append(self, new_data):
        # allocate and assign Node
        new_node = Node(new_data)

        # if linked list is empty
        if self.head is None:
            self.head = new_node
            return

        # else traverse till the last node
        last = self.head
        while(last.next):
            last = last.next

        last.next = new_node

    def insertAfter(self, pos, new_data):
        new_node = Node(new_data)

        # if head ids null
        if self.head is None:
            self.head = new_node
            return

        temp = self.head
        prev = None
        while(temp and pos > 0):
            pos = pos - 1
            prev = temp
            temp = temp.next

        prev.next = new_node
        new_node.next = temp

    def printf(self):
        temp = self.head

        while(temp):
            # end=" " because python print always in new line
            # to avoid add end=" " as 2nd argument
            print(str(temp.data) + '->', end=" ")
            temp = temp.next
        print('NULL')


if __name__ == '__main__':
    # start with empty linked list
    print('a')
    llist = LinkedList()
    print('a')
    llist.append(5)  # add in last
    llist.push(1)  # add in end
    llist.append(6)  # add in last
    llist.push(2)  # add in end
    llist.insertAfter(3, 10)
    llist.insertAfter(1, 20)
    llist.insertAfter(10, 30)

    llist.printf()
