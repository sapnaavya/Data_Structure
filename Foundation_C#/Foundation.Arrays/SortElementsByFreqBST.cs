using System.Collections.Generic;

namespace Foundation.Arrays {

    // Data class 
    public class Data {
        public int Number {get; set;}
        public int Frequency {get; set;}
        public Data (int number, int Frequency) {
            this.Number = number;
            this.Frequency = Frequency;
        }
    }

    // Node class 
    public class Node {
        public Data Data { get; set; }
        public Node Left { get; set; }
        public Node Right { get; set; }
        public Node(Data data) {
            this.Data = data;

        }
    }

    //BST Class
    public class CreateBST {
        public Node Add(int[] input) {
            Node root = null;
            foreach(int i in input) {
                root = Add(root, new Data(i, 1));
            }
            return root;
        }

        public Node Add(Node root, Data data) {
            if(root == null) {
                return new Node(data);
            }
            if(data.Number == root.Data.Number) {
                root.Data.Frequency += 1; 
            } else if(data.Number < root.Data.Number) {
                root.Left = Add(root.Left, data);
            } else {
                root.Right = Add(root.Right, data);
            }

            return root;
        }

        public void InorderToFlattenList(Node currRoot, List<Data> listData) {
            if(currRoot == null) {
                return;
            }

            InorderToFlattenList(currRoot.Left, listData);
            listData.Add(currRoot.Data);
            InorderToFlattenList(currRoot.Right, listData);
        }
    }
}