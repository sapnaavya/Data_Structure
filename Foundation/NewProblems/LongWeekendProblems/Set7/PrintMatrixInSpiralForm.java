/**
 * This code prints matrix in spiral form
 * Reference: https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class PrintMatrixInSpiralForm {
    static int R = 4;
    static int C = 4;
    
    // function to print matrix in spiral form
    public static void printMatrix(int[][] arr, int i, int j, int nRows, int nCols) {
        if(i >= nRows || j >= nRows) {
            return;
        }

        // print first row
        for(int p = i; p < nCols; p++) {
            System.out.print(arr[i][p] + " ");
        }

        // print last column
        for(int p = i+1; p < nRows; p++) {
            System.out.print(arr[p][nCols-1] + " ");
        }

        // print last row, if last and first row are not same
        if((nRows - 1) != i) {
            for(int p = nCols - 2; p >= j; p--) {
                System.out.print(arr[nRows - 1][p] + " "); 
            }
        }

        // print first column, if last and first column are not same
        if((nCols - 1) != j) {
            for(int p = nRows - 2; p > i; p--) {
                System.out.print(arr[p][j] + " "); 
            }
        }
    
        printMatrix(arr, i + 1, j + 1, nRows - 1, nCols - 1); 
    }

    // main method
    public static void main(String args[]) {
        int a[][] = {{1, 2, 3, 4}, 
                     {5, 6, 7, 8}, 
                     {9, 10, 11, 12}, 
                     {13, 14, 15, 16}}; 
  
        printMatrix(a, 0, 0, R, C); 
    }
}