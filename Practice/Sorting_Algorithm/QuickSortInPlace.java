import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = sc.nextInt();
        }
        solution.quickSort(array);
    }
    public void quickSort(int[] array){
         quickSort(array, 0, array.length-1);
    }
    public void quickSort(int[] array, int from, int to){
        if((to-from) >= 1){
            int pivotPosition = partition(array, from, to);
            print(array);
            quickSort(array, from, pivotPosition-1);
            quickSort(array, pivotPosition+1, to);
        }     
    }
    private int partition(int[] array, int from, int to){
        int pivot = array[to];
        int wallIndex = from;
        for(int currentIndex = from; currentIndex<to; currentIndex++){
            if(array[currentIndex] < pivot){
                swap(array, wallIndex, currentIndex);
                ++wallIndex;
            }
        }
        swap(array, wallIndex, to);
        return wallIndex;
        
    }
    public void swap(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
    private void print(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
