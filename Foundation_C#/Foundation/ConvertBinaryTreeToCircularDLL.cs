using System;
using System.Collections.Generic;

namespace Foundation {
    public class ConvertBinaryTreeToCircularDLL {
        Node root;

        public void DisplayList(Node root) {
            Node itr = root;
            do {
                System.Console.Write(itr.data + " ");
                itr = itr.right;
            } while(root != itr);
        }

        public Node BTreeToClistRecur(Node root) {
            if(root == null) {
                return null;
            }

            // recursively, converse left and right subtree
            Node left = BTreeToClistRecur(root.left);
            Node right = BTreeToClistRecur(root.right);

            // Make a circular linked list of single node 
            // (or root). To do so, make the right and 
            // left pointers of this node point to itself 
            root.left = root.right = root;
            
            return ConcatenateDLL(ConcatenateDLL(left, right), root);
        }

        public Node ConcatenateDLL(Node leftList, Node rightList) {
            if(leftList == null) {
                return rightList;
            }
            if(rightList == null) {
                return leftList;
            }

            // Store the last of both left and right list
            Node leftLast = leftList.left;
            Node rightLast = rightList.left;

            // Connect both left and right list
            leftLast.right = rightList;
            rightList.left = leftLast;
            leftList.left = rightLast;
            rightLast.right = leftList;
            return leftList;
        }

        public void InorderTraversal(Node root, List<Node> list) {
            if(root == null) {
                return;
            }
            
            InorderTraversal(root.left,list);
            //System.Console.WriteLine(root.data);
            list.Add(root);
            InorderTraversal(root.right, list);

        }

        public Node ConvertBinaryTreetoCListUsingList(Node root) {
            if(root == null) {
                return null;
            }
            List<Node> list = new List<Node>();
            InorderTraversal(root, list);
            Node head = list[0];

            //create a current pointer
            Node current = head;

            for(int i = 1; i < list.Count; i++) {
                // create a temporary pointer
                Node temp = current;
                
                // current's right points to list[i]
                current.right = new Node(list[i].data);

                // move current
                current = current.right;

                // current's left points to temp
                current.left = temp;
            }

            // make this doubly list to circular by connecting current's right and head's left
            //current's right points to head of the list
            current.right = head;

            //current's left points to current
            head.left = current;

            return head;
        }
    }
}