class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class CreateBSTFromSortedArray {

    //function to create BST from sorted array
    public static Node creatBST(int[] arr, int start, int end) {
        if(arr.length == 0) {
            return null;
        }
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it left child of root */
        node.left = creatBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it right child of the root */
        node.right = creatBST(arr, mid + 1, end);

        return node;
    }

    // a utility function to create preorder traversal of BST
    public static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    //main method
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int start = 0;
        int end = arr.length - 1;
        Node node = creatBST(arr, start, end);
        preOrder(node);
    }
}