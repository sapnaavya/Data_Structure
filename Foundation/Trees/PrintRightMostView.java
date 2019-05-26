/*This code prints the rightmost view of the tree in below ways:
 -> Using queues
 -> Using recursion 
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
public class PrintRightMostView {
    Node root;

    //Print right most view using Queues; when we have queue count as 1 that mean it is the rightmost element. So, we are printing that data
    public void printRightmostViewUsingQueues(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();

            while(count > 0) {
                Node node = queue.poll();
                if(count == 1) {
                    System.out.print(node.data + " ");
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                count-- ;
            }
        }

    }

    //Print inorder of the tree
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //main method
    public static void main(String args[]) {
        PrintRightMostView tree = new PrintRightMostView();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.inOrder(tree.root);

        System.out.println("\n");
        tree.printRightmostViewUsingQueues(tree.root);

    }
}