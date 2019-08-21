/**
 * This code inserts element in sorted circular list
*/

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class InsertInCircularSortedList {
    static Node head;
    public void printList(Node node) {
        Node temp = node;
        do 
        {
            System.out.println(temp.data);
            temp = temp.next;
        } while(temp != node);
    }

    public void sortedInsert(Node newNode) {
        Node current = head;

        //case 1: when current is null
        if(current == null) {
            newNode.next = newNode;
            head = newNode;
        }

        //case 2: when we have to insert in the beginning..
        //for that first go to last node and point last node next to new node 
        // and new node next to head and point head to new node
        else if(current.data >= newNode.data) {
            while(current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;  //it is very important.. new added element will point to head
        }

        else {
            //Case 2: insert element in between the list
            while(current.next != head && current.next.data < newNode.data) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //main method
    public static void main(String args[]) {

        InsertInCircularSortedList llist = new InsertInCircularSortedList();
        int arr[] = {12, 56, 2, 11, 1, 90, 3, 100};

        //start with the empty linkedlist
        Node temp = null;
        
        /* Created linked list will be 1->2->11->12->56->90 */
        for(int i = 0; i < 8; i++) {
            temp = new Node(arr[i]);
            llist.sortedInsert(temp);
        }

        llist.printList(head);
    }
}