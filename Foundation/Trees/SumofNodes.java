/* This code performs two operations:
    1. Print sum of all nodes in the tree using recusrion
    2. convert a tree to its sum tree using following ways:
        A. Save the root value in a variable
        B. Call for recusive sum in left and right
        C. In a subtree, when a root is null, we print 0 and return oldvalue and root.data to the call stack
        D. Please note that in the binary tree, first we are storing the root.data in a variable and then changing root.data to recursive sum of left and right subtree 
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

public class SumofNodes {
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

    //print sum of all node
    public int sumofNodes(Node root) {
        if(root == null) {
            return 0;
        }

        return(root.data + sumofNodes(root.left) + sumofNodes(root.right));
    }

    //in-place sum of nodes binary tree
    public static int inplaceSumTree(Node root) {
        if(root == null) {
            return 0;
        }

        int oldValue = root.data;
        root.data = inplaceSumTree(root.left) + inplaceSumTree(root.right);
        return (oldValue + root.data);
    }

    //main method
    public static void main(String args[]) {
        SumofNodes tree = new SumofNodes();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
        tree.inorder(tree.root);

        System.out.println("\n");
        //sum of all nodes in the tree
        int sum = tree.sumofNodes(tree.root);
        System.out.println("sum of all nodes" + sum);
        
        //convert a binary tree to inplace sum tree
        System.out.println("\n");
        int sumTree = inplaceSumTree(tree.root);
        //print inorder just to check whether tree has been converted to sum tree or not
        tree.inorder(tree.root);
    }
}