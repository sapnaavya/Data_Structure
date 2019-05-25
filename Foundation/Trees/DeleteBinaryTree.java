class Node{
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class DeleteBinaryTree{
    Node root;

    //delte a binary tree - in postOrder Traversal
    public void deletetree(Node node) {
        if(node == null) {
            return;
        }
        deletetree(node.left);
        deletetree(node.right);
        System.out.print("deleting node" + node.data);
        node = null;
        System.out.print("\n");
    }

    /*
    void deleteTree(Node node)  
    { 
        // In Java automatic garbage collection 
        // happens, so we can simply make root 
        // null to delete the tree 
        root = null; 
    }
    */ 

    //main method
    public static void main(String args[]) {
        DeleteBinaryTree tree  = new DeleteBinaryTree();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.deletetree(tree.root);
    }

}