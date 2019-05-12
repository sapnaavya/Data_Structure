/* A java program to remove nth node from the last as length of the list is unknown */

public class NthNodeFromLast {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {data = d; next=null;}
    }
    //static Node head = null;

    //Insert at the fron
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Print List
    public void printList(Node head) {
        Node node = head;
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    /*Return nth node from the last. 
        For example, if n=0 then last element in the list and if n=1 then second last element in the list */
    public Node nthElemFromLast(Node head, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        Node p1 = head;
        Node p2 = head;
        for(int i=0; i<n; i++) {
            p1 = p1.next;
        }
        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //Main method
    public static void main(String argsp[]) {
        NthNodeFromLast llist = new NthNodeFromLast();
        llist.insertFront(5);
        llist.insertFront(10);
        llist.insertFront(15);
        llist.insertFront(20);
        llist.insertFront(25);
        llist.insertFront(30);
        llist.printList(head);

        Node nthElementfromLast = llist.nthElemFromLast(head,0);
        System.out.println("Nth element from the last: " + nthElementfromLast.data);

    }
}