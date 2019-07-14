/**
 * This code prints the sum of k elements in the array using two approaches:
 * 1. Using two for loop
 * 2. using Deque
*/

public class SumKElements {
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

    //main method
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 5;
        sumKMax(arr, k);

    }
}