/**
 * This code prints the sum of k elements in the array using two approaches:
 * 1. Using two for loop
 * 2. using Deque
*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;

public class SumKElements {
    //function to calculate sum of k elements in the arrays using two for loop
    public static void sumKMax(int[] arr, int k) {
        if(arr.length == 0 || k > arr.length || k < 0) {
            return;
        }

        for(int i = 0; i <= arr.length - k; i++) {
            int sum = arr[i];
            for(int j = 1; j < k; j++) {
                sum = sum + arr[i +  j];
            }
            System.out.print(sum + " ");
        }
    }

    //function to calculate sum of k elements using deque
    public static void sumKElements(int [] arr, int k) {
        if(arr.length == 0 || k <= 0 || k > arr.length) {
            return;
        }
        Deque<Integer> deq = new LinkedList<>();
        int n = arr.length;
        int sum = 0;;
        int i;
        for(i = 0; i <= n; i++) {
            while(!deq.isEmpty() && deq.peekFirst() < i-k) {
                deq.removeFirst();
            }

            sum = 0;
            if(deq.size() == k) {
                for(Integer obj: deq) {
                    sum += arr[obj];
                }
                
                System.out.print(sum + " ");
            }
            deq.addLast(i);
        }
    }

    //main method
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 4;
        sumKMax(arr, k);
        System.out.print("\n");
        sumKElements(arr, k);

    }
}