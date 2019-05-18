class Count {
    int count = 0;
}
public class FindUnivalSubTree {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    
    Node root; 
    Count ct = new Count();

    public int countSingle() {
        return countSingle(root);
    }

    private int countSingle(Node node) {
        countSingleRec(node, ct);
        return ct.count;
    }
    private boolean countSingleRec(Node node, Count c) {
        if(node == null) {
            return true;
        }
        //Recursively count left and right unival subtree
        boolean left =  countSingleRec(node.left, c);
        boolean right = countSingleRec(node.right, c);

        //if any of the subtree is false, then it is not unival subtree
        if(left == false || right == false) {
            return false;
        }

        //If left subtree is singly and non empty but data does not match
        if(node.left != null && node.left.data != node.data) {
            return false;
        }

        if(node.right != null && node.right.data != node.data) {
            return false;
        }

        c.count++;
        return true;

    }
    //Main method
    public static void main(String args[]) {
        FindUnivalSubTree tree = new FindUnivalSubTree();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(4);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("the count of unival subtree:" + tree.countSingle());
    }
}