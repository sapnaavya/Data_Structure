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

    //Insert node after a position
    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        int i = 0;
        Node prevNode = null;
        Node currentNode = head;
        while(i < position) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if(currentNode == null) {
                System.out.println("reached the end of list");
                break;
            }
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
        
        //Check if new node is not the last node in the list
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