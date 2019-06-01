class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class SwapElements {
    Node head;

    //insert front in the node
    public void insertFront(Node node, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //print list
    public void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //move pointer to k location
    public static Node movePointer(Node node, int k) {
        if(node == null || node.next != null) {
            //node = node.next
            return null;
        }
        int i = 0;
        while(i < k) {
            if(node.next != null) {
                node = node.next;
                i++;
            } else {
                return node;
            }
        }
        return node;
    }

    //swap pointer between two nodes in the linkedlist
    public static void swapPointers(Node node1, Node node2) {
        if(node1 == null || node2 == null) {
            return;
        }
        Node temp = node1;
        node1 = node2;
        node2 = temp;
        System.out.println(node1.data + "node1");
        System.out.println(node2.data + "node2");
    }

    //swap elements in linkedlist
    public static Node swapElem(Node node, int k) {
        if(node == null) {
            return null;
        }

        if(node.next == null || k <= 0) {
            return node;
        }

        Node ptr1 = node;
        Node ptr2 = node;
        while(node != null) {
            //next = node.next;
            ptr1 = node;
            ptr1 = movePointer(ptr1, k);
            swapPointers(node, ptr1); 
            node = node.next;                                                     
        }
        return ptr2;
    }

    //main method
    public static void main(String args[]) {
        SwapElements llist = new SwapElements();
        llist.insertFront(llist.head, 5);
        llist.insertFront(llist.head, 4);
        llist.insertFront(llist.head, 7);
        llist.insertFront(llist.head, 8);
        llist.insertFront(llist.head, 13);
        llist.insertFront(llist.head, 22);
        llist.insertFront(llist.head, 45);
        llist.insertFront(llist.head, 52);
        llist.printList(llist.head);
        Node swapList = swapElem(llist.head, 3);
        llist.printList(swapList);
    }
}