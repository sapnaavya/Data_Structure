using System;

namespace Foundation {
    public class PrintAnccessatorNode {
        public bool PrintAncessator(Node root, Node node1) {
            if(root == null) {
                return false;
            }

            if(root.data == node1.data) {
                return true;
            }

            if(PrintAncessator(root.left, node1) || PrintAncessator(root.right, node1)) {
                System.Console.WriteLine(root.data);
                return true;
            }
            return false;
        }
    }
}