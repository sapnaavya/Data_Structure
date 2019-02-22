/**
 * Find the pair in an array whose sum with complexity O(n). This assumes
 * the array passed is sorted array and there are no duplicates in the array
 * 
 * @param arr
 *            input array of elements
 * @param k
 *            sum for which pair of array elements needs to be searched
 */
import java.util.Scanner;
public class finElemThatSumto {
    public static String getPair2(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;
     
        // output array to record matching pairs
        StringBuilder arrs = new StringBuilder(); 
        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum == k) {
                // we have found one pair, add it to our output array
                arrs.append(arr[start] + "," + arr[end] + ";");
                start++;
                end--;
            } else if (sum < k) {
                // if the sum of the pair is less than the sum we are searching
                // then increment the start pointer which would give us the sum
                // more than our current sum as the array is sorted
                start++;
            } else {
                // if the sum of the pair is greater than the sum we are searching
                // then decrement the end pointer which would give us the sum
                // less than our current sum as the array is sorted
                end--;
            }
        }
        return arrs.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int length = sc.nextInt();
        System.out.println("Enter the sum of the elements:");
        int sum = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int [] myArray = new int[length]; 
        for(int i=0; i<length; i++) {
            myArray[i] = sc.nextInt();
        }
        String pairs = getPair2 (myArray, sum);
        System.out.println("Pair is:" + pairs);
    }
}
