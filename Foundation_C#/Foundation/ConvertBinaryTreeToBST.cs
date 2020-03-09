using System;

namespace Foundation {
    public class ConvertBinaryTreeToBST {
        Node root;
        static int i;
        static int j;

        public void ChangeTreetoBST(Node root) {
            int[] inorderArr = new int[7];
            CreateInorderArray(root, inorderArr);
            Array.Sort(inorderArr);
            ChangeNodeValue(root, inorderArr);
        }

        public void CreateInorderArray(Node root, int[] inorderArr) {
            if(root == null) {
                return;
            }
            CreateInorderArray(root.left, inorderArr);
            inorderArr[i++] = root.data;
            CreateInorderArray(root.right, inorderArr);
        }

        public void ChangeNodeValue(Node root, int[] inorderArr) {
            if(root == null) {
                return;
            }
            ChangeNodeValue(root.left, inorderArr);
            root.data = inorderArr[j++];
            System.Console.Write(root.data + " ");
            ChangeNodeValue(root.right, inorderArr);
        }
    }
}