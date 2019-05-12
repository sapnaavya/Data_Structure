
/* A java program to detect cycle in the linked list Basically, check if we have same node address */
import java.util.*;

public class DetectCycle {
    static class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null;}
    }
    static Node head = null;

    //Add to the list
    public void insertFront(int data) {
        Node newNode = new Node(data);
        //newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    //Print List
    public void printList(Node head) {  
        Node node = head;
        while(node != null) {  
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    //Detect Loop in the Singly Linked List. Basically, check if we have same node address for different values
    //Using Hashset as it does not allow duplicate values. Add the value to hashset if it does not already contained in the hashset
    public boolean detectLoopUsingHashSet(Node head) {
        if(head == null) {
            return true;
        }
        Node node = head;
        HashSet<Node> hashset = new HashSet<Node>();
        while(node != null) {
            if(hashset.contains(node)) {
                return true;
            }
            else {
                hashset.add(node);
            }
            node = node.next;
        }
        return false;
    }

    //Detect cycle in the list using slow pointer and fast pointer
    public boolean detectCycleUsingPointer(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Node slowPointer = head;
        Node fastPointer = head;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) {
                return true;
            }
        }
        return false; 
    }

    //Detect and Remove loop
    public boolean detectAndRemoveLoop(Node head) {
        if(head == null || head.next ==null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow == fast) {
            slow = head;
            while(slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            /* fast-> next is the looping point; Remove it */
            fast.next = null;
            return true;
        }
        return false;
    }

    //Main method
    public static void main(String args[]) {
        DetectCycle llist = new DetectCycle();
        llist.insertFront(5);
        llist.insertFront(10);
        llist.insertFront(15);
        llist.insertFront(20);
        llist.insertFront(25);
        llist.printList(head);
    
        /*Create loop for testing */
        llist.head.next.next = llist.head; 
        boolean isloop = llist.detectLoopUsingHashSet(head);
        System.out.println(isloop);

        boolean isloopCycle = llist.detectCycleUsingPointer(head);
        System.out.println(isloopCycle);

        boolean detectandRemoveLoop = llist.detectAndRemoveLoop(head);
        System.out.println(detectandRemoveLoop);

    }
}
