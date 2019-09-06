/**
 * This code implements square root of an integer number
*/

public class ImplementSQRT {
    public static long sqrt(int num) {

        // base case
        if(num == 0 || num == 1) {
            return num;
        }

        // do binary search 
        long start = 1;
        long end = num;
        long ans = 0;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long check = mid*mid;

            // if x is a perfect square
            if(check == num) {
                return mid;
            }

            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x)

            if(check < num) {
                start = mid + 1;
                ans = mid;
            }

            else {
                // If mid*mid is greater than x
                end = mid - 1;
            }
        }
        return ans;
    }

    // main method
    public static void main(String args[]) {
        int val = 30;
        long sqrtVal = sqrt(val);
        System.out.println(sqrtVal);
    }
}