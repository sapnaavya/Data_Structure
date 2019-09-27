// This code takes the inorder and preorder seuqence and build tree from the sequence and print inorder traversal of that tree

class Node{
    char data;
    Node left, right;
    Node(char d) {
        data = d;
        left = right = null;
    }
}

public class BuildTreeInOrderTraversal{
    Node root;
    static int preIndex = 0;

    public Node buildTree(char in[], char pre[], int startIndex, int endIndex){
        if(startIndex > endIndex) {
            return null;
        }
        Node node = new Node(pre[preIndex++]);

        //check if sequence has only one element
        // DO NOT FORGET THAT STEP
        if(startIndex == endIndex) {
            return node;
        }

        //get the index of that node in inorder sequence
        int index = searchIndex(in, startIndex, endIndex, node.data);

        //recursive call to create build tree
        node.left = buildTree(in, pre, startIndex, index - 1);
        node.right = buildTree(in, pre, index + 1, endIndex);
        return node;
    }
 

    //search the index in the inorder sequence
    public int searchIndex(char in[], int start, int end, char val) {
        int i;
        for(i=start; i<end; i++) {
            if(in[i] == val) {
                return i;
            }
        }
        return i;
    }
    //inorder traversal
    public void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //main method
    public static void main(String args[]) {
        BuildTreeInOrderTraversal tree = new BuildTreeInOrderTraversal();
        char in[] =  new char[] {'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[] {'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);


        //print inorder
        tree.inOrder(root);
    }

}