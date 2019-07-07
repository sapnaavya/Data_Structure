/**
 * This code builds the max heap from the array i.e children of the root node are smaller than root node
 * Remember: 
 *  1. root is at index 0
 *  2. Left child of ith node - 2*i+1
 *  3. Right child of ith node - 2*i+2
 *  4. Most important -> index of first non-leaf node : (n/2) - 1
 *  
 *  -> Start heapify process on each non-leaf node in reverse level order traversal
 */

 public class BuildMaxHeap {

    //function to build max heap from array
    public static void buildMaxHeap(int[] arr, int n) {
        if(arr.length == 0) {
            return;
        }

        //find index of non-leaf node and start traversing each non leaf node in reverse level order traversal
        int startIdx = (n / 2) - 1;
        for(int i = startIdx; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    //This function performs heapify process on subtree
    static void heapify(int[] arr, int i, int n) {

        int largest = i; //initialize root as larget
        int left = (2 * i) + 1; //left node
        int right = (2 * i) + 2; //right node

        // If left child is larger than root
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than root
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        //if largest is not root
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            //recursively heapfy the affected subtree
            heapify(arr, largest, n);
        }  
    }

    // print heap implementation
    public static void printMaxHeap(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //main method
    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int n = arr.length;
        buildMaxHeap(arr, n);
        printMaxHeap(arr, n);
    }
 }