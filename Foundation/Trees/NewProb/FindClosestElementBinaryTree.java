/**
 * This method finds the closest element to a target in binary search tree
 * Reference: https://algorithmsandme.com/find-closest-element-in-binary-search-tree/
 * 
 */
class Node {
    Node left;
    Node right;
    int data;
    Node(int data) {
        left = null;
        right = null;
        this.data = data;
    }
}

public class FindClosestElementBinaryTree {
    // function to print inorder traversal
    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    // function to find closest element to a target value
    public static int findClosestElem(Node root, int target) {
        if(root == null) {
            return -1;
        }

        int currentVal = root.data;
        if(currentVal - target == 0) { 
            return currentVal;
        }
        // if currentval is greate than target, then search on the left side as all right side values of currentval
        // will be greater than currentval
        if(currentVal > target) {
            if(root.left == null) return currentVal;
            // find closest on left side
            int closest = findClosestElem(root.left, target);
            if(Math.abs(closest - target) > Math.abs(currentVal - target)) {
                return currentVal;
            }
            return closest;
        }

        // if currentval is less than target, then search on the right side as all left side values of currentval
        // will be less than currentval
        else {
            if(root.right == null)  {
                return currentVal;
            }
            // find closest on the right side
            int closest = findClosestElem(root.right, target);
            if(Math.abs(closest - target) > Math.abs(currentVal - target)) {
                return currentVal;
            }
            return closest;
        }
    }
  
    // main method
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.right = new Node(17);
        root.right.left = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(9);
        // inOrder(root);
        int val = findClosestElem(root, 4);
        System.out.println(val);
    }  
}