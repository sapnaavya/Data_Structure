
// Java program to clone a linked list with random pointers using HashMap
import java.util.HashMap; 
import java.util.Map; 

// Linked List Node class 
class Node 
{ 
	int data;//Node data 
	Node next, random;//Next and random reference 

	//Node constructor 
	public Node(int data) 
	{ 
		this.data = data; 
		this.next = this.random = null; 
	} 
} 

// linked list class 
class ClonedLinkedList 
{ 
	Node head;//Linked list head reference 

	// Linked list constructor 
	public ClonedLinkedList(Node head) 
	{ 
		this.head = head; 
	} 

	// push method to put data always at the head 
	// in the linked list. 
	public void push(int data) 
	{ 
		Node node = new Node(data); 
		node.next = this.head; 
		this.head = node; 
	} 

	// Method to print the list. 
	static void print(Node node) 
	{ 
		//Node temp = node; 
		while (node != null) 
		{ 
			Node random = node.random; 
			int randomData = (random != null)? random.data: -1; 
			System.out.println("Data = " + node.data + 
							", Random data = "+ randomData); 
			node = node.next; 
		} 
	} 

	// Actual clone method which returns head 
	// reference of cloned linked list. 
	public Node clone() 
	{ 
		// Initialize two references, one with original 
		// list's head. 
		Node origCurr = head, cloneCurr = null; 

		// Hash map which contains node to node mapping of 
		// original and clone linked list. 
		Map<Node, Node> map = new HashMap<Node, Node>(); 

		// Traverse the original list and make a copy of that 
		// in the clone linked list. 
		while (origCurr != null) 
		{ 
			cloneCurr = new Node(origCurr.data); 
			map.put(origCurr, cloneCurr); 
			origCurr = origCurr.next; 
		} 

		// Adjusting the original list reference again. 
		origCurr = head; 

		// Traversal of original list again to adjust the next 
		// and random references of clone list using hash map. 
		while (origCurr != null) 
		{ 
			cloneCurr = map.get(origCurr); 
			cloneCurr.next = map.get(origCurr.next); 
			cloneCurr.random = map.get(origCurr.random); 
			origCurr = origCurr.next; 
		} 

		//return the head reference of the clone list. 
		return (map.get(head)); 
	}
	
	// Main method. 
	public static void main(String[] args) 
	{ 
		// Pushing data in the linked list. 
		ClonedLinkedList list = new ClonedLinkedList(new Node(5)); 
		list.push(4); 
		list.push(3); 
		list.push(2); 
		list.push(1); 

		// Setting up random references. 
		list.head.random = list.head.next.next; 
		list.head.next.random = 
			list.head.next.next.next; 
		list.head.next.next.random = 
			list.head.next.next.next.next; 
		list.head.next.next.next.random = 
			list.head.next.next.next.next.next; 
		list.head.next.next.next.next.random = 
			list.head.next; 

		// Making a clone of the original linked list. 
		Node clone = list.clone(); 

		// Print the original and cloned linked list. 
		System.out.println("Original linked list"); 
		print(list.head); 
		System.out.println("\nCloned linked list"); 
		print(clone); 
	} 
} 


