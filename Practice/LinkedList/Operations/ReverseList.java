
import java.util.*;

public class ReverseList {
    static class Node {  
        int data;  
        Node next;  
    } 
    static Node head = null;
    //Push nodes
    static void push(int new_data) {  
        Node new_node = new Node();  
        new_node.data = new_data;  
        new_node.next = (head);  
        (head) = new_node;  
    } 
    
    //Print List
    public static void printList(Node head) {
        while (head != null)  
        {  
            System.out.println(head.data + " ");  
            head = head.next;  
        } 
    }

    // Reverse a singly linked list - Using Stack
    public static Node reverseListUsingStack(Node head) {
        if(head == null) {
            System.out.println("Linked list empty...");
            return head;
        }
        Stack<Node> stack = new Stack<Node>();
        Node ptr = head;
        while(ptr.next != null) {
            stack.push(ptr);
            ptr = ptr.next;
        }

        head = ptr;
        //System.out.println(ptr.data);
        //System.out.println(head.data);
        while(!stack.isEmpty()) {
            ptr.next = stack.peek();
            ptr = ptr.next;
            stack.pop();
        }
        ptr.next = null;
        return head;
    }

    //Reverse a linked list using bruteforce method
    public static Node reverseListBruteForce(Node head) {
        if(head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next  = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    //Main Method
    public static void main(String args[]) {
        push( 5);  
        push( 4);  
        //push( 3);  
        //push( 2);  
        //push( 1); 
        printList(head);

        head = reverseListUsingStack(head);  
        printList(head); 

        Node head1 = reverseListBruteForce(head);
        printList(head1);
    }
}

