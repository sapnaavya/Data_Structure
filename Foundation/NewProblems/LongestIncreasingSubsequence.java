/**
 * Code to calculate longest increasing subsequence
 * Reference: https://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/
 */

import java.util.Arrays;
public class LongestIncreasingSubsequence {

    // Iterative function to generate longest increasing subsequence 
    public static int longestIncreaseSubseq(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        int result = 0;
        int[] max = new int[arr.length];
        Arrays.fill(max, 1);
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            result = Math.max(result, max[i]);
        }

        return result;
    }
    
    // main method
    public static void main(String args[]) {
        int[] arr = {9,1,3,7,5,6,20,25};
        int LIS = longestIncreaseSubseq(arr);
        System.out.println(LIS);
    }
}