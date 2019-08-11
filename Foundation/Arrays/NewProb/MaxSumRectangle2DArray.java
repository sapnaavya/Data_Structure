/**
 * Program to to calculate maximum size rectangle in 2d array
 
 * Complexity:
    * Space complexity of this algorithm is O(row)
    * Time complexity of this algorithm is O(row*col*col)
  
 * Solution:
    * Keep temp array with size as number of rows. Start left and right from 0
    * and keep adding values for each row and maintain them in this temp array.
    * Run Kadane's algorithm to find max sum subarray in temp. Now increment right by 1. 
    * When right reaches last column reset right to 1 and left to 1.

 * Reference: https://www.youtube.com/watch?v=yCQN096CwWM 

 */
public class MaxSumRectangle2DArray {

    //Result class to hold maxsum subarray in 1d array
    class KadaneResult {
        int maxSum;
        int start; 
        int end;
        KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    //Result class to hold coordinates of maxsum in 2d array
    class Result {
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;
        Result(){}
        Result(int maxSum, int leftBound, int rightBound, int upBound, int lowBound) {
            this.maxSum = maxSum;
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            this.upBound = upBound;
            this.lowBound = lowBound;
        }
    }

    //function to get maximum size rectangle in 2d array
    public Result maxSum2Darray(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        int temp[] = new int[rows];
        Result result = new Result();

        for(int left = 0; left < cols; left++) {
            //initialize temp array to 0 
            for(int i = 0; i < rows; i++) {
                temp[i] = 0;
            }

            for(int right = left; right < cols; right++) {
                //get the data into temp array
                for(int i = 0; i < rows; i++) {
                    temp[i] += input[i][right];
                }

                KadaneResult kadaneResult = maxSumSubArray(temp);
                if(kadaneResult.maxSum > result.maxSum) {
                    result.maxSum = kadaneResult.maxSum;
                    result.leftBound = left;
                    result.rightBound = right;
                    result.upBound = kadaneResult.start;
                    result.lowBound = kadaneResult.end;
                }
            }  
        }
        return result;
    }


    //Kadane's algorithm to get max size subarray in 1d Array
    public KadaneResult maxSumSubArray(int[] arr) {
        if(arr.length == 0) {
            return null;
        }

        int maxSum = 0;
        int maxSofar = arr[0];
        int maxstart = 0;
        int maxEnd = 0;
        int currStart = 0;

        for(int i = 0; i < arr.length; i++) {
            maxSum = maxSum + arr[i];
            if(maxSum > maxSofar) {
                maxSofar = maxSum;
                maxstart = currStart;
                maxEnd = i;
            } else if(maxSum < 0) {
                maxSum = 0;
                currStart = i + 1;
            }
        }

        return new KadaneResult(maxSofar, maxstart,maxEnd);
    }

    //main method
    public static void main(String args[]) {
        int input[][] = {{ 2,  1, -3, -4,  5},

                         { 0,  6,  3,  4,  1},

                         { 2, -2, -1,  4, -5},

                         {-3,  3,  1,  0,  3}};

        MaxSumRectangle2DArray obj = new MaxSumRectangle2DArray();
        Result result = obj.maxSum2Darray(input);
        System.out.println("maxSum " + result.maxSum + " " + "leftBound " + result.leftBound + " "
            + "rightBound " + result.rightBound + " " 
            + "lowBound " + result.lowBound + " "
            + "upperBound " + result.upBound);
    }
}