/* Code to do tree traversal (InOrder, PreOrder, PostOrder) in a recursive way */

import java.util.Queue;
import java.util.LinkedList;
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

    //preorder -> root -> left -> right
    public void preOrder(Node root) {
        if(root == null) {
            return ;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    //inorder -> left -> root -> right
    public void inOrder(Node root) {
        if(root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    //postorder ->left ->right ->root
    public void postOrder(Node root) {
        if(root == null) {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }

    //level order traversal
    public void levelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node top = queue.poll();
            System.out.print(top.data);
            if(top.left != null) {
                queue.add(top.left);
            }
            if(top.right != null) {
                queue.add(top.right);
            }
        }
    }

    public void inOrder(){ inOrder(root); }
    public void preOrder(){ preOrder(root); }
    public void postOrder(){postOrder(root); }
    public void levelOrder(){levelOrder(root); }

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
        System.out.print("\n");
        tree.levelOrder();
    }
}
  