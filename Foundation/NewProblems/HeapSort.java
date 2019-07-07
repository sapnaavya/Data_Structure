/**
 * This code sorts the array using heap sort algorithm. Please take care to do buildmaxheap and buildmin heap before doing this
 * Approach: 
    Heap Sort Algorithm for sorting in increasing order:
    1. Build a max heap from the input data.
    2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
    3. Repeat above steps while size of heap is greater than 1.

    Time Complexity: Time complexity of heapify is O(Logn). 
    Time complexity of createAndBuildHeap() is O(n) and overall time complexity of Heap Sort is O(nLogn).

*/
public class HeapSort {

    //this function sorts the array using heap sort
    public void sort(int [] arr){
        if(arr.length == 0) {
            return;
        }

        int n = arr.length;
        //index of non-leaf node
        int startIdx = (n / 2) - 1;
        //Build heap (rearrange array)
        for(int i = startIdx; i >= 0 ; i--) {
            heapify(arr, i, n);
        }

        //One by one extract an element from heap 
        for(int i = n-1; i>= 0; i--) {
            //move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap 
            heapify(arr, 0, i); 
        }
    }

    static void heapify(int[] arr, int i, int n) {

        int largest = i; //root
        int left = (2 * i) + 1; //left node
        int right = (2 * i) + 2; //right
        
        // If left child is larger than root 
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than root 
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            //heapify again the affected subtree
            heapify(arr, largest, n); 
        }
    }

    //print array
    public static void printArray(int [] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //main method
    public static void main(String args[]) {
        int[] arr = {12, 11, 13, 5, 6, 7}; 
        HeapSort obj = new HeapSort();
        obj.sort(arr);

        System.out.println("Sorted array: "); 
        printArray(arr); 
    } 
}