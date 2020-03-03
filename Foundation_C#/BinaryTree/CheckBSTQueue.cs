using System;
using System.Collections.Generic;


namespace Foundation {
    public class BNode {
        public Node node;
        public int min, max;
        
        public BNode(Node node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public class CheckBSTQueue {
        public Node root;
        public bool isBST() {
            if(root == null) {
                return true;
            }

            Queue<BNode> queue = new Queue<BNode>();
            BNode bnode = new BNode(root, int.MinValue, int.MaxValue);
            queue.Enqueue(bnode);
            while(queue.Count != 0) {
                BNode tmp = queue.Dequeue();
                if(tmp.node.data < tmp.min && bnode.node.data > tmp.max) {
                    return false;
                }
                if(tmp.node.left != null) {
                    queue.Enqueue(new BNode(tmp.node.left, tmp.min, tmp.node.data));
                }
                if(tmp.node.right != null) {
                    queue.Enqueue(new BNode(tmp.node.right, tmp.node.data, tmp.max));
                }
            }
            return true;
        }
    }
}