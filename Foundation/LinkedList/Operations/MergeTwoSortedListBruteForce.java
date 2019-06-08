public class MergeTwoSortedListBruteForce {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
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
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    //Merge two unsorted linkedlist
    public static Node mergeTwoSoredList(Node l1, Node l2) {
        
        Node newList = new Node(0);
        Node head = newList;
        if(l1 == null || l2 == null) {
            return null;
        }
        
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                newList.next = l1;
                l1 = l1.next;
            }
            else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }

        if(l1 != null) {
            newList.next = l2;

        }
        if(l2 != null) {
            newList.next = l2;
        }

        return head.next;
    }

    //Main method
    public static void main(String args[]) {
        MergeTwoSortedListBruteForce list1 = new MergeTwoSortedListBruteForce();
        MergeTwoSortedListBruteForce list2 = new MergeTwoSortedListBruteForce();
    
        list1.insertFront(7);
        list1.insertFront(6);
        list1.insertFront(5);

        list2.insertFront(9);
        list2.insertFront(8);
        list2.insertFront(4);

        Node sumNode = mergeTwoUnsoredList(list1.head, list2.head);
        print(sumNode);
    }
}