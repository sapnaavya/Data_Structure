/**
 * This code checks whether a tower is hoppable or not with the givem maximum no of hops for each tower 
 */
public class HoppableTower {

    public static boolean isHoppable(int[] arr)
    {
        return helper(arr, 0);
    }

    public static boolean helper(int[] arr, int index)
    {
        int limit = arr[index];

        // 0 steps hopping further
        if (limit == 0)
            return false;
        // if hopping upto limit from the current index, can cross the array
        else if (index + limit >= arr.length) // MISTAKE 1 make sure to put else if .. not if
            return true;
        else // MISTAKE 2 make sure to put else block 
        {
            // check hopping from next index upto the limit 
            for (int i = index + 1; i <= index + limit; i++)
            {
                if (helper(arr, i))
                {
                    return true;
                }
            }
        }

        // could not cross the array.
        return false;
    }


    //main method
    public static void main(String args[]) {
        int [] arr = new int[]{1, 2, 0, 0, 2, 0};  
        System.out.println("Tower is Hoppable " + isHoppable(arr));
    }
}