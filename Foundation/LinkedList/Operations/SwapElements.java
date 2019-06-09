class Node {
    int data ;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class SwapElements {
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

    //Swap pairwise elements of a linkedlist
    public static Node swapNodes(Node node) {
        if(node == null || node.next == null) {
            return null;
        }
    
        // Initialize previous and current pointers 
        Node prev = node;
        Node current = node.next;
        // Change head before proceeeding 
        node = current;
        //Node next = null;
        while(true) {
            //save next pointer
            Node next = current.next;

            //swap current and previous
            current.next = prev; 
            //handle null pointer exception when next or next.next is null
            if (next == null || next.next == null) { 
                prev.next = next;
                break;
            }
            prev.next = next.next;

            //Update previous and current pointer
            prev = next;
            current = prev.next;
        }
        return node;
    }

    //main method
    public static void main(String args[]) {
        SwapElements llist = new SwapElements();
        llist.insertFront(3);
        llist.insertFront(2);
        llist.insertFront(5);
        llist.insertFront(2);
        llist.insertFront(3);
        llist.insertFront(4);
        llist.insertFront(1);
        printList(head);
        System.out.println("\n");
        Node swapNode = swapNodes(head);
        printList(swapNode);
    }

}