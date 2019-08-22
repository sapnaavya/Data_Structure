/* A java program to find maximum sum in a subArray*/

import java.util.*;
public class MaximumSumSubArray {
    
    public void maxSumSubArray (int [] arr) {
        if(arr.length == 0) {
            return;
        }
        int start = 0;
        int end = 0;
        int s = 0;
        int i;
        int maxSofar = arr[0];
        int maxSum = 0;
        for(i=0; i<arr.length; i++) {
            maxSum = maxSum + arr[i];
            if(maxSofar < maxSum){
                maxSofar = maxSum;
                start = s;
                end = i;
            }
    
            if(maxSum < 0) {
                maxSum = 0;
                s = i+1;
            }   
        }
        System.out.println("The maximum sum of subarray" + maxSum);
        for(int j  = start; j <= end; j++) {
            System.out.println(arr[j] + " ");
        }

    }
    //Main method
    public static void main(String args[]) {
       MaximumSumSubArray maxSum = new MaximumSumSubArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int length = sc.nextInt();
        int [] arr = new int[length];
        for(int i=0; i<length; i++) {
            arr[i] = sc.nextInt();
        }
        maxSum.maxSumSubArray(arr);
        sc.close();
    }
}