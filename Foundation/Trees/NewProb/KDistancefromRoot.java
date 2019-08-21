import java.util.Queue;
import java.util.LinkedList;

class Node {
    Node left, right;
    int data;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class KDistancefromRoot {
    Node root;

    // Recursive function to print k distance node from the root
    public void printKDistant(Node root, int k) {
        if(root == null) {
            return;
        } 
        if(k == 0) {
            System.out.println(root.data);
            return;
        } else {
            printKDistant(root.left, k - 1);
            printKDistant(root.right, k - 1);
        }
    }

    // Iterative functiont to print k distance node from the root
    public void printKDistantIter(Node root, int k) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            k--;
            int nodeCount = queue.size();
            while(nodeCount > 0) {
                Node top = queue.poll();

                if(top.left != null) {
                    queue.add(top.left);
                }

                if(top.right != null) {
                    queue.add(top.right);
                }
                nodeCount--;
            }
        }

        for(int i = 0; i < queue.size(); i++) {
            Node node = queue.poll();
            System.out.println("hello");
            System.out.println(node.data);
        }
    }

    //main method
    public static void main(String args[]) {
        KDistancefromRoot tree = new KDistancefromRoot();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(8); 
        tree.printKDistant(tree.root, 2); 
        tree.printKDistantIter(tree.root, 2);
    }
}