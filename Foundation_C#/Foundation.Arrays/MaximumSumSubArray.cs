namespace Foundation.Arrays {
    public class MaximumSumSubArray {
        public void Maximum_Sum_SubArray(int[] arr) {
            if(arr.Length == 0) {
                return;
            }

            int start = 0;
            int s = 0;
            int end = 0;
            int n = arr.Length;
            int maxSoFar = arr[0];
            int maxSum = 0;
            for(int i = 0; i < n; i++) {
                maxSum = maxSum + arr[i];
                if(maxSoFar < maxSum) {
                    maxSoFar = maxSum;
                    start = s;
                    end = i;
                }
                if(maxSum < 0) {
                    maxSum = 0;
                    s = i + 1;
                }
            }
            for(int i = start; i <= end; i++) {
                System.Console.Write(arr[i] + " ");
            }
        }
    }
}