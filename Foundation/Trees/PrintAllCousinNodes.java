/* Code to print all cousins of a node
Idea: 
 -> add root element to the queue and calcalculate the size and take one boolean variabe found 
 -> We are using two while loop, one to check if queue is not empty and element is found or not
 -> Another while loop we are using to push all the elements at one level till the nodcount is 0. That mean, we have pushed 
    all the element at that level to queue except the sibling node and node itself as we only want to print 
-> The moment found boolean variable become true, mean thats the node is found and we dont want tp push that one, So , we will come out of the loop
    and print the queue element as it would contain all the elements of that node level except sibling and node itself
 */
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;
    Node (int d) {
        data = d;
        left = right = null;
    }
}
public class PrintAllCousinNodes {
    Node root;

    //Print inorder
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    //print cousin of the nodes
    public static void printCousins(Node root, Node node1) {
        if(root == null) {
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean found = false;
        int nodeCount = 0;
        while(queue.isEmpty() == false && found == false) {
            nodeCount = queue.size();
            while(nodeCount-- > 0) {
                Node temp = queue.poll();

                if(temp.left == node1 || temp.right == node1) {
                    found = true;
                    continue;
                } else {
                    if(temp.left != null) {
                        queue.add(temp.left);
                    }
                    if(temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
        
        if(found == true) {
            int size = queue.size();
            if(size > 0) {
                System.out.print("Cousins of " + node1.data + " are: ");
                for(int i=0; i<size; i++) {
                    Node node = queue.poll();
                    System.out.print(node.data + " ");
                }
            } else {
                System.out.print("No cousins found..");
            }

        } else{
            System.out.print("No cousins found");
        }
    }


    //main method
    public static void main(String args[]){
        PrintAllCousinNodes tree = new PrintAllCousinNodes();
        tree.root = new Node(3); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(4); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        printCousins(tree.root, tree.root.right);
    }
}