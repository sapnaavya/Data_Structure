
import java.util.Queue;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
public class IdenticalTrees {
    Node root1, root2;

    //Check if two trees are identical or not - Recursive metho
    public boolean isIdenticalRecursive(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        // else if(root1 != null && root2 != null) {
        //     return (root1.data == root2.data && isIdentical(root1.left, root2.left) 
        //         && isIdentical(root1.right, root2.right));
        // }

        else if(root1 != null && root2 != null) {
            if(root1.data == root2.data){
                return isIdenticalRecursive(root1.left, root2.left ) && isIdenticalRecursive(root1.right, root2.right);
            }
        }
        return false;  
    }

    //Check if two binary trees are identical - Using Iterative method
    public boolean isIdenticalIterative(Node root1, Node root2) {
        
       // Return true if both trees are empty  
       if (root1 == null && root2 == null){
        //System.out.println("in the loop1");
        return true; 
       }   
  
        // Return false if one is empty and other is not  
        if (root1 == null || root2 == null) 
        { 
            return false; 
        }

        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        queue1.add(root1);
        queue2.add(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
           
            Node top1 = queue1.poll();
            Node top2 = queue2.poll();

            if(top1.data != top2.data) {
                System.out.println("in if block");
                return false;
            }

            //queue1.remove();
            //queue2.remove();
            
            //check left subtree
            if(top1.left != null && top2.left != null) {  
                queue1.add(top1.left);
                queue2.add(top2.left);
            } 
            else if(top1.left != null || top2.left != null) {
                System.out.println("in if block");
                return false;
            }

            //Check right subtree
            if(top1.right != null && top2.right != null) {
                queue1.add(top1.right);
                queue2.add(top2.right);
            } else if(top1.right != null || top2.right != null) {
                System.out.println("in if block");
                return false;
            }
        }
        return true;
    }

    //main method
    public static void main(String args[]) {
        IdenticalTrees tree  = new IdenticalTrees();
        tree.root1 =  new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(6);

        tree.root2 =  new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(6);
        boolean isIdentical = tree.isIdenticalRecursive(tree.root1, tree.root2);
        System.out.println("Identical Tree using Recursive method " + isIdentical);

        boolean isIdenticalIter = tree.isIdenticalIterative(tree.root1, tree.root2);
        System.out.println("Identical Tree using Iterative methods " + isIdenticalIter);
    }
}