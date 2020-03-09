using System;
using System.Collections.Generic;

namespace Foundation {
    public class TreeTraversal {
        Node root;

        public void Inorder(Node root) {
            if(root == null) {
                return;
            }

            Stack<Node> stack = new Stack<Node>();
            System.Console.Write("Inorder: ");
            while(stack.Count != 0 || root != null) {
                if(root != null) {
                    stack.Push(root);
                    root = root.left;
                } else {
                    Node temp = stack.Pop();
                    System.Console.Write(temp.data + " ");
                    root = temp.right;
                }
            } 
        }

        public void PreOrder(Node root) {
            if(root == null) {
                return;
            }
            Stack<Node> stack = new Stack<Node>();
            stack.Push(root);
            System.Console.WriteLine();
            System.Console.Write("Preorder: ");
            while(stack.Count != 0) {
                Node temp = stack.Pop();
                System.Console.Write(temp.data + " ");
                if(temp.right != null){
                    stack.Push(temp.right);
                }
                if(temp.left != null) {
                    stack.Push(temp.left);
                }
            }
        }

        public void PostOrder(Node root) {
            if(root == null) {
                return;
            }
            
            Stack<Node> stack = new Stack<Node>();
            System.Console.WriteLine();
            System.Console.Write("Postorder: ");
            while(true) {
                while(root != null) {
                    stack.Push(root);
                    stack.Push(root);
                    root = root.left;
                }

                if(stack.Count == 0) {
                    return;
                }

                Node temp = stack.Pop();
                if(stack.Count != 0 && temp.data == stack.Peek().data) {
                    root = temp.right;
                } else {
                    System.Console.Write(temp.data + " ");
                    root = null;
                }
            }
        }

        // Print top level view of the tree
        public void PrintTopLevel(Node root) {
            if(root == null) {
                return;
            }

            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            while(current != null) {
                stack.Push(current);
                current = current.left;
            }
            // traverse left side first - bottom to top
            while(stack.Count != 0) {
                Node temp = stack.Pop();
                System.Console.Write(temp.data + " ");
            }

            // traverse right side - top to bottom
            current = root.right;
            while(current != null) {
                System.Console.Write(current.data + " ");
                current = current.right;
            }
        }
    }
}