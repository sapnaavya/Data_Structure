/**
 * This code merge k sorted array using MinHeap
 * Approach:
 * 1. Create an output array of size n*k.
   2. Create a min heap of size k and insert 1st element in all the arrays into the heap
   3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. 
        If the array doesn’t have any more elements, then replace root with infinite. 
        After replacing the root, heapify the tree.
 */
class MinHeapNode {
    int element;
    int i; //index of the array from which element is taken
    int j; //index of the next element to be picked from array
    public MinHeapNode(int element, int i, int j) {
        this.element = element;
        this.i = i;
        this.j = j;
    }
}

public class MergeKSortedArrayMinHeap {
    MinHeapNode[] harr;
    int heap_size;
    public MergeKSortedArrayMinHeap(MinHeapNode[] arr, int size) {
        heap_size = size;
        harr = arr;
        int i = (heap_size - 1)/2;
        while(i >= 0) {
            minheapify(i);
            i--;
        }
    }

    void minheapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if(left < heap_size && harr[left].element < harr[i].element) {
            smallest = left;
        }
        if(right < heap_size && harr[right].element < harr[smallest].element) {
            smallest = right;
        }

        if(smallest != i) {
            MinHeapNode temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            minheapify(smallest);
        }

    }

    MinHeapNode getMin() {
        if(heap_size <= 0) {
            System.out.println("heap underflow");
            return null;
        }
        return harr[0];
    }

    void replaceMin(MinHeapNode root) {
        harr[0] = root;
        minheapify(0);
    }

    //function to merge sorted array using min heap 
    public static int[] mergeKSortedArray(int[][] arr, int k){
        MinHeapNode[] harr = new MinHeapNode[k];
        int result_size = 0;
        for(int i = 0; i < arr.length; i++) {
            MinHeapNode node = new MinHeapNode(arr[i][0], i, 1);
            harr[i] = node;
            result_size += arr[i].length;
        }

        //create a min heap with k heap node. 
        //Every heap node has first element of an array
        MergeKSortedArrayMinHeap mh = new MergeKSortedArrayMinHeap(harr, k);
        int[] result = new int[result_size];

        for(int i = 0; i < result_size; i++) {
            // get the minimum element and store it in the result
            MinHeapNode root = mh.getMin();
            result[i] = root.element;

            //find the next element that will replace the current root of the heap.
            // the next element belongs to the same array as current root
            if(root.j < arr[root.i].length) {
                root.element = arr[root.i][root.j++];
            } else {
                root.element = Integer.MAX_VALUE;
            }

            //replace root with next element of the array
            mh.replaceMin(root);

        }
        return result;
    }
    //main method
    public static void main(String args[]) {
        int[][] arr = {{2,2,3}, {4,5,6}, {6,7,8,10},{9,10,12,13}};
        int[] sortedArray = mergeKSortedArray(arr, arr.length);
        for(int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + "  ");
        }

    }
}