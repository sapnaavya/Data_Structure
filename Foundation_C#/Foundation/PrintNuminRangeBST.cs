using System;
namespace Foundation {
    public class PrintNumRangeBST {
        Node root;

        public void PrintNum(Node root, int num1, int num2) {
            if(root == null) {
                return;
            }

            if(root.data > num1) {
                PrintNum(root.left, num1, num2);
            }
            if(root.data >= num1 && root.data <= num2) {
                System.Console.WriteLine(root.data);
            }
            if(root.data < num2) {
                PrintNum(root.right, num1, num2);
            }
        }
    }
}