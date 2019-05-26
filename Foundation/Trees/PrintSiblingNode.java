/* This code print sibling of a node using below two ways:
    -> Using recursion
    -> Using itertative method.. In this method queues data structure is used
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
public class PrintSiblingNode {
    Node root;
    //inorder traversal
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data  + " ");
        inorder(root.right);
    }

    //print sibling of a node using recursion
    public Node printSiblingRecursion(Node root, Node node1) {
        if(root == null) {
            return null;
        }
        if(root.data == node1.data) {
            System.out.print("Root does not have sibling");
            return null;
        }

        if(root.left != null && root.right != null && root.left.data == node1.data) {
            return root.right;
        } 
        else if(root.right != null && root.left != null && root.right.data == node1.data) {
            return root.left;
        }
        Node siblingNode = printSiblingRecursion(root.left, node1);

        if(siblingNode != null){
            return siblingNode;
        }

        siblingNode = printSiblingRecursion(root.right, node1);
        return siblingNode;
    
    }

    //Print sibling of a node using Queues
    public Node printSiblingIterative(Node root, Node node1) {
        if(root == null) {
            return null;
        }
        
        if(root.data == node1.data) {
            System.out.print("Root does not have sibling");
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.left != null) {
                if(temp.left.data == node1.data) {
                    if(temp.right != null) {
                        return temp.right;
                    } else{
                        System.out.print("No sibling");
                        return null;
                    }
                }
            }

            if(temp.right != null) {
                if(temp.right.data == node1.data) {
                    if(temp.left != null) { 
                        return temp.left;
                    } else {
                        System.out.print("No sibling");
                        return null;
                    }
                }
            }
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        return null;
    }

    //main method
    public static void main(String args[]) {
        PrintSiblingNode tree = new PrintSiblingNode();
        tree.root = new Node(3); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(4); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        tree.root.right.right.left = new Node(9);
        tree.root.right.right.right = new Node(10); 
        tree.inorder(tree.root);

        System.out.println("\n");
        Node siblingNode = tree.printSiblingIterative(tree.root, tree.root.right.left);
        if(siblingNode != null) {
            System.out.print("Sibling node using iterative: " + siblingNode.data);
        }

        System.out.print("\n");
        Node siblingNodeRecursion = tree.printSiblingRecursion(tree.root, tree.root.right.left);
        if(siblingNodeRecursion != null) {
            System.out.print("Sibling node using recursion: " + siblingNodeRecursion.data);
        }
    }
}