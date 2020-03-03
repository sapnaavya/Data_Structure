using System;

namespace Foundation
{
    public class Program { 
        static void Main(string[] args)
        {
            //CheckBSTInorder tree = new CheckBSTInorder();
            //CheckBSTRecursive tree = new CheckBSTRecursive();
            CheckBSTQueue tree = new CheckBSTQueue();
            tree.root = new Node(4);
            tree.root.left = new Node(2);
            tree.root.right = new Node(5);
            tree.root.left.left = new Node(1);
            tree.root.left.right = new Node(3);
            if(tree.isBST()) {
                Console.WriteLine("is bst");
            }
            else {
                Console.WriteLine("Nope!!");
            }
        }
    }
}
