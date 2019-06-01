/* A Java program to insert a node at various position(Front, End, Specific position, After Node, Before Node) in Doubly Linked List */
public class InsertDoublyLinkedList {
    static Node head;
    class Node {   
        int data;
        Node prev;
        Node next;
        Node(int d) {data = d;}
    }

    //Insert node at the front of doubly linked list
    public void InsertFront(int data) {
        Node newNode = new Node(data);
        newNode.prev = null;
        newNode.next = head;

        //check for this if condition otherwise we may get null pointer exception
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    //Insert node at the end of the linkedList
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node node = head;
        Node emptyNode = null;
        while(node.next != null) {
            node = node.next;
        }
        newNode.prev = node;
        node.next = newNode;
        newNode.next = emptyNode;
    }

    //Insert node after a position... always make sure to take prev node and curr node while searching for index
    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        int i = 0;
        Node prevNode = null;
        Node currentNode = head;
        while(i < position) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            // this if condition is necessary to check if index is bigger then linkedlist lenght.. I
            // if current node is null that mean we have traversed whole list and still could not found the index
            if(currentNode == null) {
                System.out.println("reached the end of list");
                break;
            }
            //this break statment can be avoided if we add this if statement check in while loop itsef
            // for example, while(i < position && currentNode != null) {
            
            i++;
        }
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = currentNode;
        currentNode.prev = newNode;
    }

    //Insert after a node
    public void insertAfterNode(Node node1, int data) {
        Node newNode = new Node(data);
        if(node1 == null) {
            System.out.println("node can not be empty...");
            return;
        }

        Node nextNode = node1.next;
        node1.next = newNode;
        newNode.prev = node1;
        newNode.next = nextNode;
        
        //Check if next pointer to node1 is not the last node in the list.. to avoid null pointer exception
        if (nextNode != null) {
            nextNode.prev = newNode;
        }
    }

    //Insert before a node
    public void insertBeforeNode(Node currentNode, int data) {
        if(currentNode == null) {
            System.out.println("current node can not be empty");
            return ;
        }

        Node newNode = new Node(data);
        Node prevNode = currentNode.prev;
        newNode.next =  currentNode;
        currentNode.prev = newNode;

        //check if prev node is not null to avoid null pointer exception 
        // if prev node is null that mean we are inserting node at the beginning
        if(prevNode != null){
            newNode.prev = prevNode;
            prevNode.next = newNode;
        }
        else {
            newNode.prev = null;
            head = newNode;
        }
    }

    //Print List - Forward
    public void printListForward(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Print List - Backward
    public void printListBackward(Node node) {
        Node last = null;
        while(node != null) {
            last = node;
            node = node.next;
        }

        while(last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    //Main method
    public static void main(String args[]) {
        InsertDoublyLinkedList llist = new InsertDoublyLinkedList();
        llist.InsertFront(5);
        llist.InsertFront(10);
        llist.printListForward(head);

        //Insert at end
        llist.insertAtEnd(56);
        llist.printListBackward(head);

        //Insert at position
        llist.insertAtPosition(2, 24);
        llist.printListForward(head);

        //Insert after node
        llist.insertAfterNode(head.next, 23);
        llist.printListForward(head);

        //Insert before node
        llist.insertBeforeNode(head, 22);
        llist.printListForward(head);
    }
}