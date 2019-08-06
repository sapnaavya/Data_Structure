/* This code traverses the list in two ways:
    1. Bredth first traversal
    2. depth first traversal 
*/
import java.util.Queue;
import java.util.LinkedList;
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeTraversal {

    // Bredth first traversal
    public static void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    // depth first traversal
    public static void depthFirstTraversal(Node root) {
        if(root == null) {
            return;
        }
        depthFirstTraversal(root.left);
        System.out.print(root.data + " ");
        depthFirstTraversal(root.right);
    }


    // main method
    public static void main(String args[]) {
        Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
        root.right.right = new Node(35);
        levelOrderTraversal(root);
        System.out.print("\n");
        depthFirstTraversal(root);
    }
}