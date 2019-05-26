/* This code finds out if two nodes are cousin to each other using below steps and prints the sum of both cousin nodes.

 -> Check level of both nodes.. if levels are different return false as cousing nodes are supposed to be at same level
 -> if levels are same then check if both nodes are not sibling i.e. they dont belong to same parent
 -> if they dont belong to same parents and they both have same levels, means they are cousin to each other

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

//Cousin nodes class
public class CousinNodes {
    Node root;
    //Print inorder
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    //calculate level of a node
    public static int countLevel(Node root, Node node1, int level) {
        if(root == null) {
            return -1;
        }
        if(root.data == node1.data) {
            return level;
        }
        
        int lllevel;
        lllevel = countLevel(root.left, node1, level + 1);
        if(lllevel != -1) {
            return lllevel;
        }

        return countLevel(root.right, node1, level + 1);
    }

    //Check if two nodes are siblings to each other i.e. if they both have same parents
    public static boolean isSibling(Node root, Node node1, Node node2) {
        if(root == null) {
            return false;
        }

        if((root.left ==  node1 && root.right == node2) || (root.right == node2 && root.left == node2)) {
            System.out.println("data");
            return true;
        }

        return(isSibling(root.left, node1, node2) || isSibling(root.right, node1, node2));
    }

    //Check if two nodes are at the same level or not
    public  static boolean checkLevel(Node root, Node node1, Node node2) {
        int level = 1;
        int level1 = countLevel(root, node1, level);
        int level2 = countLevel(root, node2, level);

        if(level1 != level2) {
            return false;
        }
        else if(!isSibling(root, node1, node2)) {
            int sumofTwoCousinNodes = node1.data + node2.data;
            System.out.println("sum of two cousin nodes: " + sumofTwoCousinNodes);
            return true;
        } else { 
            return false;
        }
    }

    //main method
    public static void main(String args[]) {
        CousinNodes tree = new CousinNodes();
        tree.root = new Node(3); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(4); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        boolean isCousin = checkLevel(tree.root, tree.root.left.left, tree.root.right.right);
        System.out.println(isCousin);
    }
}