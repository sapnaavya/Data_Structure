/**
 * This code converts binary tree to circular doubly linkedlist using Arraylist:
 *  1. Store inorder traversal to list and take out elements from list and convert them in doubly linkedlist
 *      Space complexity : O(n) 
 *      Time complexity: O(n)
 * 
 *  2) Can we do this inplace with using extra space so that space complexity is O(1) ?
    *  Write a general purpose function that concatenates two given circular doubly lists (This function is explained below).
            Now traverse the given tree
                ….a) Recursively convert left subtree to a circular DLL. Let the converted list be leftList.
                ….a) Recursively convert right subtree to a circular DLL. Let the converted list be rightList.
                ….c) Make a circular linked list of root of the tree, make left and right of root to point to itself.
                ….d) Concatenate leftList with list of single root node.
                ….e) Concatenate the list produced in step above (d) with rightList.
        
        Note that the above code traverses tree in Postorder fashion. We can traverse in inorder fashion also. 
        We can first concatenate left subtree and root, 
        then recur for right subtree and concatenate the result with left-root concatenation.
        
        How to Concatenate two circular DLLs?
            Get the last node of the left list. Retrieving the last node is an O(1) operation, since the prev pointer of the head points to the last node of the list.
            Connect it with the first node of the right list
            Get the last node of the second list
            Connect it with the head of the list.
        
            Time complexity: O(n)
            Space complexity: O(1)
*/

import java.util.ArrayList;
import java.util.List;
public class ConvertBinaryTreetoCircularDLL {
    //Node class
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    

    //inorder traversal of binary tree
    public static void inOrderTraversal(Node root, List<Node> list1) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, list1);
        //System.out.print(root.data + " ");
        list1.add(root);
        inOrderTraversal(root.right, list1);
    }

    //recursive function to convert binary tree to circular DLL with O(1) space complexity
    public static Node convertBtreeToCList(Node root) {
        if(root == null) {
            return null;
        }
        List<Node> list1 = new ArrayList<>();
        inOrderTraversal(root, list1);
        Node head = list1.get(0);

        //Create a current pointer
        Node current = head;

        for(int i = 1; i < list1.size(); i++) {
            //Create a temporary pointer to current
            Node temp = current;

            //current's right points to list.get(i)
            current.right = new Node(list1.get(i).data);

            //currren points to its right node
            current = current.right;
            
            //current left points to temp
            current.left = temp;
        }

        // make this doubly list to circular by connecting current's right and head's left
        //current's right points to head of the list
        current.right = head;

        //current's left points to current
        head.left = current;

        return head;
    }

    //Display circular doubly linkedlist
    public static void displayList(Node node) {
        Node itr = node;
       do {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while(node != itr);
    }

    public static Node btreeToCList(Node root) {
        if(root == null) {
            return null;
        }

        //recursively convert left and right subtree
        Node left = btreeToCList(root.left);
        Node right = btreeToCList(root.right);

        // Make a circular linked list of single node 
        // (or root). To do so, make the right and 
        // left pointers of this node point to itself 
        root.left = root.right = root; 

        return concatenateCDLL(concatenateCDLL(left, root), right);
    }

    public static Node concatenateCDLL(Node leftList, Node rightList) {
        if(leftList == null) {
            return rightList;
        } 
        if(rightList == null) {
            return leftList;
        }

        //store the last pointer of both leftlist and rightlist
        Node leftLast = leftList.left;
        Node rightLast = rightList.left;

        //connect both left list and right list
        leftLast.right = rightList;
        rightList.left = leftLast;
        leftList.left = rightLast;
        rightLast.right = leftList;

        return leftList;
    }       

    // main method
    public static void main(String args[]) {
        ConvertBinaryTreetoCircularDLL tree = new ConvertBinaryTreetoCircularDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        //Node listHead = convertBtreeToCList(tree.root);
        Node listHead1 = btreeToCList(tree.root);
        displayList(listHead1);
    }
}