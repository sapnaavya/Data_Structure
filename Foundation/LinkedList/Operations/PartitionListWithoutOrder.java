/**
    This code partitions a list around a value x without maintaining an order.
     -> It manages two pointer current, head and tail
     -> Using tail pointer we keep on adding bigger values than x on tail pointer and at the same point updat tail pointer
     -> we keep on adding Smaller values than x on head pointer and update head pointer 
     -> Also, dont forget to save current's next pointer in next node. and put back that in current node

     example, 
     Input: 3-> 5-> 10 -> 2 -> 8 -> 2 -> 1
     x = 5;
     Output: 1 -> 2 -> 2-> 3 -> 5 -> 10 -> 8
*/

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class PartitionListWithoutOrder {
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

    //partition a list around a value x
    static Node partition(Node head, int x) {
        if(head == null) {
            return null;
        }

        if(x <= 0 || head.next == null) {
            return head;
        }

        Node current = head;
        Node tail = head;
         
        while(current != null) {
            Node next = current.next;
            if(current.data < x) { 
                current.next = head;
                head = current;
            } else {
                tail.next = current;
                tail = current;
            }
            current = next;
        }

        tail.next = null;
        return head;
    }
    

    //main method
    public static void main(String args[]) {
        PartitionListWithoutOrder llist = new PartitionListWithoutOrder();
        llist.insertFront(4);
        llist.insertFront(5);
        llist.insertFront(6);
        llist.insertFront(2);
        llist.insertFront(8);
        llist.insertFront(1);
        llist.print(llist.head);   
        int x = 1;
        Node partitionList = partition(llist.head, x);
        llist.print(partitionList);

    }
}