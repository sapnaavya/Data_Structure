using System;
namespace Foundation.Trees {
    public class ClosestElemBST {
        Node root;

        public Node GetClosesElemBST(Node root, int num) {
            if(root == null) {
                return null;
            }

            if(root.data - num == 0) {
                return root;
            }

            if(root.data > num) {
                if(root.left == null) {
                    return root;
                }
                // find closest in left side
                Node leftSmallest = GetClosesElemBST(root.left, num);
                if(Math.Abs(root.data - num) < Math.Abs(leftSmallest.data - num)) {
                    return root;
                }
                return leftSmallest;
            } 
            else {
                if(root.right == null) {
                    return root;
                }
                // find closest in the right side
                Node rightSmallest = GetClosesElemBST(root.right, num);
                if(Math.Abs(root.data - num) < Math.Abs(rightSmallest.data - num)) {
                    return root;
                } 
                return rightSmallest;  
            }
        } 
    }
}