/*
 *
 * Egg Drop Problem:
 *  This code calculates minimum no of trials to findout from which floor the egg will break with n eggs and k floor.
 *  what is the least number of egg dropping that is guaranteed to find the highest floor from which egg wont break at all
 *  References: 
 *      1. https://www.bing.com/videos/search?q=egg+drop+problem&&view=detail&mid=82F4C1A42C8902B4619B82F4C1A42C8902B4619B&&FORM=VRDGAR
 *      2. https://www.bing.com/videos/search?q=egg+drop+problem&&view=detail&mid=9FB332667D1E339D56949FB332667D1E339D5694&&FORM=VRDGAR  
 *      3. https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
*/

public class EggDropProblem {
    // recursive function to count minimum number of tries to findout from which floor egg will break
    static int eggDrop(int n, int k) {
        if(k == 0 || k == 1) {
            return k;
        }

        // We need k trials for one egg  
        // and k floors 
        if(n == 1) {
            return k;
        }
        
        int min = Integer.MAX_VALUE;
        int i, res;
        // Consider all droppings from  
        //1st floor to kth floor and  
        // return the minimum of these  
        // values plus 1.
        for(i = 1; i <= k; i++) {
            res = Math.max(eggDrop(n-1, i-1), eggDrop(n, k-i));
            if(res < min) {
                min = res;
            }
        }
        return min + 1;
    }

    /* Function to get minimum number of trials needed in worst case with n eggs and k floors 
        time complexity - O(n*n*e)
        space complexity - O(nk)
    */
    
    static int eggDropDP(int n, int k) {
        int[][] eggFloor = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        //we need one trial for one floor and 0 trial for 0 floor
        for(i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        //we always need j trials for one egg and j floors
        for(j = 1; j <= k; j++) {
            eggFloor[1][j] = j;
        }

        //fill rest of the entries in table using optimal substructure
        for(i = 2; i <= n; i++) {                 //eggs   //n
            for(j = 2; j <= k; j++) {             // floor //n
                eggFloor[i][j] = Integer.MAX_VALUE;      
                for(x = 1; x <= j; x++) {         //e
                    res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if(res < eggFloor[i][j]) {
                        eggFloor[i][j] = res;
                    }
                }
            }
        }

        //eggfloor[n][k] holds the result
        return eggFloor[n][k];
    }

    //main method
    public static void main(String args[]) {
        int n = 2;
        int k = 6;
        System.out.println(eggDrop(n, k));
        System.out.println(eggDropDP(n, k));
    }
}