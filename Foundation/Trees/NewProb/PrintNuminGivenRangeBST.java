/**
 * This code prints the number in the given range k1 and k2 in  binary search tree
 */
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class PrintNuminGivenRangeBST {
    Node root;
    //function to print keys in the range
    public static void printinRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        
        if(root.data > k1) {
            printinRange(root.left, k1, k2);
        }

        if(root.data >= k1 && root.data <= k2) {
            System.out.println(root.data);
        }

        if(root.data < k2) {
            printinRange(root.right, k1, k2);
        }
    }
    //main method
    public static void main(String args[]) {
        PrintNuminGivenRangeBST tree = new PrintNuminGivenRangeBST();
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        int k1 = 10;
        int k2 = 25;
        tree.printinRange(tree.root, k1, k2); 
    }
}