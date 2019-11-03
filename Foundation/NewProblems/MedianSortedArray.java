/**
 * This code find the median in two sorted arrays
 * Reference: 
 * 1. https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
*/

public class MedianSortedArray {

    //function to find median in two sorted array
    public double findMedianSortedArray(int[] input1, int[] input2) {
        if(input1.length > input2.length) {
            return findMedianSortedArray(input2, input1);
        }
        
        int x = input1.length;
        int y = input2.length;
        int low = 0;
        int high = x;
        while(low <= high) {

            int partitionX = (low + high)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x+y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    // main method
    public static void main(String args[]) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        MedianSortedArray mm = new MedianSortedArray();
        double num = mm.findMedianSortedArray(x, y);
        System.out.println(num);
    }
}