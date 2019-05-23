class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
public class PrintAllAncessatorNode {
    Node root;
    //Print all ancessator of a node
    public boolean printAncessator(Node node, Node target) {
        if(node == null) {
            return false;
        }

        if(node.data == target.data) {
            return true;
        }

        if(printAncessator(node.left, target) || printAncessator(node.right, target)) {
            System.out.print(node.data);
            return true;
        }
        return false;
    }
    
    //main method
    public static void main(String args[]) {
        PrintAllAncessatorNode tree = new PrintAllAncessatorNode();
        tree.root = new Node(5);
        tree.root.left = new Node(6);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(2);
        tree.root.right.right = new Node(1);
        boolean isAncessator = tree.printAncessator(tree.root, tree.root.right.right);
        System.out.print(isAncessator);
    }
}