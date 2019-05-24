class Node 
{ 
    int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 

public class MirrorTree {

    public static void mirrorTree(Node root) {
        if(root == null) {
            return;
        }

        Node temp;

        //Mirror subtree
        mirrorTree(root.left);
        mirrorTree(root.right);

        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public void inOrder(Node node) 
    { 
        if (node == null) 
            return; 
  
        inOrder(node.left); 
        System.out.print(node.data + " "); 
        inOrder(node.right); 
    }
    public static void main(String args[]) {
        TreeTraversal tree  = new TreeTraversal();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.inOrder(tree.root);
        mirrorTree(tree.root);
        System.out.print("\n");
        tree.inOrder(tree.root);
    }
}