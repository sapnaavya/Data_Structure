/* Code to find middle element of the linkedlist in the single pass */

public class MiddleElemList {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d;}
    }
    static Node head;

    public void insertFront(int data) {
        //Node node = head;
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

    public int middleELem(Node head) {
        Node node = head;
        if(node == null) {
            return 0;
        }

        if(node.next == null) {
            return node.data;
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
        return slow.data;
    }
    //main method
    public static void main(String args[]) {
        MiddleElemList list = new MiddleElemList();
        list.insertFront(5);
        list.insertFront(10);
        list.insertFront(15);
        list.insertFront(20);
        list.insertFront(25);
        //list.insertFront(30);
        list.printList();
        int middleElem = list.middleELem(head);
        System.out.println("midlle elem" + middleElem);
    }
}