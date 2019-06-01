/* Code to sum to linkedlist.
Assumption - Linkedlist are stored in reverse order such that 1's digit is at the head of the list */

public class SumTwoListReverse {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }

        //set next node 
        public void setNext(Node nextNode, Node prevNode) {
            // if prevNode is null that mean we have reached the end of the list, so we return from here
            if(prevNode == null) {
                return;
            }
            else{
                prevNode.next = nextNode;
                nextNode = prevNode;
            }
        }
    }
    

    //Insert at the beginning of the List
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Print the whole list
    public static void print(Node node) {
        //Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Sum of two linked list in reverse order
    public static Node sumofTwoList(Node l1, Node l2, int carry) {

        //considering this is the last node .. so we have to make it as null
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }
        
        int value = carry;
        if(l1 != null) {
            value += l1.data;
        }
        if(l2 != null) {
            value += l2.data;
        }

        Node node = new Node(value%10);
        
        if(l1 != null || l2 != null) {
            Node nextNode = sumofTwoList(l1 == null ? null: l1.next, l2 == null ? null : l2.next, value >= 10 ? 1: 0);
            node.setNext(nextNode, node);
        }

        return node;
    }

   
    //main method
    public static void main(String args[]) {
        SumTwoListReverse list1 = new SumTwoListReverse();
        SumTwoListReverse list2 = new SumTwoListReverse();
    
        list1.insertFront(1);
        list1.insertFront(2);
        //list1.insertFront(7);

        list2.insertFront(1);
        list2.insertFront(2);
        //list2.insertFront(3);

        print(list1.head);
        print(list2.head);

        int carry = 0;
        Node sumNode = sumofTwoList(list1.head, list2.head, carry);
        print(sumNode);
    }
}