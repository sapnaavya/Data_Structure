import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    int hd;
    Node left, right;
    Node(int d) {
        data = d;
        hd = Integer.MAX_VALUE; 
        left = right = null;
    }
}

public class PrintTopAndBottomView {
    Node root;
    //inorder traversal
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //print bottom most view of the tree
    public static void bottommostView(Node root, TreeMap<Integer, Integer> map, int hd) {
        if(root == null) {
            return;
        }
        
        root.hd = hd; 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root);
        
        while(!queue.isEmpty()) { 
            Node temp = queue.remove();
            hd = temp.hd;
            map.put(hd, temp.data);
            
            if(temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
    
        //bottommostView(root.left, map, hd - 1);
        //bottommostView(root.right, map, hd + 1);

    } 

    //util function for printing bottomost element in the tree
    public void bottomMost(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int hd = 0;
        bottommostView(root, map, hd);
        for(Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    } 

    //print topmost element in the tree
    public static void topmost(Node root, TreeMap<Integer, Node> map, int hd) {
        if(root == null) {
            return;
        }
        root.hd = hd;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            hd = temp.hd;
            if(!map.containsKey(temp.hd)) {
               map.put(hd, temp);
            }

            if(temp.left != null) {
                temp.left.hd = temp.hd - 1;
                queue.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = temp.hd + 1;
                queue.add(temp.right);
            }
        }
    }

    //util function to print topmost nodes in the tree
    public void printTopmost(Node node) {
        TreeMap<Integer, Node> map = new TreeMap<>();
        int hd = 0;
        topmost(node, map, hd);

        for(Entry<Integer, Node> entry: map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    //main method
    public static void main(String args[]) {
        PrintTopAndBottomView tree  = new PrintTopAndBottomView();
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(5); 
        tree.root.left.right = new Node(3); 
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(25); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        
        //print inorder
        tree.inorder(tree.root);

        //print bottommost view of the tree
        System.out.println("\n");
        tree.bottomMost(tree.root);
        
        //print topmost view of the tree
        System.out.println("\n");
        tree.printTopmost(tree.root);
    }
}