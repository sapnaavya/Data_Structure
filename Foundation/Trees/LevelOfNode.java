// Java program to Get Level of a node in a Binary Tree 

/* A tree node structure 
	Assumption: 
		1. In iterative approach, we are making sure the data will be unique.. as the queue will return the moment it will find the first match
		2. In recursive approach as well, we need to make sure the data is not duplicated as this code does not support duplicated data
		
	In duplicated data, To fetch the last value from a level we can use treemap with key as node data and level as value.. this way, if we get 
	the duplicated  node value, treemap will replace node value in the tree map and store the latest key (node value) 	
*/

import java.util.Queue;
import java.util.LinkedList;

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

	//print level of a node using iterative method - Queue
	public int levelofNodeIterative(Node root, Node node1) {
		if(root == null || node1 == null) {
			return -1;
		}

		int level = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			level = level + 1;

			while(size-- > 0) {
				Node temp = queue.poll();
				if(temp.data == node1.data) {
					return level;
				}
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
		return -1;
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
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.left.left = new Node(8);
		tree.root.left.left.left.left.left = new Node(9);
        tree.root.left.right = new Node(4); 
        int data = 123;
        int level = tree.getLevel(tree.root, data);
        if(level != 0){
            System.out.print("level: " + level);
        }
        else{
            System.out.print(data + " not present in the tree");
		}
		
		System.out.print("\n");
		int levelIterative = tree.levelofNodeIterative(tree.root, tree.root.left.left.left.left.left);
		System.out.println("level of a node: " + levelIterative);
	} 
}  
