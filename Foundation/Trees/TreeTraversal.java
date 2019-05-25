/* Code to do tree traversal (InOrder, PreOrder, PostOrder, level order traversal and reverse level order traversal) in a recursive way
 -> For reverse level order traversal, we will poll elements from queue and push them to stack, once queue is empty,
     we will pop out elements from the stacks and print them. They would be printes in reverse level order traversal
*/

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
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
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    //inorder -> left -> root -> right
    public void inOrder(Node root) {
        if(root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //postorder ->left ->right ->root
    public void postOrder(Node root) {
        if(root == null) {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
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
            System.out.print(top.data + " ");
            if(top.left != null) {
                queue.add(top.left);
            }
            if(top.right != null) {
                queue.add(top.right);
            }
        }
    }

    //Print reverse Level Order Traversal
    public void reverseLevelOrder(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node top = queue.poll();
            stack.push(top);
            if(top.right != null) {
                queue.add(top.right);
            }

            if(top.left != null) {
                queue.add(top.left);
            }
        }

        while(!stack.isEmpty()) {
            Node topElem = stack.pop();
            System.out.print(topElem.data + " ");
        }
    }
    public void inOrder(){ inOrder(root); }
    public void preOrder(){ preOrder(root); }
    public void postOrder(){postOrder(root); }
    public void levelOrder(){levelOrder(root); }
    public void reverseLevelOrder(){reverseLevelOrder(root);}

    //Main Method
    public static void main(String args[]) {
        TreeTraversal tree  = new TreeTraversal();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        
        //preorder traversal
        tree.preOrder();
        System.out.print("\n");

        //postorder traversal
        tree.postOrder();
        System.out.print("\n");
        
        //inorder traversal
        tree.inOrder();
        System.out.print("\n");

        //levelorder traversal
        tree.levelOrder();
        System.out.print("\n");
        
        //reverse leveorder traversal
        tree.reverseLevelOrder();
        System.out.print("\n");
    }
}
  