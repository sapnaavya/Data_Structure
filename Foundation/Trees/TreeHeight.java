// Java program to Get Level of a node in a Binary Tree 
/* A tree node structure */
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
	int getHeight(Node node) 
	{ 
        if (node == null){
            return 0;
		}

		int leftHeight = getHeight(node.left); 
		int rightHeight = getHeight(node.right);  
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
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
        int height = tree.getHeight(tree.root);
        System.out.println("Height of tree " + height); 
	} 
} 

