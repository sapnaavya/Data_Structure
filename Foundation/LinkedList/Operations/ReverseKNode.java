/**
 This code reveses k node in the linkedlist in the following approach:
  1. Traverse till k and reverse first k nodes.
  2. call this reverse function recursively for next k nodes and  add prev in head.next
  3. return prev 
*/
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class ReverseKNode {
    static Node head;
    //insert in front
     public void insertFront(int data) { 
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //print List
    public static void printList(Node node) {
       //Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Reverse k node in the linkedlist
    public static Node reveseKNode(Node head, int k ) {
        if(head == null || k < 0) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int i = 0;
        while(current != null && i < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        if(next != null) {
            head.next = reveseKNode(next, k);
        }
        return prev;
    }

    //main method
    public static void main(String args[]) {
        ReverseKNode llist = new ReverseKNode();
        llist.insertFront(3);
        llist.insertFront(2);
        llist.insertFront(5);
        llist.insertFront(2);
        llist.insertFront(3);
        llist.insertFront(4);
        llist.insertFront(1);
        printList(head);
        int k = 4;
        System.out.print("\n");
        Node reverseKList = reveseKNode(head, k);
        printList(reverseKList);

    }
}