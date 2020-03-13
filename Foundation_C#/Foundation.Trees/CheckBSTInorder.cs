using System;

namespace Foundation.Trees {
    public class CheckBSTInorder {
        public Node root;
        public Node prev;
        
        public bool isBST() {
            prev = null;
            return isBST(root);
        }

        Boolean isBST(Node node) 
        { 
            // traverse the tree in inorder fashion and 
            // keep a track of previous node 
            if (node != null) 
            { 
                if (!isBST(node.left)) 
                    return false; 
    
                // allows only distinct values node 
                if (prev != null &&  
                    node.data <= prev.data ) 
                    return false; 
                prev = node; 
                return isBST(node.right); 
            } 
            return true; 
        } 
    }
}

