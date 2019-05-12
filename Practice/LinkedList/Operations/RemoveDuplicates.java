import java.util.*;

public class RemoveDuplicates {
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

    //Remove Duplicate from the list - Using HashTables
    public static void removeDuplicatesUsingBuffer(Node head) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        Node current = head;
        int i = 0;
        Node prev = null;
        while(current != null) {
            if(hashTable.contains(current.data)) {
                //Remove from the list as this is duplicate
                prev.next = current.next;
            }
            else{
                //Add to the hashtable and change prev
                hashTable.put(i++, current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    //Remove duplicate using brute force method
    public static void deleteDupsBruteForce(Node head) {
        if(head == null) {
            return;
        }
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(current.data == runner.next.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //Main method
    public static void main(String args[]) {
        RemoveDuplicates llist = new RemoveDuplicates();
        llist.insertFront(5);
        llist.insertFront(10);
        llist.insertFront(10);
        llist.insertFront(5);
        llist.insertFront(15);
        llist.printList(head);
        
        removeDuplicatesUsingBuffer(head);
        llist.printList(head);

        llist.insertFront(15);
        deleteDupsBruteForce(head);
        llist.printList(head);
    }
}