
class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
public class DiameterofTree {
    Node root;

    //print inorder traversal
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    } 

    //Calculate height of the tree
    public int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lheight = height(root.left) + 1;
        int rheight = height(root.right) + 1;
        if(lheight > rheight) {
            return lheight;
        }
        else {
            return rheight;
        }
    }

    //calculate diameter of the tree
    public int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return (Math.max((lheight + rheight + 1), Math.max(ldiameter, rdiameter)));
    }
    //main method
    public static void main(String args[]) {
        DiameterofTree tree = new DiameterofTree();
        tree.root = new Node(10);   
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left = new Node(20);
        tree.root.left.right.left.right = new Node(25);
        tree.root.left.right.left.right.left = new Node(8);   
        tree.inorder(tree.root);
        int height = tree.height(tree.root);
        System.out.println("height of tree: " + height);

        int diameter = tree.diameter(tree.root);
        System.out.println("Diameter of tree: " + diameter);
    }
}