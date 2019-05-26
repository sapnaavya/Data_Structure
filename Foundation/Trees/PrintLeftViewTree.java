/* This code print left most view of the tree using three ways:
 -> Using Recursion
 -> Using queues
 -> Using hashMap
*/

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

//Node class 
class Node{
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
public class PrintLeftViewTree {
    Node root;
    static int maxLevel;

    //Inorder Traversal
    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //print left most view 
    public static void printLeftMostView(Node root, HashMap<Integer, Integer> map, int level) {
        if(root == null) {
            return;
        }

        if(!map.containsKey(level)) {
            map.put(level, root.data);
        }
        printLeftMostView(root.left, map, level + 1);
        printLeftMostView(root.right, map, level + 1);
    }

    //Print left most view of the tree
    public void leftMostViewUsingHashMap(Node root) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int level = 1;
       printLeftMostView(root, map, level);
        
       for(int i=1; i<=map.size(); i++) {
           System.out.print(map.get(i) + " ");
       }
    }

    //printLeftMost view using level order traversal
    public void leftMostViewUsingQueues(Node root) {
        if(root == null) {
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            Node leftMostElement = queue.peek();
            System.out.print(leftMostElement.data + " ");
            while(count > 0) {
                Node elem = queue.poll();
                if(elem.left != null) {
                    queue.add(elem.left);
                }
                if(elem.right != null) {
                    queue.add(elem.right);
                }
                count--;
            }
        }
    }

    /*print left most view using recursion - Time Complesity O(n)
    -> We are using maxlevel static variable to maximum level we have visited in the tree and keep on changing it with level
        as we go to new level
    */
    public void printLeftMostViewRecursion(Node root, int level) {
        if(root == null) {
            return;
        }

        if(maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        printLeftMostViewRecursion(root.left, level + 1);
        printLeftMostViewRecursion(root.right, level + 1);
    }


    //main method
    public static void main(String args[]) {
        PrintLeftViewTree tree = new PrintLeftViewTree();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(10);
        tree.root.left.left.right.left = new Node(30);
        tree.inOrder(tree.root);

        System.out.println("\n");
        tree.leftMostViewUsingHashMap(tree.root);

        System.out.println("\n");
        tree.leftMostViewUsingQueues(tree.root);

        System.out.println("\n");
        tree.printLeftMostViewRecursion(tree.root, 1);
    }
}