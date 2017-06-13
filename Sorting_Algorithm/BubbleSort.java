import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int cou = BubbleSort(a);
          System.out.println("Array is sorted in" +" "+ cou +" "+ "swaps.");
          System.out.println("First Element:"+ " "+ a[0]); 
          System.out.println("Last Element:"+ " "+ a[n-1]); 
       }
    public static int BubbleSort(int[] a){
        int temp;
        int count = 0;
        int noOfSwaps = 0;
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    noOfSwaps++;
                    count++;
                }
            }
            if(noOfSwaps == 0){
                break;
            }
        }
        return count;
    }
}
