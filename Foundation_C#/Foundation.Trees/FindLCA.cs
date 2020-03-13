namespace Foundation.Trees {
    public class FindLCA {
        public Node FindLCABinaryTree(Node root, Node node1, Node node2) {
            if(root == null) {
                return null;
            }
            
            if(root.data == node1.data || root.data == node2.data) {
                return root;
            }

            Node left = FindLCABinaryTree(root.left, node1, node2);
            Node right = FindLCABinaryTree(root.right, node1, node2);

            if(left != null && right != null) {
                return root;
            }
            if(left != null) {
                return left;
            }
            return right;
        }
    }
}