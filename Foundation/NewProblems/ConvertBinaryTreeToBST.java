/* 
    This code converts the Binary Tree in BST using following steps:
    1. Create in-order traversal of binary tree
    2. Sort the in-order traversal of binary tree using heap sort or just use Arrays.sort
    3. Traverse the binary tree in in-order fashion simultaneously the sorted in-order array
    4. Replace the values in binary tree with the ones in in-order array
    References:
        1. https://www.youtube.com/watch?time_continue=5&v=wBFttOncVUc
        2. https://www.ideserve.co.in/learn/convert-binary-tree-to-binary-search-tree

    Note: inorder of binary search tree stores the element in sorted array itself
*/

import java.util.Arrays;
import java.util.LinkedList;

public class ConvertBinaryTreeToBST  {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;
    int treeSize;
    static int i = 0;
    static int j = 0;

    private TreeNode createTree() {
        this.root = new TreeNode(0);
        TreeNode n1   = new TreeNode(1);
        TreeNode n2   = new TreeNode(2);
        TreeNode n3   = new TreeNode(9);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(5);
        TreeNode n6   = new TreeNode(6);
        TreeNode n7   = new TreeNode(7);
        TreeNode n8   = new TreeNode(8);
    
        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        n2.left  = n5;
        n3.right = n6;
        n5.right = n7;
        n6.right = n8;
        treeSize = 9;
        return root;
    }

    private void createInorderArray(TreeNode currentNode, int[] inorder) {
        if (currentNode == null) {
            return;
        }
        createInorderArray(currentNode.left, inorder);
        System.out.print(currentNode.value + " ");
        inorder[i++] = currentNode.value;
        createInorderArray(currentNode.right, inorder);
    }

    private void changeNodeValues(TreeNode currentNode, int[] inorder) {
        if (currentNode == null) {
            return;
        }
        changeNodeValues(currentNode.left, inorder);
        currentNode.value = inorder[j++];
        changeNodeValues(currentNode.right, inorder);
    }

    public void printNodeInOrder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        printNodeInOrder(currentNode.left);
        System.out.print(currentNode.value + " ");
        printNodeInOrder(currentNode.right);
    }

    public void changeTreeToBST() {
        int[] inorder = new int[treeSize];
        createInorderArray(root, inorder);
        Arrays.sort(inorder);
        changeNodeValues(root, inorder);
    }

    public static void main(String[] args) {
        ConvertBinaryTreeToBST solution = new ConvertBinaryTreeToBST();
        solution.createTree();
        solution.changeTreeToBST();
        System.out.print("\n");
        System.out.print("Modified tree to BST: \n" );
        solution.printNodeInOrder(solution.root);
    }
}

