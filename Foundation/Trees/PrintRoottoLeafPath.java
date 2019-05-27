/* This code prints all the path from root to leaf node using array datastructure */

class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
public class PrintRoottoLeafPath{
    Node root;
    
    public void printPath(Node root) {
        int path[] = new int[1000];
        printPathRec(root, path, 0);
    }

    public static void printPathRec(Node root, int[] path, int len) {
        if(root == null) {
            return;
        }
        path[len]  = root.data;
        len ++;

        if(root.left == null && root.right == null) {
            printArray(path, len);
        } else {
            printPathRec(root.left, path, len);
            printPathRec(root.right, path, len);
        }
    }

    //print path from root to leaf
    static void  printArray(int[] arr, int len) {
        int i;
        for(i=0; i<len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    //main method
    public static void main(String args[]) {
        PrintRoottoLeafPath tree = new PrintRoottoLeafPath();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
        tree.printPath(tree.root);
    }
}