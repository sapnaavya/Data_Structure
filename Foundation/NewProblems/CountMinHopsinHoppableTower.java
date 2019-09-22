/**
 * This code counts the minimum no of hops required to come out of the hoopable tower (not at the end of the tower)
    Dynamic Programming:
        In this method, we build a jumps[] array from left to right such that jumps[i] indicates the minimum number of jumps needed to reach arr[i] from arr[0]. 
        Finally, we return jumps[n-1].

        Example -> 6, 0, 0, 0, 0, 0
                   5, 0, 0, 0, 2, 0
                   1, 2, 3, 4, 5, 0
                   
    
*/

public class CountMinHopsinHoppableTower {

    //Optimized method to count minimum no of hops to reach the end of the array - Dynamic Programming
    public static int countHopsOptimized(int [] arr) {
        int n = arr.length;
        int [] jumps = new int[n];
        int i, j;

        //if first element is 0 then end can not achieved
        if(n == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }

        //assign the starting index as 0.. DO NOT FORGET THIS
        jumps[0] = 0; 

        //find the minimum no of jumps required to reach arr[i] from arr[0],
        //assign this value to jumps[i]
        for(i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for(j = 0; j < i; j++) {
                //check if i is in the range of j.
                //In other words, check if we can reach to j from i
                if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    if(j + arr[j] >= arr.length) {    
                        return jumps[i];
                    }
                }
            }
        }

        //To come out of the array in case of hoppable tower, check if last element of array is not 0
        // if last element is 0 
        if(arr[n - 1] != 0 && jumps[n - 1] != Integer.MAX_VALUE) {
            return jumps[n - 1];
        } else {
            return Integer.MAX_VALUE;
        }
    }


    //main method
    public static void main(String args[]) {
        int [] arr = new int[]{5, 0, 0, 0, 2, 0};
        System.out.println("minimum hops required to come out of tower: " + countHopsOptimized(arr));
    }
}