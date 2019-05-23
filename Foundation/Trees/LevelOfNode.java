// Java program to Get Level of a node in a Binary Tree 
/* A tree node structure */
class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class LevelOfNode 
{ 
    Node root; 
    //Returns level of a specific node
	int getLevelUtil(Node node, int data, int level) 
	{ 
		if (node == null) 
			return 0; 

		if (node.data == data) 
			return level; 

		int downlevel = getLevelUtil(node.left, data, level + 1); 
		if (downlevel != 0) 
			return downlevel; 

		downlevel = getLevelUtil(node.right, data, level + 1); 
		return downlevel; 
	} 

	int getLevel(Node node, int data) 
	{ 
		return getLevelUtil(node, data, 1); 
	} 

	/* main method */
	public static void main(String[] args) 
	{ 
		LevelOfNode tree = new LevelOfNode(); 
		tree.root = new Node(3); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(4); 
        int data = 123;
        int level = tree.getLevel(tree.root, data);
        if(level != 0){
            System.out.print("level: " + level);
        }
        else{
            System.out.print(data + " not present in the tree");
        }
	} 
}  
