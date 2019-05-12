
class InsertSingleLinkedList
{ 
    Node head;  // head of list 
    /* Node Class */
    class Node 
    { 
        int data; 
        Node next;    
        // Constructor to create a new node 
        Node(int d) {data = d; next = null; } 
    } 

    //Insert at the beginning of the List
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Insert at the end of the List
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        //Considering if head is null
        if(head == null) {
            Node head = new Node(data);
            return;
        }

        Node node = head;
        newNode.next = null;
        while(node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    //Insert after previous node
    public void insertAfter(Node prev_node, int data) {
        Node newNode = new Node(data);
        if(prev_node == null) {
            System.out.println("Given previous node can not be null");
            return;
        }

        newNode.next = prev_node.next;
        prev_node.next = newNode;
    }

    //Insert at the certain position
    public void insertAtNthPosition(int position, int data) {
       Node newNode = new Node(data);
       if(head == null) {
           if(position != 0) {
               return;
            } 
            else {
               head = newNode;
               return;
            }
        }

        if(head != null && position == 0) {
            newNode.next = head;
            head = newNode.next;
            return;
        }
        
        int i = 0;
        Node currentNode = head;
        Node previousNode = null;
        while(i < position) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            if(currentNode == null) {
                break;
            }
            i++;
        }
        previousNode.next = newNode;
        newNode.next = currentNode;
        //newNode.next = previousNode.next;
        //previousNode.next = newNode;
    }

    //Print the whole list
    public void print() {
        Node node = head;
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    //main method
    public static void main(String args[]) {
        InsertSingleLinkedList llist = new InsertSingleLinkedList();
        llist.insertFront(5);
        llist.print();

        llist.insertEnd(10);
        llist.print();
        llist.insertEnd(15);
        llist.print();
        
        llist.insertAfter(llist.head.next.next, 3);
        llist.print();

        llist.insertAtNthPosition(1, 2);
        llist.print();
    }
}