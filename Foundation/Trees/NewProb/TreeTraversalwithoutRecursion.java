import java.util.Stack;

class Node {
    Node left;
    Node right;
    int data;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeTraversalwithoutRecursion {
    Node root;

    // function to do inorder traversal
    public void inOrderIter(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                Node top = stack.pop();
                System.out.print(top.data + " ");
                current = top.right;
            }
        }
    }

    // function to do preorder traversal
    public void preOrderIter(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.print(top.data + " ");
            if(top.right != null) {
                stack.push(top.right);
            } 
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }

    //function to print postOrder Traversal of tree
    //Caution: deletes the route between nodes
    public void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        //Node current = root;
        stack.push(root);
        while(!stack.isEmpty()) {
            Node current = stack.peek();
            if(isLeaf(current)) {
                Node top = stack.pop();
                System.out.print(top.data + " "); 
            } else {
                if(current.right != null) {
                    stack.push(current.right);
                    current.right = null;
                }
                if(current.left != null) {
                    stack.push(current.left);
                    current.left = null;
                }
            }
        }
    }

    //function to check if a node is a leaf node or not
    public static boolean isLeaf(Node root) {
        return root.left == null ? root.right == null : false;
    }

    // An iterative function to do postorder traversal  
    // of a given binary tree 
    private void postOrderIter(Node root) { 
        Stack<Node> stack = new Stack<>(); 
        while(true) { 
            while(root != null) { 
                stack.push(root); 
                stack.push(root); 
                root = root.left; 
            } 
              
            // Check for empty stack 
            if(stack.empty()) {
                return;
            }

            root = stack.pop(); 
              
            if(!stack.empty() && stack.peek() == root) {
                root = root.right;
            }     
            else {            
                System.out.print(root.data + " "); root = null; 
            } 
        } 
    } 

    //function to view top view of the tree
    public void topView(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }

        while(!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.print(top.data + " ");
        }
        
        current = root.right;
        while(current != null) {
            System.out.print(" " + current.data);
            current = current.right;
        }
    }

    // main method
    public static void main(String args[]) {
        TreeTraversalwithoutRecursion tree = new TreeTraversalwithoutRecursion();
        tree.root = new Node(4); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(6); 
		tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(8); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(2);
        tree.inOrderIter(tree.root);

        System.out.println();
        tree.preOrderIter(tree.root);

        System.out.println();
        tree.topView(tree.root);

        System.out.println();
        tree.postOrderIter(tree.root);

        System.out.println();
        tree.postOrderTraversal(tree.root);
    }
}