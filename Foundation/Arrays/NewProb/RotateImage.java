/**
 * This code rotated N*N 2 D matrix by 90 degree
 */
import java.util.*;

public class RotateImage {
    public static int[][] rotateImgOutPlace(int[][] arr) {
        int rowlen = arr.length;
        int colLen = arr[0].length;
        int [][] rotateArray =  new int[colLen][rowlen];
        
        for (int i = 0; i < rowlen; i++) { 
            for(int j = 0; j < colLen; j++) {
                rotateArray[i][j] = arr[rowlen-j-1][i];
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
        int[][]arr = {{1,2,3},{3,6,7}, {3,4,5},{2,1,4}};
        System.out.println("Array before Rotating 90 degree");
        System.out.println(Arrays.deepToString(arr));
        arr = rotateImgOutPlace(arr);
        System.out.println("Array elements after Rotating 90 degree - OutPlace" + Arrays.deepToString(arr));
        // arr = rotateImageInplace(arr);
        // System.out.println("Array elements after Rotating 90 degree - Inplace" + Arrays.deepToString(arr));
    }
}