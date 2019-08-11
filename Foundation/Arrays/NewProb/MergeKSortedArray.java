/**
 * This code implements the algorithm to merge k sorted array using priority queues
 * References: https://www.byte-by-byte.com/mergekarrays/
*/

import java.util.PriorityQueue;

public class MergeKSortedArray {

    //QueueNode class to hold the index of the current element in the array, value and index of the current array
    private static class QueueNode implements Comparable<QueueNode> {
        int array, index, value;
        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        public int compareTo(QueueNode n) {
            if(value > n.value) return 1;
            if(value < n.value) return -1;
            return 0;
        }
    }
    
    //merge k sorted array using priority queue
    public static int[] mergeKSortedArray(int[][] arr) {
        //System.out.println(arr.length);
        PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
        int size = 0;
        
        //add first elements of each array in priority queue.. i.e. add every row's first element
        //every row represents one array
        for(int i = 0; i < arr.length; i++) {
            size += arr[i].length;
            if(arr[i].length > 0) {
                pq.add(new QueueNode(i, 0, arr[i][0]));
            }
        }

        int[] result = new int[size];
        for(int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            result[i] = n.value;
            //check if that is the last element in the array if its not then check the next index
            int newIndex = n.index + 1;
            if(newIndex < arr[n.array].length) {
                pq.add(new QueueNode(n.array, newIndex, arr[n.array][newIndex]));
            }
        }
        return result;
    }

    //main method
    public static void main(String args[]) {
        int[][] arr = {{1,10}, {3,4,6}, {7,8,9}};
        int[] kSortedArray = mergeKSortedArray(arr);
        for(int i = 0; i < kSortedArray.length; i++) {
            System.out.println(kSortedArray[i]);
        }
    }
}