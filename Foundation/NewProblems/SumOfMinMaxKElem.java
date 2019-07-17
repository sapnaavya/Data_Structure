/**
 * This code calculates the sum of min and max in k size subarray using two approaches:
 * 1. Two for loop:
        * Run two loops to generate all subarrays of size k and find maximum and minimum values. 
        * Finally return sum of all maximum and minimum elements. 

    2. Using Deque: 
*/

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMaxKElem {
    //function to calculate sum of two min and max in k size subarray
    public static int sumofMinMaxKElem(int[] arr, int k) {
        if(arr.length == 0 || k <= 0 || k > arr.length) {
            return 0;
        }
        int n = arr.length;
        int sum = 0;
        int min, max;
        for(int i = 0; i <= n-k; i++) {
            min = arr[i];
            max = arr[i];
            for(int j = 1; j < k; j++) {
                if(arr[i + j] > max) {
                    max = arr[i + j];
                }
                if(arr[i + j] < min) {
                    min = arr[i + j];
                }
            }
            sum += min + max;
        }   
        return sum;  
    }

    //function to calculate the sum of min and max element in k size subarray
    public static int sumofKSizeMinandMaxDeq(int[] arr, int k) {
        if(arr.length == 0 || k <= 0 || k > arr.length) {
            return 0;
        }
        Deque<Integer> minDeq = new LinkedList<>();
        Deque<Integer> maxDeq = new LinkedList<>();
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i < k; i++) {
            while(!minDeq.isEmpty() && arr[minDeq.peekFirst()] >= arr[i]) {
                minDeq.removeLast();
            }
            while(!maxDeq.isEmpty() && arr[maxDeq.peekFirst()] <= arr[i]) {
                maxDeq.removeLast();
            }
            minDeq.addLast(i);
            maxDeq.addLast(i);
        }
        for(int i = k; i < n; i++) {
            sum += arr[minDeq.peekFirst()] + arr[maxDeq.peekFirst()];
            
            //remove elements which are out of the current window size
            while(!minDeq.isEmpty() && minDeq.peekFirst() <= i - k) {
                minDeq.removeFirst();
            }
            while(!maxDeq.isEmpty() && maxDeq.peekFirst() <= i - k) {
                maxDeq.removeFirst();
            }

            while(!minDeq.isEmpty() && arr[minDeq.peekLast()] >= arr[i]) {
                minDeq.removeLast();
            }
            while(!maxDeq.isEmpty() && arr[maxDeq.peekLast()] <= arr[i]) {
                maxDeq.removeLast();
            }

            //add element in minque and maxque
            minDeq.addLast(i);
            maxDeq.addLast(i);
        }
        // add sum of minimum and maximum of last window
        sum += arr[minDeq.peekFirst()] + arr[maxDeq.peekFirst()];
        return sum;
    }
    //main method
    public static void main(String args[]) {
        int[] arr = {2, 5, -1, 7,3,4,5,-4,7,8,-1};
        int k = 3;
        int sumofMinMax = sumofMinMaxKElem(arr, k);
        int sumofMinMaxDeq = sumofKSizeMinandMaxDeq(arr, k);
        System.out.println(sumofMinMax);
        System.out.println(sumofMinMaxDeq);
    }
}