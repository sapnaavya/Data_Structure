import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public  static void leftRotate(int[] array, int n, int d){
        for(int i=0; i<d; i++){
          leftRotation(array, d, n);    
        }
        
        for(int j=0; j<n; j++){
            System.out.print(array[j] + " ");
        }
    }
    
    public static void leftRotation(int[] array, int d, int n){
    int i, temp;
        temp = array[0];
        for(i=0;i<n-1;i++){
            array[i] = array[i+1];
        }
        array[i] = temp;
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int num = sc. nextInt();
        int d = sc.nextInt();
        int[] array = new int[num];
        for(int i=0; i<num; i++){
            array[i] =  sc.nextInt();
        }
        int n = array.length;
        leftRotate(array, n,d);
        
    }
}
