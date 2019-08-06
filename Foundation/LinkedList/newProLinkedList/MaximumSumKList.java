class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class MaximumSumKList {
    Node head;

    // Insert at the beginning of the List
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Print the whole list
    public void print() {
        Node node = head;
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    // function to print maximum sum in a k size list
    public void printMaxSumInKlist(int k) {
        Node node = head;
        Node current = head;
        int maxSofar = 0;
        int maxSum = 0;
        while(current != null) {
            node = current;
            maxSum = 0;
            for(int i=0; i < k; i++) {
                if(node != null) {
                    maxSum += node.data;
                    node = node.next;
                }
            }

            if(maxSofar < maxSum) {
                maxSofar = maxSum;
            }

            current = current.next;
        }
        System.out.println("maxSum: " + maxSofar);
    }

    //main method
    public static void main(String args[]) {
        MaximumSumKList llist = new MaximumSumKList();
        llist.insertFront(500);
        llist.insertFront(10);
        llist.insertFront(15);
        llist.insertFront(20);
        llist.insertFront(25);
        llist.insertFront(30);
        llist.insertFront(35);
        llist.insertFront(40);
        int k = 2;
        // llist.print();
        llist.printMaxSumInKlist(k);
        
    }
}