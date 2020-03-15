using System;

namespace Foundation {
    public class RotateImage {

        public void RotateImageOutPlace(int[][] arr) {
            if(arr == null) {
                return;
            }

            int [][] rotatedArr = new int[4][]{new int[4] {1,2,3,4}, new int[4]{4,5,6,7}, new int[4]{5,6,7,8}, new int[4]{1,2,3,4} };
            int n = arr.Length;
            for(int i = 0; i < arr.Length; i++) {
                for(int j = 0; j < arr.Length; j++) {
                    rotatedArr[i][j] = arr[n-j-1][i];
                }
            }

            for(int i = 0; i < rotatedArr.Length; i++) {
                for(int j = 0; j < rotatedArr.Length; j++) {
                    System.Console.Write(rotatedArr[i][j] + " ");
                }
                System.Console.WriteLine();
            }
        }
        public void Rotate_ImageInPlace(int n, int[,] arr) {
            if(arr == null ) {
                return;
            }
           for(int i = 0; i < n/2; i++) {
               for(int j = i; j < n-i-1; j++) {
                   int top = arr[i,j];
                   //left -> top
                   arr[i,j] = arr[n-j-1, i];
                   
                   //bottom -> left
                   arr[n-j-1, i] = arr[n-i-1, n-j-1];
                   
                   //right -> bottom
                   arr[n-i-1, n-j-1] = arr[j, n-i-1];

                   //top -> right
                   arr[j, n-i-1] = top;
               }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.Console.Write(arr[i, j] + " ");
                }
                System.Console.WriteLine();
            }
        }

        // static void Main(string[] args)
        // {
        // //Rotate an n*n 2d array by 90 degreee
        //     RotateImage image = new RotateImage();
        //     // Two-dimensional array.
        //     int[][] array2D = new int[4][] {new int[4] { 1, 2, 5, 6 },new int[4]{ 3, 4, 7, 8 },new int[4]{ 5, 6, 9, 10 }, new int[4]{ 7, 8, 3, 2 } };
        //     image.Rotate_ImageInPlace(array2D);
        // }
    }
}