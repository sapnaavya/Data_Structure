/**
  This code parition the linkedlist around a value x while maintaining the order:
   1. Initialize first and last nodes of below three linked lists as NULL. 
        Linked list of values smaller than x.
        Linked list of values equal to x.
        Linked list of values greater than x.
   2. Now iterate through the original linked list. If a node’s value is less than x then append it at the end of smaller list. If the value is equal to x, then at the end of equal list. And if value is greater, then at the end of greater list.
   3. Now concatenate three lists.
*/
public class PartitionListWithOrder {
    static Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

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

    //Partition a list while maintaining original order, using three list
    public Node partitionList(Node node, int k) {
        if(node == null || k < 0) {
            return null;
        }

        if(node.next == null) {
            return head;
        }

        Node smallerHead = null, smallerTail = null;
        Node equalHead = null, equalTail = null;
        Node greaterHead = null, greaterTail = null;

        while(node != null) {
            Node next = node.next;
            if(node.data == k) {
                if(equalHead == null) {
                    equalHead = equalTail = node;
                } else {
                    equalTail.next = node;
                    // or you can also write equalTail = equalTail.next
                    equalTail = node;
                }
            } 
            else if(node.data < k) {
                if(smallerHead == null) {
                    smallerHead = smallerTail = node;
                } else {
                    smallerTail.next = node;
                    // or you can also write  smallerTail =  smallerTail.next
                    smallerTail = node;
                }

            } else if(node.data > k) {
                if(greaterHead == null) {
                    greaterHead = greaterTail = node;
                } else {
                    greaterTail.next = node;
                    // or you can also write  greaterTail =  greaterTail.next
                    greaterTail = node;
                }
            }
            node = next;
        }

        //connect all three lists
        if(greaterTail != null) {
            greaterTail.next = null;
        }

        //check if smallerhead is null or not
        if(smallerHead == null) {
            if(equalHead == null) {
                return greaterHead;
            } else {
                equalTail.next = greaterHead;
                return equalHead;
            }
        }

        //check if equal head is null or not 
        if(equalHead == null) {
            smallerTail.next = greaterHead;
            return smallerHead;
        }

        //if both smaller and equal head are not null;
        smallerTail.next = equalHead;
        equalTail.next = greaterHead;
        return smallerHead;
    }

    //main method
    public static void main(String args[]) {
        PartitionListWithOrder llist = new PartitionListWithOrder();
        llist.insertFront(3);
        llist.insertFront(2);
        llist.insertFront(5);
        llist.insertFront(2);
        llist.insertFront(3);
        llist.insertFront(4);
        llist.insertFront(1);
        printList(head);
        int k = 3;
        System.out.print("\n");
        Node partitionList = llist.partitionList(head, k);
        printList(partitionList);

    }
}