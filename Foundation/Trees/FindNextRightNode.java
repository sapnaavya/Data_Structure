/* This code finds the next right node in the same level for the specific key 
    
     Logic: whenever we have nodeCount as 0 means that is the last node is the level and if we match with 
     the last node in the level, we return null.. else if we found the data and nodecount is not zero means that node has a right node at the same level
     So, we return that node.
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

public class FindNextRightNode {
    Node root;

    //Find next right node in the same level
    public Node nextRightNode(Node root, Node node1) {
        if(root == null) {
            return null;
        }
        if(root.data == node1.data) {
            System.out.println("root does not have right node");
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int nodeCount = queue.size();
            while(nodeCount-- > 0){
                Node temp = queue.poll();
                if(temp.data == node1.data) {
                    if(nodeCount != 0) {
                        Node nextRightNode = queue.poll();
                        return nextRightNode;
                    } else {
                        return null;
                    }
                }

                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return null;
    }

    //main method
    public static void main(String args[]) {
        FindNextRightNode tree = new FindNextRightNode();
        tree.root = new Node(10);  
        tree.root.left = new Node(2);  
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);  
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(20);   
        tree.root.right.right = new Node(5);  
        Node nextrightNode = tree.nextRightNode(tree.root,  tree.root.left.left);
        if(nextrightNode != null) {
            System.out.println("next right node data: " + nextrightNode.data);
        } else{
            System.out.println("next right node is null");
        }
    }
}