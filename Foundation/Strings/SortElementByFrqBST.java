/*
    * This code implements the code to sorts the array elements based on frequency using BST
    References: 1. https://www.concretepage.com/java/jdk-8/java-8-stream-sorted-example#map
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

// Data class
class Data {
    public int number;
    public int frequency;

    public Data(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}

// Node class
class Node {
    public Data data;
    public Node left;
    public Node right;

    public Node(Data data) {
        this.data = data;
    }
}

//BST class
class CreatBST {
    public Node add(Integer[] input) {
        Node root = null;
        for(Integer i: input) {
            root = add(root, new Data(i,1));
        }
        return root;
    }

    private Node add(Node root, Data data) {
        if(root == null) {
            return new Node(data);
        } 
        if(data.number == root.data.number) {
            root.data.frequency = root.data.frequency + 1;
        } else if(data.number < root.data.number) {
            root.left = add(root.left, data);
        } else {
            root.right = add(root.right, data);
        }
        return root;
    }

    public void inorderToFlattenList(Node currRoot, List<Data> listData) {
        if(currRoot == null) {
            return;
        }

        inorderToFlattenList(currRoot.left, listData);
        listData.add(currRoot.data);
        inorderToFlattenList(currRoot.right, listData);
    }
}

//public class to sort elements by frequency
public class SortElementByFrqBST{

    //main method
    public static void main(String args[]) {
        Integer[] input = new Integer[]{5, 3, 7, 7, 7, 5, 4, 8, 6, 6};
        CreatBST bst = new CreatBST();

        //create a bst tree with number and its frequency
        Node added = bst.add(input);

        //inorder traversal to flatten into array
        List<Data> flattened = new ArrayList<Data>();
        bst.inorderToFlattenList(added, flattened);

        //sort by frequency
        List<Data> listSortedByFrequency = flattened.stream()
                                           .sorted((e1, e2) -> e2.frequency - e1.frequency)
                                           .collect(Collectors.toList());
        
        List<Integer> output = new ArrayList<Integer>();
        for(Data data : listSortedByFrequency) {
            int frequency = data.frequency;
            for(int i = 0; i < frequency; i++) {
                output.add(data.number);
            }
        }

        System.out.println(output);
    }
}