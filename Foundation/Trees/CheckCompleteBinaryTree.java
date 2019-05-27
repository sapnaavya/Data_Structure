/* This code check if a binary tree is a complate binary tree or not in below ways:
    -> Using recursion
       1. When using recurion, we check set the index of all nodes. i.e. 2*i+1 to left node and 2*i+2 to right node where i is the index 0 set to root node
       2. Also, we calculate the no of nodes in the tree
       3. In complete binary tree, index will always be less than the no of nodes in the complete binary tree
       4. Whenever, we find the index greater than or equal to no of nodes, that mean it is not a complete binary tree
    
    -> Using iterative method
       1. we use the queue and set the boolean variable flag to true whenever left or right child of a node becomes null
       2. Then , while traversing, if we find the boolean variable is set to true, we return false as this is not a complete binary tree.   
*/
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
public class CheckCompleteBinaryTree {
    Node root;
    
    //inorder traversal
    public void inorder(Node root) {
        if(root == null) {
            return ;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Iterative way to check if a binary tree is a complete binary tree
    public static boolean isCompleteIterative(Node root) {
        if(root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.left != null) {
                if(flag == false) {
                    queue.add(temp.left);
                } else {
                    return false;
                }
            } else {
                flag = true;
            }

            if(temp.right != null) {
                if(flag == false) {
                    queue.add(temp.right);
                } else {
                    return false;
                }

            } else {
                flag = true;
            }
        }
        return true;
    }

    //Recursive way to check if a binary tree is a complete binary tree or not. For that, we need to calculuate no on nodes in the tree
    public static boolean isComplete(Node root, int index, int nodeCount) {
        if(root == null) {
            return true;
        }
        
        //if index is greater than or equal to  total nodecount that mean it is not complete binary tree
        if(index >= nodeCount) {
            return false;
        }

        return(isComplete(root.left, 2 * index + 1, nodeCount) && isComplete(root.right, 2* index + 2, nodeCount));
    }
    
    //count no of total nodes in the binary tree
    public static int totalNodeCount(Node root) {
        if(root == null) {
            return 0;
        }

        return(1 + totalNodeCount(root.left) + totalNodeCount(root.right));
    }


    //main method
    public static void main(String args[]) {
        CheckCompleteBinaryTree tree = new CheckCompleteBinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
        tree.inorder(tree.root);

        System.out.println("\n");
        int nodeCount = totalNodeCount(tree.root);
        int index = 0;

        //check for complete binary tree using recursion
        boolean isCompleteUsingRecursion = isComplete(tree.root, index, nodeCount);
        System.out.println("Complete Binary Tree using recursion: " + isCompleteUsingRecursion);

        //check for complete binary tree  using iterative method
        boolean isCompleteTree = isCompleteIterative(tree.root);
        System.out.println("Complete Binary Tree using iterative method: " + isCompleteTree);
    }
}