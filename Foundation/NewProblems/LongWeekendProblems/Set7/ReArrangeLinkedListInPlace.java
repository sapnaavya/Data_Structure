/**
 * This code rearrange the list in below way:
    * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
    * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
    Input : 1-2-3-4-5-6
    Output : 1-6-2-5-3-4
    Reference: https://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
*/

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class ReArrangeLinkedListInPlace {

    // print linkedlist
    public static void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // function to reverse a linkedlist
    public static Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node next = null;
        Node prev = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // function to reorder a linkedlist
    public static void reOrderList(Node head) {
        if(head != null && head.next != null) {
            Node slow = head;
            Node fast = head;
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node second = slow.next;
            slow.next = null; // close the first part

            // Now we should have two list
            // Now, reverse the order of second list
            second = reverseList(second);
            
            Node p1 = head;
            Node p2 = second;
            // merge two lists here
            while(p2 != null) {
                Node temp1 = p1.next;
                Node temp2 = p2.next;

                p1.next = p2;
                p2.next = temp1;

                p1 = temp1;
                p2 = temp2;
            }
        }   
    }
    
    // main method
    public static void main(String args[]) {
        Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.next = n2;
		n2.next = n3;
        n3.next = n4;
        n4.next = n5;
		n5.next = n6;
 
		printList(n1);
		reOrderList(n1);
		printList(n1);
    }
}