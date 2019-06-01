class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class PartitionList {
    Node head;

    //Print the whole list
    public void print(Node node) {
        //Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n");
    }

    //Insert at the beginning of the List
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //partition a list
    static Node partition(Node head, int x) {
        if(head == null) {
            return null;
        }

        if(x <= 0 || head.next == null) {
            return head;
        }

        Node start = head;
        Node tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }

        while(start != null) {
            if(start.data > x) {
                Node temp =  start;
                tail.next = start;
                tail = start;
                tail.next = null;

                //the problem is with below start where start is not getting updated pointer
                //because temp.next is holding null but it is supposed to be holding start.next i.e. not null
                
                start = temp.next;
            } else {
                start = start.next;
            }
        }
        return head;
    }
    

    //main method
    public static void main(String args[]) {
        PartitionList llist = new PartitionList();
        llist.insertFront(4);
        llist.insertFront(5);
        llist.insertFront(6);
        llist.insertFront(2);
        llist.insertFront(8);
        llist.insertFront(1);
        llist.print(llist.head);   
        int x = 4;
        Node partitionList = partition(llist.head, x);
        llist.print(partitionList);

    }
}