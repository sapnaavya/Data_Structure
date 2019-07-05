/**
 * This code flattens a linkedlist
 * The idea is to use Merge() process of merge sort for linked lists. We use merge() to merge lists one by one. We recursively merge() the current list with already flattened list.
   The down pointer is used to link nodes of the flattened list.
 * Example: 
 *     5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45 
    
    Output: 5->7->8->10->19->20->22->28->30->35->40->45->50.
 */
public class FlattenLinkedList {
    class Node {
        int data;
        Node right, down;
        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    Node head;

    public Node insertFront(Node head, int data) {
        Node newNode = new Node(data);
        newNode.down = head;
        head = newNode;
        return head;
    }

    public void printList(Node head) {
        Node node = head;
        while(node != null) {
            System.out.println(node.data);
            node = node.down;
        }
    }

    //merge two sorted linkedlist
    public Node mergeSortedList(Node root1, Node root2) {
        if(root1 == null) 
            return root2;
        
        if(root2 == null)
            return root1;
        
        Node result;
        if(root1.data < root2.data) {
            result = root1;
            result.down = mergeSortedList(root1.down, root2);
        } else {
            result = root2;
            result.down = mergeSortedList(root2.down, root1);
        }

        return result;
    }

    //flatten list
    public Node flattenList(Node root) {
        if(root == null || root.right == null) {
            return root;
        }

        //recur for the right node
        root.right = flattenList(root.right);

        //now merge root and root.right
        root = mergeSortedList(root, root.right);

        return root;
    }

    //main method
    public static void main(String args[]) {
        FlattenLinkedList list = new FlattenLinkedList();
        list.head = list.insertFront(list.head, 30);
        list.head = list.insertFront(list.head, 8);
        list.head = list.insertFront(list.head, 7);
        list.head = list.insertFront(list.head, 5);

        
        list.head.right = list.insertFront(list.head.right, 20);
        list.head.right = list.insertFront(list.head.right, 10);

        list.head.right.right = list.insertFront(list.head.right.right, 50); 
        list.head.right.right = list.insertFront(list.head.right.right, 22); 
        list.head.right.right = list.insertFront(list.head.right.right, 19); 

        list.printList(list.head);
        System.out.print("\n");
        list.printList(list.head.right);

        list.head = list.flattenList(list.head);
        System.out.print("\n");
        list.printList(list.head);
    }
}