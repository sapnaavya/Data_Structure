/* Code to do tree traversal (InOrder, PreOrder, PostOrder) in a recursive way */


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

public class TreeTraversal {
    Node root;
    TreeTraversal() 
    { 
        root = null; 
    }

    public void preOrder(Node root) {
        if(root == null) {
            return ;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    

    public void inOrder(Node root) {
        if(root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }

    public void inOrder(){ inOrder(root); }
    public void preOrder(){ preOrder(root); }
    public void postOrder(){postOrder(root); }

    //Main Method
    public static void main(String args[]) {
        TreeTraversal tree  = new TreeTraversal();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);

        tree.preOrder();
        System.out.print("\n");
        tree.postOrder();
        System.out.print("\n");
        tree.inOrder();
    }
}
  