// Java program to Get Level of a node in a Binary Tree 
/* A tree node structure */

import java.util.Queue;
import java.util.LinkedList;

public class TreeHeight { 
	Node root; 
	static class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int d) 
		{ 
			data = d; 
			left = right = null; 
		} 
	}
	/* Helper function for getLevel(). It returns level of the data 
	if data is present in tree, otherwise returns 0.*/
	int getHeightRecursive(Node node) 
	{ 
        if (node == null){
            return 0;
		}

		int leftHeight = getHeightRecursive(node.left); 
		int rightHeight = getHeightRecursive(node.right);  
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	} 
	/* Get Height of a tree using iterative Method - Using queue */
	public int getHeightIterative(Node root) {
		if(root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList();
		int height = 0;
		queue.add(root);
		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0) {
				return height;
			}
			height++;
			while(nodeCount > 0) {
				Node node = queue.poll();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				nodeCount--;
			}	
		}
		//return height;
	}
	/* Driver function to test above functions */
	public static void main(String[] args) 
	{ 
		TreeHeight tree = new TreeHeight (); 

		/* Constructing tree given in the above figure */
		tree.root = new Node(3); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1);  
		tree.root.left.right = new Node(4); 
		tree.root.left.left.left = new Node(5); 
		tree.root.left.left.right = new Node(6); 
        int height = tree.getHeightRecursive(tree.root);
		System.out.println("Height of tree using recursive " + height); 
		int heightUsingIterative = tree.getHeightIterative(tree.root);
		System.out.println("Height of tree using iterative " + heightUsingIterative); 
	} 
} 

