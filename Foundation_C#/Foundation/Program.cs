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

            Node root = new Node(10);
            root.left = new Node(5);
            root.right = new Node(15);
            root.left.left = new Node(7);
            root.left.right = new Node(9);
            root.right.left = new Node(12);
            root.right.right = new Node(17);
            
            // Tree Traversal 
            // TreeTraversal tree = new TreeTraversal();
            // tree.Inorder(root);
            // tree.PreOrder(root);
            // tree.PostOrder(root);

            //Print number in a given range - BST
            // PrintNumRangeBST tree = new PrintNumRangeBST();
            // tree.PrintNum(root, 5, 17);

            // get closet element to number -  BST
            ClosestElemBST tree = new ClosestElemBST();
            Node closestNode = tree.GetClosesElemBST(root, 22);
            System.Console.WriteLine(closestNode.data);


            // count no of bsts in a tree
            // CountBST tree = new CountBST ();
            // BSTInfo info = tree.countBST(root);
            // System.Console.WriteLine(info.num_bst);

            // count unival sub tree in a tree
            // CountUnivalTree tree = new CountUnivalTree();
            // bool flag = tree.UnivalTreeCheck(root);
            // tree.printCount();

            
            // find LCA of binary Tree
                // Node node1 = new Node(8);
                // Node node2 = new Node(7);
                // FindLCA tree = new FindLCA();
                // Node lcaNode = tree.FindLCABinaryTree(root, node1, node2);
                // System.Console.WriteLine(lcaNode.data);


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
