public class FindLCABinarySearchTree {
    static class Node{
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;

    //Find LCA between two nodes in binary search tree
    public Node LCABinarySearchTree(Node node, int n1, int n2) {
        if(node == null ) {
            return null;
        }
        if(node.data > n1 && node. data > n2) {
            return LCABinarySearchTree(node.left, n1, n2);
        }
        if(node.data < n1 && node.data < n2) {
            return LCABinarySearchTree(node.right, n1, n2);
        }
        return node;
    }

    public static void main(String args[])  
    { 
        // Let us construct the BST shown in the above figure 
        FindLCABinarySearchTree tree = new FindLCABinarySearchTree(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
   
        int n1 = 10, n2 = 14; 
        Node t = tree.LCABinarySearchTree(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
        n1 = 14; 
        n2 = 8; 
        t = tree.LCABinarySearchTree(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
        n1 = 10; 
        n2 = 22; 
        t = tree.LCABinarySearchTree(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
    } 
}