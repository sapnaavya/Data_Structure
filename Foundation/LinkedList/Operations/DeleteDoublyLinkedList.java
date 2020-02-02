
/* A Java program with main method to delete nodes in the doubly linked list */

public class DeleteDoublyLinkedList {
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
        //check this if condition to avoid null pointer exception
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    //Print List
    public void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Delete at front
    public void deleteAtFront(Node node) {
        if(node == null) {
            System.out.println("node is empty...");
            return;
        }

        Node nextNode = node.next;
        node.next = null;
        //point head to the new next node
        head = nextNode;
    }

    //Delete at the end
    public void deleteAtEnd(Node node) {
        if(node == null) {
            System.out.println("node is empty...");
            return;
        }
        if(node.next == null) {
            System.out.println("List has only one element");
            head = null;
            return;
        }
        Node prev = null;
        while(node.next != null) {
            prev = node;
            node = node.next;
        }
        if(prev != null) {
            prev.next = null;
        }
    }

    //Delete after a certain position
    public void deleteAfterPosition(Node currentNode, int position) {
        int i = 0;
        Node prevNode = null;

        //check if current node itself is null or not
        if(currentNode == null) {
            System.out.println("No node to delete");
            return;
        }
        
        //Check if position to delete is 0
        if(position == 0) {
            prevNode = currentNode.next;
            currentNode = null;
            head = prevNode;
            return;
        }

        //Travere to that postion
        while(i < position) {
            prevNode =  currentNode;
            if(currentNode == null) {
                System.out.print("Reached end of the list");
                return;
            }
            i++;
            currentNode = currentNode.next;
        }
        
        // check if posistion to delete is not the last position. if yes, then simply mark the last node as null
        if(currentNode.next != null) {
            prevNode.next = currentNode.next;
            currentNode.next.prev = prevNode;
        }
        else{
            prevNode.next = null;
        }
    }



    //Main method
    public static void main(String args[]) {
        DeleteDoublyLinkedList llist =  new DeleteDoublyLinkedList();
        llist.InsertFront(54);
        llist.InsertFront(25);
        llist.InsertFront(30);
        llist.InsertFront(45);
        llist.printList(head);

        // llist.deleteAtFront(head);
        // llist.printList(head);

        // llist.deleteAtEnd(head);
        // llist.printList(head);

        llist.deleteAfterPosition(head, 3);
        System.out.println();
        System.out.print("Elements after deleting at the specific position:");
        llist.printList(head);
    }
}