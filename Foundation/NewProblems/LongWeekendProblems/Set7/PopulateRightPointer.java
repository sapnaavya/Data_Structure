/**
 * Populate next right pointer of a tree
 * Reference: https://buttercola.blogspot.com/2014/09/leetcode-populating-next-right-pointers.html 
 *            https://www.programcreek.com/2014/06/leetcode-populating-next-right-pointers-in-each-node-ii-java/
 * 
 * Main reference: https://github.com/varunu28/InterviewBit-Java-Solutions/blob/master/Trees/Populate%20Next%20Right%20Pointers%20Tree.java
*/

import java.util.Queue;
import java.util.LinkedList;

class TreeLinkNode  {
    TreeLinkNode  left;
    TreeLinkNode  right;
    TreeLinkNode  next;
    int data;
    TreeLinkNode (int data) {
        this.data = data;
    }
    
}

public class PopulateRightPointer {
    TreeLinkNode  root;

    // Populate next right pointer to a node
    public static void connectRightNode(TreeLinkNode  root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.peek() != null) {
            int size = queue.size() - 1;
            while (size-- > 0) {
                TreeLinkNode node = queue.remove();
                node.next = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            queue.remove();
            queue.add(null);
        }
    }

    public static void printPrOrderTree(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        if(root.next != null) {
            System.out.print("root's right" + root.next.data + " ");
        }
        printPrOrderTree(root.left);
        printPrOrderTree(root.right);
    }

    // main method
    public static void main(String args[]) {
        PopulateRightPointer tree = new PopulateRightPointer();
        tree.root = new TreeLinkNode (3); 
		tree.root.left = new TreeLinkNode (2); 
		tree.root.right = new TreeLinkNode (5); 
		tree.root.left.left = new TreeLinkNode (1); 
        tree.root.left.right = new TreeLinkNode (4); 
        tree.root.right.left = new TreeLinkNode (6); 
        tree.root.right.right = new TreeLinkNode (7); 
        printPrOrderTree(tree.root);
        connectRightNode(tree.root);
    }
}