class Node{
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class CountSumBoundaryNode  {
    Node root;
    public static int sum_of_boundary_nodes = 0;

    //sum of left boundary node
    public void sumofLeftBoundaryNode(Node node) {
        if(node == null) {
            return;
        } else {
            if(node.left != null) {
                sum_of_boundary_nodes += node.data;
                sumofLeftBoundaryNode(node.left);
            } else if(node.right != null) {
                sum_of_boundary_nodes += node.data;
                sumofRightBoundaryNode(node.right);
            }
        }
    }

    //sum of right boundary node
    public void sumofRightBoundaryNode(Node node) {
        if(node == null) {
            return;
        } else {
            if(node.right != null) {
                sum_of_boundary_nodes += node.data;
                sumofLeftBoundaryNode(node.right);
            } else if(node.left != null) {
                sum_of_boundary_nodes += node.data;
                sumofRightBoundaryNode(node.left);
            }
        }
    }

    //sum of leaf nodes
    public void sumOfLeafNode(Node root) {
        if(root == null) {
            return;
        }
        sumOfLeafNode(root.left);
        if(root.left == null && root.right == null) {
            sum_of_boundary_nodes += root.data;
        }
        sumOfLeafNode(root.right);
    }

    //helper function for all sums
    public int sumOfBoundaryNode(Node root) {

        sum_of_boundary_nodes = root.data;

        //sum of boundary node - left subtree
        sumofLeftBoundaryNode(root.left);

        //Sum of binary node - right subtree
        sumofRightBoundaryNode(root.right);

        //sum of leaf node
        sumOfLeafNode(root);

        return sum_of_boundary_nodes;
    }

    //main method
    public static void main(String args[]) {
        CountSumBoundaryNode tree = new CountSumBoundaryNode();  
        tree.root = new Node(10);
        tree.root.left = new Node(2);  
        tree.root.right = new Node(5);  
        tree.root.left.left = new Node(8);  
        tree.root.left.left = new Node(8);  
        tree.root.left.right = new Node(14);  
        tree.root.right.left = new Node(11);  
        tree.root.right.right = new Node(3);  
        tree.root.left.right.left = new Node(12);  
        tree.root.right.left.right = new Node(1);  
        tree.root.right.left.left = new Node(7);  
        System.out.println(tree.sumOfBoundaryNode(tree.root)); 
    }
}