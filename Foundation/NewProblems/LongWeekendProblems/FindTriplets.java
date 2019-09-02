/**
 * This code finds the triplets whose sum is equal to zero
 * Reference: https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
*/
import java.util.Arrays;

public class FindTriplets {

    // Time complexity - O(n*n*n)
    public static void findTriplets(int[] arr, int n) {
        boolean found = false;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        System.out.print(arr[i]); 
                        System.out.print(" "); 
                        System.out.print(arr[j]); 
                        System.out.print(" "); 
                        System.out.print(arr[k]); 
                        System.out.print("\n"); 
                        found = true;
                    }
                }
            }
        }

        if(found == false) {
            System.out.println("Does not exist");
        }
    }

    // Using sorting: function to find triplats as zero sum
    // We can solve in O(1) extra space.
    public static void findTripletsSorting(int [] arr, int n) {
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for(int i = 0; i < n-1; i++) {
            int left = i + 1;
            int right = n - 1;
            int x = arr[i];
            while(left < right) {
                if(x + arr[left] + arr[right] == 0) {
                    // print elements when its sum is zero
                    System.out.print(x + " "); 
                    System.out.print(arr[left]+ " "); 
                    System.out.println(arr[right]+ " "); 
                    left++;
                    right--;
                    found = true;
                } else if(x + arr[left] + arr[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        if(found == false) {
            System.out.println("No Triplet found");
        }
    }

    // main method
    public static void main(String args[]) {
        int arr[] = {0, -1, 2, -3, 1}; 
        int n =arr.length; 
        findTriplets(arr, n); 
        findTripletsSorting(arr, n); 
    }
} 