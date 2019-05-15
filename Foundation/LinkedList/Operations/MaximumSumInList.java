/* A java program to find maximum sum in a range */

public class MaximumSumInList {
    static Node head;
    class Node {
        int data;
        Node next;
        Node(int d) { data = d;}
    }

    //Insert in Front
    public void insertInFront(int data) {
        Node newNode = new Node(data);
        System.out.println(newNode.data);
        newNode.next = head;
        head = newNode;
    }

    //print element of list
    public void printList(Node node) {
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    //PrintListWithinRange
    public Node subListInRange(int fromIndex, int toIndex) {
        Node head1 = new Node(0);
        Node current = head;
        Node pointer = head1;
        int counter = 0;
        while(current != null) {
            if(counter >= fromIndex && counter < toIndex) {
                pointer.next = current;
                pointer = pointer.next;
            }
            current = current.next;
            counter++;
        }
        return head1.next;
    }

    //find the maximum sum in a linkedlist
    public void maximumSumInRange(Node node) {
        int start = 0;
        int end = 0;
        int s = 0;
        int i = 0;
        if(node == null) {
            return;
        }

        int maxSofar = node.data;
        int maxSum = 0;
        while(node != null) {
            maxSum = maxSum + node.data;
            if(maxSofar < maxSum){
                maxSofar = maxSum;
                start = s;
                end = i;
            }
    
            if(maxSum < 0) {
                maxSum = 0;
                s = i+1;
            }

            i++;
            node = node.next;
        }   

        System.out.println("Maximum Sum in a sublist " + maxSum);
        Node subListInRange = subListInRange(start, end);
        printList(subListInRange);
    }

    //Main method
    public static void main(String args[]) {
        MaximumSumInList llist = new MaximumSumInList();
        llist.insertInFront(6);
        llist.insertInFront(9);
        llist.insertInFront(-6);
        llist.insertInFront(-6);
        llist.insertInFront(-10);
        llist.insertInFront(-25);
        llist.printList(head);
        llist.maximumSumInRange(head);
    }
}