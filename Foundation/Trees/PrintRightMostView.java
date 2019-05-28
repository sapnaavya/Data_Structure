/*This code prints the rightmost view of the tree in below ways

 -> Using queues .. using queues this problem has been solved in two ways:
    1. One, when we add in the queue from left to right. At that time, we check for nodecount to become 1 as that mean we have reached to the rightmost
    2. Two, we add elements in the queue from right to left and after coming out to size while loop, we take a peek that queue as it would be holding the rightmost element
 
 -> Using recursion 
*/

import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class PrintRightMostView {
    Node root;
    static int maxLevel = 0;

    //Print right most view using Queues; when we have queue count as 1 that mean it is the rightmost element. So, we are printing that data
    public void printRightmostViewUsingQueues(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();

            while(count > 0) {
                Node node = queue.poll();
                if(count == 1) {
                    System.out.print(node.data + " ");
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                count-- ;
            }
        }

    }

    //print rightmost view of the tree using recursion
    public void rightmostViewRecursion(Node root, int level) {
        if(root == null) {
            return;
        }

        if(maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        rightmostViewRecursion(root.right, level + 1);
        rightmostViewRecursion(root.left, level + 1);
    }

    //Print inorder of the tree
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Print rightmostview of the tree
    public void printRightmostViewrighttoLeft(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node peekNode = queue.peek();
            System.out.print(peekNode.data + " ");

            while(size-- > 0) {
                Node temp = queue.poll();
                if(temp.right != null) {
                    queue.add(temp.right);
                }

                if(temp.left != null) {
                    queue.add(temp.left);
                }
            }

        }
    }
    
    //main method
    public static void main(String args[]) {
        PrintRightMostView tree = new PrintRightMostView();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.inOrder(tree.root);

        System.out.println("\n");
        System.out.println("Using Queues");
        tree.printRightmostViewUsingQueues(tree.root);

        System.out.println("\n");
        System.out.println("Using recursion");
        tree.rightmostViewRecursion(tree.root, 1);

        System.out.println("\n");
        System.out.println("Using Queues another way");
        tree.printRightmostViewrighttoLeft(tree.root);

    }
}