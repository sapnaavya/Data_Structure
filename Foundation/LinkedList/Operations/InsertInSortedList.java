/* A Java Program to insert in a sorted linked list*/

public class InsertInSortedList {
    static Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    // Insert node in sorted list
    public void insertInSortedList(int data) {
        Node newNode = new Node(data);

        // Special case: Head Node is null or data is less than head node it self
        if (head == null || newNode.data <= head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        //Locate the pointer before point of insertion
        else {
            Node currentNode = head;
            while (currentNode.next != null && currentNode.next.data < newNode.data) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
    
    //Print List
    public void printList(Node node) {
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    //Main method
    public static void main(String args[]) {
        InsertInSortedList llist = new InsertInSortedList();
        llist.insertInSortedList(3);
        llist.insertInSortedList(1);
        llist.insertInSortedList(7);
        llist.insertInSortedList(5);
        llist.insertInSortedList(5);
        llist.printList(head);
    }
}