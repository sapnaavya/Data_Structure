/**
 * This code counts the number of binary search trees in the binary tree
 * Reference: https://www.geeksforgeeks.org/count-the-number-of-binary-search-trees-present-in-a-binary-tree/
 */
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Info {
    int num_bst;
    int max;
    int min;
    boolean isBST;
    Info(int a, int b, int c, boolean d) {
        num_bst = a;
        max = b;
        min = c;
        isBST = d;
    }

    Info() {
    }
}

public class CountNoBSTs {
    static int countBSTs = 0;
    public static Info countnoBSTs(Node root) {
        if(root == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        if(root.left == null && root.right == null) {
            return new Info(1, root.data, root.data, true);
        }

        Info l = countnoBSTs(root.left);
        Info r = countnoBSTs(root.right);

        //create a node that has to be returned
        Info bst = new Info();
        bst.min = Math.min(root.data, Math.min(l.min, r.min));
        bst.max = Math.max(root.data, Math.max(l.max, r.max));

        if(l.isBST && r.isBST && root.data > l.max & root.data < r.min) {
            bst.isBST = true;
            bst.num_bst = 1 + l.num_bst + r.num_bst;
        } else {
            bst.isBST = false;
            bst.num_bst = l.num_bst + r.num_bst;
        }

        return bst;
    }

    //main method
    public static void main(String args[]) {
        Node root = new Node(5); 
        root.left = new Node(9); 
        root.right = new Node(3); 
        root.left.left = new Node(6); 
        root.right.right = new Node(4); 
        root.left.left.left = new Node(8); 
        root.left.left.right = new Node(7); 
        System.out.print(countnoBSTs(root).num_bst);
    }
}