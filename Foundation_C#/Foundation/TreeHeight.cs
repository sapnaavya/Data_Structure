using System.Collections.Generic;

namespace Foundation {
    public class TreeHeight {

        public int CalculateHeightRecursice(Node root) {
            if(root == null) {
                return 0;
            }
            int leftHeight = CalculateHeightRecursice(root.left);
            int rightHeight = CalculateHeightRecursice(root.right);
            if(leftHeight > rightHeight) {
                return leftHeight + 1;
            }
            return rightHeight + 1;
        }

        public int CalculateHeightIterative(Node root) {
            if(root == null) {
                return 0;
            }

            Queue<Node> queue = new Queue<Node>();
            int height = 0;
            queue.Enqueue(root);
            while(true) {
                int nodeCount = queue.Count;
                if(nodeCount == 0) {
                    return height;
                }
                height++;
                while(nodeCount > 0) {
                    Node node = queue.Dequeue();
                    if(node.left != null) {
                        queue.Enqueue(node.left);
                    }
                    if(node.right != null) {
                        queue.Enqueue(node.right);
                    }
                    nodeCount--;
                }
            } 
        }
    }
}