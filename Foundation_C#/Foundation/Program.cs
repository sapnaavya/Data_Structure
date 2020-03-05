using System;

namespace Foundation
{
    public class Program { 
        static void Main(string[] args)
        {
            // check a tree is BST or not
            //CheckBSTInorder tree = new CheckBSTInorder();
            //CheckBSTRecursive tree = new CheckBSTRecursive();
            //CheckBSTQueue tree = new CheckBSTQueue();
            
            // Calculate height of the tree
            //TreeHeight tree = new TreeHeight();

            // Calculate level of a node
            //NodeLevel nodeLevel = new NodeLevel();

            Node root = new Node(4);
            root.left = new Node(2);
            root.right = new Node(5);
            root.left.left = new Node(6);
            root.left.right = new Node(7);
            root.left.left.left = new Node(8);
            
            
            // count unival sub tree in a tree
            // CountUnivalTree tree = new CountUnivalTree();
            // bool flag = tree.UnivalTreeCheck(root);
            // tree.printCount();

            // find LCA of binary Tree
            Node node1 = new Node(8);
            Node node2 = new Node(7);
            FindLCA tree = new FindLCA();
            Node lcaNode = tree.FindLCABinaryTree(root, node1, node2);
            System.Console.WriteLine(lcaNode.data);


            //Print ancessator of a node
            // Node root1 = new Node(8);
            // PrintAnccessatorNode tree = new PrintAnccessatorNode();
            // bool foundAncessator = tree.PrintAncessator(root, root1);
            
            //System.Console.WriteLine(nodeLevel.CalculateNodeLevelIter(root, root1));
            //System.Console.WriteLine(nodeLevel.CalculateNodeLevelRecursive(root, root1, 1));
            //System.Console.WriteLine(tree.CalculateHeightIterative(root));
            //System.Console.WriteLine(tree.CalculateHeightRecursice(root));
        }
    }
}
