/**
  This method reverse k alternate node in the list using following approaches:
  Please make sure to revise reverse a linkedlist, reverse k nodes in the linkedlist before doing this problem.

     Bruteforce approach: 
        1)  Reverse first k nodes.
        2)  In the modified list head points to the kth node.  So change next 
        of head to (k+1)th node
        3)  Move the current pointer to skip next k nodes.
        4)  Call the kAltReverse() recursively for rest of the n - 2k nodes.
        5)  Return new head of the list

    Efficient way: Since in the above way, we are using two while loop, this can be done using one while loop and one boolean variable
        kAltReverse(Node head, int k, bool b)
            1)  If b is true, then reverse first k nodes.
            2)  If b is false, then move the pointer k nodes ahead.
            3)  Call the kAltReverse() recursively for rest of the n - k nodes and link 
       rest of the modified list with end of first k nodes. 
            4)  Return new head of the list.


 */

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class ReverseKAlternateNodes {
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

    //reverse K alternate nodes in the list
    public static Node reverseKaltNodes(Node head, int k ) {
        if(head == null || k < 0) {
            return null;
        }
        
        if(head.next == null) {
            return head;
        }

        Node current = head;
        Node next = null;
        Node prev = null;
        int i = 0;

        //Reverse first K nodes
        while(current != null && i < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        // Now point head to k+1 node. So, change next of head to k+1 th node (current)
        if(head != null) {
            head.next = current;
        }

        // skip reversing next k nodes. Since, we are already on K+1 node.. skip reversing k-1 node. So, move pointer to skip k-1 nodes
        int count = 0;
        while(count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        //Recursively, call for list starting from current -> next and make rest of the list as next of first node
        if(current != null) {
            current.next = reverseKaltNodes(current.next, k);
        }

        //prev is now head of the list
        return prev;
    }

    //Efficient way to implement revserse k alternate node using only one while loop and one boolean variable
    public static Node reversealtKNodeEfficient(Node node, int k, boolean flag) {
        if(node == null || k < 0) {
            return null;
        }

        if(node.next == null) {
            return node;
        }

        Node current = node;
        Node prev = null;
        Node next = null;
        int i = 0; 

        //Traverse the list till k - 
        /* The loop serves two purposes:
         1) If b is true, then it reverses the k nodes  
         2) If b is false, then it moves the current pointer */

        while(i < k && current != null) {
            next = current.next;

            //If flag is true then reverse the node
            if(flag == true) {
                current.next = prev;
            }
            prev = current;
            current = next;
            i++;
        }

        /* 3) If b is true, then node is the kth node.So attach rest of the list after node. 4) After attaching, return the new head */
        if(flag == true) {
            node.next = reversealtKNodeEfficient(current, k, !flag);
            return prev;
        } 
        /* If b is not true, then attach rest of the list after prev.So, attach rest of the list after prev */ 
        else {
            prev.next = reversealtKNodeEfficient(current, k, !flag);
            return node;
        }
    }

    //main method
    public static void main(String args[]) {
        ReverseKAlternateNodes llist = new ReverseKAlternateNodes();
        llist.insertFront(3);
        llist.insertFront(2);
        llist.insertFront(5);
        llist.insertFront(9);
        llist.insertFront(3);
        llist.insertFront(4);
        llist.insertFront(1);
        llist.insertFront(6);
        llist.insertFront(7);
        llist.insertFront(8);
        llist.insertFront(3);
        printList(head);
        int k = 3;
        System.out.print("\n");
        Node reverseKaltNodes = reverseKaltNodes(head, k);
        printList(reverseKaltNodes);

        System.out.print("\n");
        boolean flag = true;
        // Node reversealtKNodeOther = reversealtKNodeEfficient(head, k, flag);
        //printList(reversealtKNodeOther);

    }
}