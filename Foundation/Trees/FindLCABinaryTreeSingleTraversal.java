
public class FindLCABinaryTreeSingleTraversal {
    
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;
    Node findLCA(int node1, int node2) {
        return findLCA(root, node1, node2);
    }

    Node findLCA(Node node, int n1, int n2) {
        if(node == null) {
            return null;
        }
        if(node.data == n1 || node.data == n2) {
            return node;
        }

        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        if(leftLCA != null && rightLCA != null) {
            return node;
        }
        return(leftLCA != null) ? leftLCA : rightLCA;
    }

    //Main method
    public static void main(String args[]) 
    { 
        FindLCABinaryTreeSingleTraversal tree = new FindLCABinaryTreeSingleTraversal(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        System.out.println("LCA(4, 5) = " + 
                            tree.findLCA(4, 5).data); 
        System.out.println("LCA(4, 6) = " + 
                            tree.findLCA(4, 6).data); 
        System.out.println("LCA(3, 4) = " + 
                            tree.findLCA(3, 4).data); 
        System.out.println("LCA(2, 4) = " + 
                            tree.findLCA(2, 4).data); 
    } 
}