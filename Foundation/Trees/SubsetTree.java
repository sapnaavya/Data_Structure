/**
 This code checks the a tree is a subset of another tree or not in following ways:

 1. First, check if roots are identical, if yes then compare both the tree left and right subtree.
 2. if roots are not identical then check with tree's left subtree root and root2 || tree's right subtree root and root2 are identical or not
 2. Go until you find the identical roots, after finding identical roots.. check the left and right roots of subtree and super tree
 */

class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class SubsetTree {
    Node root1;
    Node root2;

    //inorder traversal
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    // check the roots of the tree
    public static boolean isIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null) {
            return false;
        }

        if(root2 == null) {
            return true;
        }
        return(root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
    }

    // check if a tree is a subset of another tree or not
    public static boolean isSubsetTree(Node root1, Node root2) {
        if(root1 == null){
            return false;
        }
        if(root2 == null) {
            return false;
        }

        if(isIdentical(root1, root2)) {
            return true;
        }

        return isSubsetTree(root1.left, root2) || isSubsetTree(root1.right, root2);
    }

    //main method
    public static void main(String args[]) {
        SubsetTree tree = new SubsetTree();
        tree.root1 = new Node(4); 
		tree.root1.left = new Node(2); 
		tree.root1.right = new Node(6); 
		tree.root1.left.left = new Node(1); 
        tree.root1.left.right = new Node(3); 
        tree.root1.right.left = new Node(5); 
        tree.root1.right.right = new Node(7);

        tree.inorder(tree.root1);
        System.out.println("\n");
        tree.root2 = new Node(0); 
		tree.root2.left = new Node(8); 
        tree.root2.right = new Node(7); 
        tree.inorder(tree.root2);

        boolean isSubset = isSubsetTree(tree.root1, tree.root2);
        System.out.print(isSubset);
    }
}