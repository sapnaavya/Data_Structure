import java.util.Stack;

/**
 * This code calculates the area of largest rectangle in the histogram
 * Reference:
 * https://buttercola.blogspot.com/2014/09/leetcode-largest-rectangle-in-histogram.html
 * https://www.programcreek.com/2014/05/leetcode-lar gest-rectangle-in-histogram-java/
 */
public class LargestRectangleHistogram {

    // function to calculates area of largest rectangle using two for loop
    public static int calculateRectangleArea(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int minV;
        for(int i = 0; i < height.length; i++) {
            minV = height[i];
            for(int j = i; j < height.length; j++) {
                minV = Math.min(minV, height[j]);
                int area = (j - i + 1) * minV;
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // function to calculate area of largest rectangle using stack
    public static int calculateAreaRectangleStack(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while( i < height.length) {
            if(stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int h = height[top];
                int w = stack.isEmpty() ? 0 : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
        }

        while(!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;  
    }
    // main method
    public static void main(String args[]) {
        // int[] arr = {2,1,5,7,8,3};
        int[] arr = {2,1,4,5,6,2,3,2};
        int area = calculateRectangleArea(arr);
        int area1 = calculateRectangleArea(arr);
        System.out.println(area);
        System.out.println(area1);
    }
}