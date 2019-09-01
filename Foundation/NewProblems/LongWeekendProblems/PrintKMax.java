import java.util.Deque;
import java.util.LinkedList;

/**
 * This code prints the maximum element in k size subarray using two ways:
 * 1. two for loop: 
    * Time Complexity : The outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer loop. 
    * So, time complexity is O((n-k+1)*k) which can also be written as O(N * K).
    2. Using Dequeue:
        Time complexity:
        Every element on an average is compared only once for remove operation  from the front-end of the list
        Thus, for every element of the array there are constant number of operations that are performed on it
        making time complexity as O(n)

        Space Complexity:
        The extra space used by this algorithm is O(k) since the maximum length of list at any point does not exceed k

    References:
    1. https://www.youtube.com/watch?time_continue=1579&v=39grPZtywyQ
    2. https://algorithms.tutorialhorizon.com/sliding-window-algorithm-track-the-maximum-of-each-subarray-of-size-k/
    3. https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
    */

public class PrintKMax {
    //  function to print maximum element in k size subarray
    // This function uses two for loop
    static void printkMaxSubArray(int[] arr, int k) {
        int n = arr.length;
        for(int i = 0; i <= n-k; i++) {
            int max = arr[i];
            for(int j = 1; j < k; j++) {
                if(arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            System.out.print(max + " ");
        }
    }

    //This function print k max element using Deque
    //Please note that we only store indexes in the deque.. not the array elements
    public static void printKmaxDeque(int[] arr, int k) {
        if(arr.length == 0 || k <= 0 || k > arr.length) {
            return;
        }

        Deque<Integer> deq = new LinkedList<Integer>();
        int n = arr.length;
        //add first k element in the deque
        for(int i = 0; i < k; i++) {
            while(!deq.isEmpty() && arr[i] > arr[deq.peekLast()]) {
                deq.removeLast();
            }
            //add element back in the queue
            deq.addLast(i);
        }

        //process rest of the element from k to n-1
        for(int i = k; i < n; i++) {
            //The element in the front queue is the biggest element from the 
            //previous window. So, print it
            System.out.print(arr[deq.peekFirst()] + " ");

            //remove elements which are out of window
            while(!deq.isEmpty() && deq.peekFirst() <= i-k) {
                deq.removeFirst();
            }

            //remove elements which are smaller than current window elements
            //remove useless elements
            while(!deq.isEmpty() && arr[i] >= arr[deq.peekLast()]) {
                deq.removeLast();
            }

            //add current element at the rear of the queue
            deq.addLast(i);
        }

        //print the maximum element of the last window
        System.out.println(arr[deq.peek()]);
    }

    //main method
    public static void main(String args[]) {
        int[] arr = {25,12,20,50,45};
        int k = 3;
        printkMaxSubArray(arr, k);
        System.out.print("\n");
        printKmaxDeque(arr, k);
    }
}