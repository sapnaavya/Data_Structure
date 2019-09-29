import java.util.*;

public class RotateImage {
    public static int[][] rotateImgOutPlace(int[][] arr) {
        int len = arr.length;
        int [][] rotateArray =  new int[len][len];
        
        for (int i = 0; i < len; i++) { 
            for(int j = 0; j < len; j++) {
                rotateArray[i][j] = arr[len-j-1][i];
            }
        }
        return rotateArray;
    }

    public static int[][] rotateImageInplace(int[][] arr) {
        if (arr == null || arr.length == 0 || arr.length != arr[0].length) {
            int [][] emptyArray = null;
            return  emptyArray;
        }
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            for(int j = i; j < n-i-1; j++) {
                int top = arr[i][j];
                //Left -> Top
                arr[i][j] = arr[n-j-1][i];
                //bottom -> left
                arr[n-j-1][i] = arr[n-i-1][n-j-1];
                //right -> bottom
                arr[n-i-1][n-j-1] = arr[j][n-i-1];
                //top -> right
                arr[j][n-i-1] = top; 
            }
        }
        return arr;
    }
    public static void main(String args[]) {
        int[][]arr = {{1,2,3,4},{3,6,7,8}, {3,4,5,6},{2,1,4,1}};
        System.out.println("Array before Rotating 90 degree");
        System.out.println(Arrays.deepToString(arr));
        // arr = rotateImgOutPlace(arr);
        // System.out.println("Array elements after Rotating 90 degree - OutPlace" + Arrays.deepToString(arr));
        arr = rotateImageInplace(arr);
        System.out.println("Array elements after Rotating 90 degree - Inplace" + Arrays.deepToString(arr));
    }
}