import java.util.HashMap;

import jdk.nashorn.internal.ir.debug.PrintVisitor;

/**
 * This code finds the largest zero sum subarray
 * References: https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 * Test cases: {-2, 2, -8, +8, 10, -10}
 *             {0,0,0,0}
 *             {0}
 *             { 15, -2, 2, -8, 1, 7, 10, 23 }; 
 */
public class LargestSubArrZeroSum {

    // brute force method to calculate largest subarray with sum as zero
    public static int maxLen(int[] arr, int n) {
        if(arr.length == 0) {
            return 0;
        }
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            // initialize curr_sum for every starting point
            int curr_sum = 0;

            // try all subarrays with 'i'
            for(int j = i; j < n; j++) {
                curr_sum += arr[j];
                // if curr_sum is zero then update maxlen
                if(curr_sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // function to find zero sum subarray using HashMap Data Structure
    // another example: -2, 2, -8, 1, 7, 10, -5, -4, -1, 23
    public static int maxLenZeroSumSubArray(int [] arr, int n) {
        if(arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i = 0 ; i < n; i++) {
            // add current element to sum
            sum += arr[i];

            if(arr[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }

            if(sum == 0) {
                maxLen = i + 1;
            }

            // look for this sum in the hash map
            Integer prev = map.get(sum);
            if(prev != null) {
                maxLen = Math.max(maxLen, i - prev);
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    // main method
    public static void main(String args[]) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
        int n = arr.length; 
        System.out.println("Length of the longest 0 sum "
                           + "subarray:(Bruteforce) " + maxLen(arr, n)); 
        
        System.out.println("Length of the longest 0 sum "
                            + "subarray: (HashMap) " + maxLenZeroSumSubArray(arr, n));   
    }
}