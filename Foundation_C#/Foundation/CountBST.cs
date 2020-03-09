using System;

namespace Foundation{
    public class CountBST {
        Node root;
        public BSTInfo countBST(Node root) {
            if(root == null) {
                return new BSTInfo(0, int.MinValue, int.MaxValue, true);
            }
            if(root.left == null && root.right == null) {
                return new BSTInfo(1, root.data, root.data, true);
            }
            
            BSTInfo l = countBST(root.left);
            BSTInfo r = countBST(root.right);
            
            BSTInfo info = new BSTInfo();
            info.min = Math.Min(root.data, Math.Min(l.min, r.min));
            info.max = Math.Max(root.data, Math.Max(l.max, r.max));

            if(l.is_bst && root.data > l.max && r.is_bst && root.data < r.min) {
                info.num_bst = 1 +  l.num_bst + r.num_bst;
                info.is_bst = true;
            } else {
                info.num_bst = l.num_bst + r.num_bst;
                info.is_bst = false;
            }

            return info;
        }
    }
}