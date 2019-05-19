/* Code to find middle node of the linkedlist and print its data in the single pass -
    The idea is to take two pointers - Slow and fast
    if slow takes one leap and fast takes two leap.
    So, by the time, fast pointer will reach in the end ; slow will be in the middle of the list 
    Assumption:
    1. The linkedlist is designed to add only integers
*/

public class MiddleElemList {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d;}
    }
    static Node head;

    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node node = head;
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public Node middleELem(Node head) {
        Node node = head;
        if(node == null) {
            return null;
        }

        if(node.next == null) {
            return node;
        }

        Node slow = head;
        Node fast = head;
        while(fast.next!= null) {
            fast = fast.next;
            if(fast != null && fast.next !=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    //main method
    public static void main(String args[]) {
        MiddleElemList list = new MiddleElemList();
        list.insertFront(5);
        list.insertFront(10);
        list.insertFront(15);
        list.insertFront(20);
        list.insertFront(25);
        list.insertFront(30);
        list.printList();
        Node middleNode = list.middleELem(head);
        if(middleNode != null){
            System.out.println("Element in the middle node " + middleNode.data);
        }
    }
}