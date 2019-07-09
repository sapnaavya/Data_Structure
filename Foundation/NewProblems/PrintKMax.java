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
 */
public class PrintKMax {
    //function to print maximum element in k size subarray
    //This function uses two for loop
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
    //main method
    public static void main(String args[]) {
        int[] arr = {25,12,30,10,5};
        int k = 2;
        printkMaxSubArray(arr, k);
    }
}