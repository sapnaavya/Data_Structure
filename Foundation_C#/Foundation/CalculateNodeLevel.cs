// level of root node is 1
using System.Collections.Generic;

namespace Foundation {
    public class NodeLevel {
        Node root;

        public int CalculateNodeLevelRecursive(Node root, Node node1, int level) {
            if(root == null || node1 == null) {
                return 0;
            }
            if(root.data == node1.data) {
                return level;
            }
            
            int downLevel = CalculateNodeLevelRecursive(root.left, node1, level + 1);
            if(downLevel !=  0) {
                return downLevel;  
            }

            downLevel = CalculateNodeLevelRecursive(root.right, node1, level + 1);
            return downLevel;
        }

        public int CalculateNodeLevelIter(Node root, Node node) {
            if(root == null || node == null) {
                return -1;
            }
            
            Queue<Node> queue = new Queue<Node>();
            queue.Enqueue(root);
            int level = 0;
            while(queue.Count != 0) {
                int size = queue.Count;
                level++;
                while(size > 0) {
                    Node temp = queue.Dequeue();
                    if(temp.data == node.data) {
                        return level;
                    }
                    if(temp.left != null) {
                        queue.Enqueue(temp.left);
                    }
                    if(temp.right != null) {
                        queue.Enqueue(temp.right);
                    }
                    size--;
                }
            }
            return -1;
        }
    }
}