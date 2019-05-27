/* Code to print zig zag level traversal
 Logic: 
   1. Two stacks (currentstack and nextstack) and one boolean variable (leftToRight) have been used to keep track of movement from left to right or right to leaft
   2. if pushLeftToRight is true, we push left first and then right in order to print in zigZag shape
   3. if pushLeftToRight is false, we push right first and left later in order to print in zigZag shape 
   4. when currentstack is empty, we move next stack to currentstack and change boolean variable leftToRight
*/
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
public class ZigZagTraversal {
    Node root;
    public void printZigZagTraversal(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> currentStack = new Stack<>();
        Stack<Node> nextStack = new Stack<>();
        currentStack.push(root);
        boolean pushLeftToRight = true;
        while(!currentStack.isEmpty()) {
            Node temp = currentStack.pop();
            
            System.out.print(temp.data + " ");
            if(pushLeftToRight) {
                if(temp.left != null) {
                    nextStack.push(temp.left);
                }
                if(temp.right != null) {
                    nextStack.push(temp.right);
                }
            } else {
                if(temp.right != null){
                    nextStack.push(temp.right);
                }
                if(temp.left != null) {
                    nextStack.push(temp.left);
                }
            }

            if(currentStack.isEmpty()) {
                pushLeftToRight = !pushLeftToRight;
                Stack<Node> tempStack = currentStack;
                currentStack = nextStack;
                nextStack = tempStack;
            }
        }
    }

    //main method
    public static void main(String args[]) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(6); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(4); 
        tree.printZigZagTraversal(tree.root);
    }
}