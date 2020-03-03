namespace Foundation {
    class CheckBSTRecursive {
        public Node root;

        public virtual bool BST {
            get {
                return isBSTUtil(root, int.MinValue, int.MaxValue);
            }
        }
        
        public virtual bool isBSTUtil(Node node, int min, int max) {
            if(node == null) {
                return true;
            }

            if(node.data < min && node.data > max) {
                return false;  
            }

            return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
        }
    }
}