/**
 This code check for if a binary tree is BST or not using two methods:
 1. Using Recursion
 2. Using Queues - Iterative method
*/

import java.util.Queue;
import java.util.LinkedList;

class Node {
    Node left;
    Node right;
    int data;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

//define a BNode class with TreeNode and its boundaries
class BNode{
    Node root ;
    int left;
    int right;
    public BNode(Node n, int left, int right){
        //this.n = n;
        root = n;
        this.left = left;
        this.right = right;
    }
}

public class BSTOrNot {
    Node root;

    //inorder traversal
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Check if a binary tree is BST or not
    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public  static boolean isBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.data < min || root.data > max) {
            return false;
        }

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    //Iterative method to check if a binary tree is BST or not - Using Queue
    public static boolean isBSTIterative(Node root) {
        if(root == null) {
            return true;
        }
        Queue<BNode> queue = new LinkedList<BNode> ();
        queue.add(new BNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!queue.isEmpty()) {
            BNode bstTree = queue.poll();
            if(bstTree.root.data <= bstTree.left || bstTree.root.data >= bstTree.right) {
                return false;
            }
            if(bstTree.root.left != null) {
                queue.add(new BNode(bstTree.root.left, bstTree.left, bstTree.root.data));
            }
            if(bstTree.root.right != null) {
                queue.add(new BNode(bstTree.root.right, bstTree.root.data, bstTree.right));
            }
        }
        return true;
    }

    //main method
    public static void main(String args[]) {
        BSTOrNot tree = new BSTOrNot();
        tree.root = new Node(4); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(10);
        tree.inorder(tree.root);

        System.out.println("\n");
        boolean bstTree = isBST(tree.root);
        System.out.println(bstTree);

        boolean isBSTIterative = isBSTIterative(tree.root);
        System.out.println(isBSTIterative);

    }
}