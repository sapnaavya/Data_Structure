
/* A Java program with main method to delete nodes in the singly linked list */
public class DeleteSinglyLinkedList {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {data = d; next = null;}
    }

    //Insert at the beginning of the List
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Print all the elements of the list
    public void print() {
        Node node = head;
        while(node != null) {
            
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    //Delete at specific position in the list
    public static DeleteSinglyLinkedList deleteAtPosition(DeleteSinglyLinkedList list, int index) {
        Node currentNode = list.head;
        Node prev = null;

        // Case 0: when index is 0
        if(index == 0 && currentNode != null) {
            list.head = currentNode.next;
            System.out.println( index + " " + "position element deleted");
            return list;
        }

        // Case 1: when index is greater than 0
        int counter = 0;
        while(counter < index) {
            prev = currentNode;
            if(currentNode == null) {
                System.out.println(index + " " + "Position element not found");
                return list;
            }
            counter++;
            currentNode = currentNode.next;
        }

        if(currentNode.next != null){     // make sure to check for this if condition otherwise you will get null pointer exception
            prev.next  = currentNode.next;
            System.out.println(index + " " + "position element deleted");
        }
        else{
            prev.next = null;
        }
        
        return list;
    }

    //Main Method
    public static void main(String args[]) {
        DeleteSinglyLinkedList llist = new DeleteSinglyLinkedList();
        llist.insertFront(1);
        llist.insertFront(5);
        llist.insertFront(6);
        llist.insertFront(4);
        llist.insertFront(7);
        llist.insertFront(8);
        llist.insertFront(10);
        llist.print();

       deleteAtPosition(llist, 2);
       llist.print();
    }
}
