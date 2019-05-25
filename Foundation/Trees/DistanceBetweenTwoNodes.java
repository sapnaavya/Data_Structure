/* To calculate distance between two nodes, Follow below steps:
    -> find LCA between two nodes
    -> find level of LCA from both nodes and combine both the levels as that would be distance between node1 and node2
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
public class DistanceBetweenTwoNodes {
    Node root;

    //calculate LCA between two nodes
    public static Node lcaTwoNode(Node root, Node node1, Node node2) {
        if(root == null) {
            return null;
        }
        if(root.data == node1.data || root.data == node2.data) {
            return root;
        }

        Node leftNode = lcaTwoNode(root.left, node1, node2);
        Node rightNode =  lcaTwoNode(root.right, node1, node2);
        
        if(leftNode != null && rightNode != null) {
            return root;
        }
        
        if(leftNode != null) {
            return leftNode;
        }
        else{
            return rightNode;
        }
    }

    //Calculate level of nodes from LCA
    public static int  levelofNode(Node root, Node node, int level) {
        if(root == null) {
            return -1;
        }
    
        if(root.data == node.data) {
            return level;
        }
        
        int llevel = levelofNode(root.left, node, level + 1);
        if(llevel != -1) {
            return llevel;
        }

        llevel = levelofNode(root.right, node, level + 1);
        return llevel;
    }

    //Calculate distance between two nodes - This function will first get the LCA of nodes and then calculate the level of nodes from LCA
    public static int distanceBetweenTwoNodes(Node root, Node node1, Node node2) {
        if(root == null || node1 == null || node2 == null) {
            return 0;
        }
        Node lca = lcaTwoNode(root, node1, node2);

        int level1 = levelofNode(lca, node1, 0);
        int level2 = levelofNode(lca, node2, 0);
        return level1 + level2;
    }

    //Inroder traversal of the tree
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Main Method
    public static void main(String args[]) {
        DistanceBetweenTwoNodes tree = new DistanceBetweenTwoNodes();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(7);
        tree.inOrder(tree.root);
         
        int distance = distanceBetweenTwoNodes(tree.root, tree.root, tree.root.left.right.left);
        System.out.println("Distance between two nodes: " + distance);
    }
}