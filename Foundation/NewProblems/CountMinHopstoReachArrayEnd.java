/**
 * This code counts the minimum no of hops required to reach the end of array. 
 * Please note that it does not guarantee to reach out of the array.
    Two ways:
    1. Bruteforce:
        A naive approach is to start from the first element and recursively call for all the elements reachable from first element. 
        The minimum number of jumps to reach end from first can be calculated using minimum number of jumps needed to reach end from the elements reachable from first.
    
    2. Dynamic Programming:
        In this method, we build a jumps[] array from left to right such that jumps[i] indicates the minimum number of jumps needed to reach arr[i] from arr[0]. 
        Finally, we return jumps[n-1].
    
 */
public class CountMinHopstoReachArrayEnd {
    static int minHops;

    public static int countMinHops(int[] arr)
    {
        int length = arr.length;
        return countHops(arr, 0, length);
    }

    //Bruteforce approach to count minimum no of hops in hoppable tower
    public static int countHops(int[] arr, int index, int length)
    {   
        if (index == length) 
            return 0;

        // 0 steps hopping further
        if (arr[index] == 0)
            return Integer.MAX_VALUE;
        // if hopping upto limit from the current index, can cross the array
        
        // check hopping from next index upto the limit 
        int min = Integer.MAX_VALUE; 
        for (int i = index + 1; i <= length && i <= index + arr[index]; i++)
        {
            int jumps = countHops(arr, i, length); 
            // System.out.println("jumps" + jumps);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }

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
        jumps[0] = 0;  // MISTAKE - 1

        //find the minimum no of jumps required to reach arr[i] from arr[0],
        //assign this value to jumps[i]
        for(i = 1; i < n; i++) { // MISTAKE - 2 START FOR LOOP FROM 1
            jumps[i] = Integer.MAX_VALUE;
            for(j = 0; j < i; j++) {
                //check if i is in the range of j.
                //In other words, check if we can reach to j from i
                if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1); // MISTAKE - 3 jumps[i] not jumps[j]
                }
            }
        }

        //return last step
        return jumps[n - 1];
    }


    //main method
    public static void main(String args[]) {
        //int [] arr = new int[]{4, 3, 0, 0, 2, 1};  
        int [] arr = new int[]{4, 3, 1, 6, 2, 1};
        System.out.println("Minimum no of hops required: " + countMinHops(arr));
        System.out.println("(Optimized) Min hops requred: " + countHopsOptimized(arr));
    }
}