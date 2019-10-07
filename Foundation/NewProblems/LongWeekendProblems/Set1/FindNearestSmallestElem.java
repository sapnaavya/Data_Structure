/**
 * This code finds the next smallest element in the array
 * Reference: https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/ 
   Example:
    Input:  arr[] = {1, 6, 4, 10, 2, 5}
    Output:         {_, 1, 1,  4, 1, 2}

 */

import java.util.Stack;

public class FindNearestSmallestElem {
    public static void printPrevSmallerRecur(int [] arr, int n) {
        if(arr.length == 0) {
            return;
        }

        System.out.print("_" + " ");

        for(int i = 1; i < n; i++) {
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            
            if(j == -1) {
                System.out.print("_" + " ");
            }
        }
    }

    // Using Stack: function to find nearest smallest element on the left side of array
    // Input:  arr[] = {1, 6, 4, 10, 2, 5}
   //  Output:         {_, 1, 1,  4, 1, 2}
    public static void printPrevSmallUsingStack(int[] arr, int n) {
        // Create an empty stack
        Stack<Integer> stack = new Stack<>();

        // Traverse thro all the elements
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                System.out.print("_" + " ");
            } else {
                System.out.print(stack.peek() + " ");
            }

            // push this element
            stack.push(arr[i]);
        }
    }
    
    // main method
    public static void main(String args[]) {
        int []arr = {1, 1, 4, 10, 2, 5}; 
		int n = arr.length; 
        printPrevSmallerRecur(arr, n); 
        System.out.println();
        printPrevSmallUsingStack(arr, n);
    }
}