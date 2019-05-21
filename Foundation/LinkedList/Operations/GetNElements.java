/* A java code to divide list and return 1/k element based on k value; considering that linkedlist length is unknown
  Code is tested under below test cases : 
    -> if K is 1 it returns full list
    -> if k is same as linkedlist length this will return last element
    -> if k is greater than linkedlist length, this will return null as linkedlist length is greater than k
    -> if k is 0 or some negative value this will return null object
 */
import java.util.Scanner;

public class GetNElements {

    //Node class
    static Node head;
    public static int counter = 0;
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null;}
    }

    //Index class that will hold the indices i.e start and nIndex
    class Index {
        Node startIndex;
        Node nIndex;
        Index() {
            this.startIndex = null;
            this.nIndex = null;
        }

        Index(Node startIndex, Node nIndex) {
            this.startIndex = startIndex;
            this.nIndex = nIndex;
        }

    }

    //Insert in the beginning of the list
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Print list
    public void printList() {
        Node node = head;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print("\n");
    }

    //function to move next pointer by K steps
    public Node movePointer(Node node, int k) {
        if(node == null || k <= 0) {
            return null;
        }
        int i = 0;
        while(i < k) {
            if(node.next != null){
                node = node.next;
                counter++; 
            } else if ((k == ++counter) && (node != null) && (node.next == null)) {
                return node;
            } else {
                return null;
            } 
            i++;
        }
        return node;
    }

    /*
    function to get indices to sublist from start to 1/k steps. 
    This function will return instance that will hold the value of starting index and nIndex.
    Based on these indices, we can get the list ranging between these indices
    */

    public Index getNElementsIndex(Node head, int k) {
        if(head == null || k <= 0) {
            return new Index(null, null);
        }
        Node start = head;
        Node slow = head;
        Node fast = movePointer(head, k);
        if(fast == null) {
            return null;
        }

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = movePointer(fast, k);
        } 

        //covering edge case when k == 1
        if(slow.next.next == null) {
            slow = slow.next;
        }

        return new Index(start, slow);
    }

    //Main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the K element to divide list between 1 by k list");
        int k = sc.nextInt();
        GetNElements list = new GetNElements();

        list.insertFront(5);
        list.insertFront(10);
        list.insertFront(15);
        list.insertFront(20);
        list.insertFront(25);
        list.insertFront(30);
        list.insertFront(35);
        list.insertFront(40);
        list.insertFront(26);
        list.insertFront(30);
        list.printList();
        Index index  = list.getNElementsIndex(head, k);

        //printing value between start and endIndex
        if(index != null && !(k <= 0) && index.startIndex != null && index.nIndex != null){
            System.out.println("Elements ranging between these two indices") ;
            while(index.startIndex != index.nIndex ){
                System.out.println(index.startIndex.data);
                index.startIndex = index.startIndex.next; 
            }
            System.out.println(index.startIndex.data);
        } else if(index.startIndex == null && index.nIndex == null){
            System.out.println("Either list is null or k is not a valid integer");
        } else if(k > counter){
            System.out.println("Operation failed.. k's value " + k + " is greater than list length i.e. " + counter );
        }
        sc.close();
    }
}